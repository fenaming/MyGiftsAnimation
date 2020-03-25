package com.fenaming.mytest.model;

/**
 * @author fenaming
 * @date 2020/3/25
 * @e-mail fenaming@163.com
 * @description 礼物实体类
 */
public class GiftSendModel {
    private int giftCount; //数字展示重复数量，礼物数-1；
    private String userAvatarRes; //用户头像
    private String nickname; //用户昵称
    private String sig; //“送一个火箭”
    private int giftRes; //礼物资源
    private String gift_id; //礼物id

    public int getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(int giftCount) {
        this.giftCount = giftCount;
    }

    public String getUserAvatarRes() {
        return userAvatarRes;
    }

    public void setUserAvatarRes(String userAvatarRes) {
        this.userAvatarRes = userAvatarRes;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public int getGiftRes() {
        return giftRes;
    }

    public void setGiftRes(int giftRes) {
        this.giftRes = giftRes;
    }

    public String getGift_id() {
        return gift_id;
    }

    public void setGift_id(String gift_id) {
        this.gift_id = gift_id;
    }
}
