package com.example.pengcheng.frame.network.api;

/**
 * volatile
 *1）它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，
 * 也不会把前面的指令排到内存屏障的后面；即在执行到内存屏障这句指令时，在它前面的操作已经全部完成；
 *2）它会强制将对缓存的修改操作立即写入主存；
 *3）如果是写操作，它会导致其他CPU中对应的缓存行无效
 */

public class BaseRetrofit extends HttpManager{
    public BaseRetrofit() {
        super();
    }
    private volatile static BaseRetrofit api = null;
    public static BaseRetrofit getInstance() {
        if (api == null) {
            synchronized (BaseRetrofit.class) {
                if (api == null) {
                    api = new BaseRetrofit();
                }
            }
        }
        return api;
    }
}
