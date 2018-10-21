package com.example.pengcheng.frame.utils.view.adinfo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pengcheng.frame.R;
import com.example.pengcheng.frame.qrcode.QRCodeActivity;
import com.example.pengcheng.frame.utils.hint.ToastUtil;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

public class CycleTestActivity extends AppCompatActivity {

    private CycleViewPager cycleViewPager;
    private List<ADInfo> infos;
    private String[] imageUrls;
    private List<ImageView> views;
    private List<AdBaseInfo> adBaseInfoList;
    private int timeState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //----------------------沉浸式菜单栏--------------------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int bg = getResources().getColor(R.color.background);
            //给状态栏设置颜色。我设置透明。
            window.setStatusBarColor(bg);
            window.setNavigationBarColor(bg);
        }
        //----------------------------------------------------
        setContentView(R.layout.cycle_view_test);

        //----------------------使用播放 横幅 --------------------
        configImageLoader();
        initialize();
        //-----------------------------------------------------
    }

    @SuppressLint("NewApi")
    private void initialize() {
        infos = new ArrayList<>();
        views = new ArrayList<>();
        cycleViewPager = (CycleViewPager) getFragmentManager()
                .findFragmentById(R.id.fragment_cycle_viewpager_content2);

        for (int i = 0; i < imageUrls.length; i++) {
            ADInfo info = new ADInfo();
            info.setUrl(imageUrls[i]);
            info.setContent("图片-->" + i);
            infos.add(info);
        }

        // 将最后一个ImageView添加进来
        views.add(ViewFactory.getImageView(this, infos.get(infos.size() - 1).getUrl()));
        for (int i = 0; i < infos.size(); i++) {
            views.add(ViewFactory.getImageView(this, infos.get(i).getUrl()));
        }
        // 将第一个ImageView添加进来
        views.add(ViewFactory.getImageView(this, infos.get(0).getUrl()));

        // 设置循环，在调用setData方法前调用
        cycleViewPager.setCycle(true);

        // 在加载数据前设置是否循环
        cycleViewPager.setData(views, infos, mAdCycleViewListener);
        //设置轮播
        cycleViewPager.setWheel(true);

        // 设置轮播时间，默认5000ms
        cycleViewPager.setTime(2000);
        //设置圆点指示图标组居中显示，默认靠右
        cycleViewPager.setIndicatorCenter();
    }

    private CycleViewPager.ImageCycleViewListener mAdCycleViewListener = new CycleViewPager.ImageCycleViewListener() {

        @Override
        public void onImageClick(ADInfo info, int position, View imageView) {
            if (cycleViewPager.isCycle()) {
                position = position - 1;
                timeState = position;
                if (adBaseInfoList.get(timeState)
                        .getLINK_URL() == null || adBaseInfoList.get(timeState)
                        .getLINK_URL().equals("")) {
                    ToastUtil.showShort(getApplicationContext(), "请添加链接地址后再试");
                } else {
                    String url = adBaseInfoList.get(timeState)
                            .getLINK_URL();
                    //有网址 点击 跳转页面
                    Intent intent = new Intent(CycleTestActivity.this, QRCodeActivity.class);
                    intent.putExtra("BrowerUrl", url);
                    startActivity(intent);
                }
            }

        }

    };


    /**
     * 配置ImageLoder
     */
    private void configImageLoader() {
        // 初始化ImageLoader
        @SuppressWarnings("deprecation")
        DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.mipmap.no_info) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.no_info) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.no_info) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                // .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
                .build(); // 创建配置过得DisplayImageOption对象

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(options)
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }
}
