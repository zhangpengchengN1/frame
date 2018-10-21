package com.example.pengcheng.frame.utils.view.adinfo;

import java.util.List;

/**
 * Created by 张鹏程 on 2017/7/22.
 */

public class AdBaseInfo {

    private String AD_ID;//主键id

    private String AD_NO;//编号

    private String TITLE;//标题

    private String TYPE_ID;//广告类型id

    private String TYPE_NAME;//广告类型

    private String STATE;//状态 1、发布 0、未发布

    private String ORDER_NO;//排序

    private String REMARKS;//备注

    private String LINK_URL;//链接地址

    private String CREATE_TIME;//创建时间

    private String UPDATE_TIME;//更新时间

    private String CREATE_USER_ID;//创建人id

    private String CREATE_USER;//创建人

    private String PLATFORM_TYPE;//广告平台 1、app 2、盒子

    private String BOX_POSITION;//盒子位置 平台为盒子时起作用 1、全屏 2、半屏

    private String CLICK_AMOUNT;//点击次数

    private String SUBSCRIBE_STATUS;//订阅状态 1、订阅 2、取消

    private String SUBSCRIBE_ID;

    private List<String> list;//图片文件

    private String REGION_NAME;//发布地址

    private String SHARE_THUMBNAIL;//分享缩略图

    private String SHARE_TITLE;//分享标题

    private String SHARE_MAIN_IMG;//分享主图

    public String getSHARE_THUMBNAIL() {
        return SHARE_THUMBNAIL;
    }

    public void setSHARE_THUMBNAIL(String SHARE_THUMBNAIL) {
        this.SHARE_THUMBNAIL = SHARE_THUMBNAIL;
    }

    public String getSHARE_TITLE() {
        return SHARE_TITLE;
    }

    public void setSHARE_TITLE(String SHARE_TITLE) {
        this.SHARE_TITLE = SHARE_TITLE;
    }

    public String getSHARE_MAIN_IMG() {
        return SHARE_MAIN_IMG;
    }

    public void setSHARE_MAIN_IMG(String SHARE_MAIN_IMG) {
        this.SHARE_MAIN_IMG = SHARE_MAIN_IMG;
    }

    public String getREGION_NAME() {
        return REGION_NAME;
    }

    public void setREGION_NAME(String REGION_NAME) {
        this.REGION_NAME = REGION_NAME;
    }

    public String getSUBSCRIBE_ID() {
        return SUBSCRIBE_ID;
    }

    public void setSUBSCRIBE_ID(String SUBSCRIBE_ID) {
        this.SUBSCRIBE_ID = SUBSCRIBE_ID;
    }

    public String getCLICK_AMOUNT() {
        return CLICK_AMOUNT;
    }

    public void setCLICK_AMOUNT(String CLICK_AMOUNT) {
        this.CLICK_AMOUNT = CLICK_AMOUNT;
    }

    public String getSUBSCRIBE_STATUS() {
        return SUBSCRIBE_STATUS;
    }

    public void setSUBSCRIBE_STATUS(String SUBSCRIBE_STATUS) {
        this.SUBSCRIBE_STATUS = SUBSCRIBE_STATUS;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getAD_ID() {
        return AD_ID;
    }

    public void setAD_ID(String AD_ID) {
        this.AD_ID = AD_ID;
    }

    public String getAD_NO() {
        return AD_NO;
    }

    public void setAD_NO(String AD_NO) {
        this.AD_NO = AD_NO;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(String TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }

    public String getTYPE_NAME() {
        return TYPE_NAME;
    }

    public void setTYPE_NAME(String TYPE_NAME) {
        this.TYPE_NAME = TYPE_NAME;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getORDER_NO() {
        return ORDER_NO;
    }

    public void setORDER_NO(String ORDER_NO) {
        this.ORDER_NO = ORDER_NO;
    }

    public String getREMARKS() {
        return REMARKS;
    }

    public void setREMARKS(String REMARKS) {
        this.REMARKS = REMARKS;
    }

    public String getLINK_URL() {
        return LINK_URL;
    }

    public void setLINK_URL(String LINK_URL) {
        this.LINK_URL = LINK_URL;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(String UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public String getCREATE_USER_ID() {
        return CREATE_USER_ID;
    }

    public void setCREATE_USER_ID(String CREATE_USER_ID) {
        this.CREATE_USER_ID = CREATE_USER_ID;
    }

    public String getCREATE_USER() {
        return CREATE_USER;
    }

    public void setCREATE_USER(String CREATE_USER) {
        this.CREATE_USER = CREATE_USER;
    }

    public String getPLATFORM_TYPE() {
        return PLATFORM_TYPE;
    }

    public void setPLATFORM_TYPE(String PLATFORM_TYPE) {
        this.PLATFORM_TYPE = PLATFORM_TYPE;
    }

    public String getBOX_POSITION() {
        return BOX_POSITION;
    }

    public void setBOX_POSITION(String BOX_POSITION) {
        this.BOX_POSITION = BOX_POSITION;
    }
}
