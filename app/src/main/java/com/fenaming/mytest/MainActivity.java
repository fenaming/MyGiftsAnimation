package com.fenaming.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.fenaming.mytest.model.GiftSendModel;
import com.fenaming.mytest.view.GiftFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private GiftFrameLayout giftFrameLayout1;
    private GiftFrameLayout giftFrameLayout2;

    List<GiftSendModel> giftSendModelList = new ArrayList<GiftSendModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.iv_image_view);

        mImageView.animate().translationX(500);
        mImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mImageView.animate().translationY(-100).alpha(0);
            }
        }, 2000);

        giftFrameLayout1 = (GiftFrameLayout) findViewById(R.id.gift_layout1);
        giftFrameLayout2 = (GiftFrameLayout) findViewById(R.id.gift_layout2);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starGiftAnimation(createGiftSendModel());
            }
        });
    }

    private GiftSendModel createGiftSendModel(){
        GiftSendModel giftSendModel = new GiftSendModel();
        giftSendModel.setGift_id("1");
        giftSendModel.setGiftCount(0);
        giftSendModel.setGiftRes(R.mipmap.ic_launcher);
        giftSendModel.setNickname("小明");
        giftSendModel.setSig(null);
        giftSendModel.setUserAvatarRes(null);
        return giftSendModel;
    }

    private void starGiftAnimation(GiftSendModel model){
        if (!giftFrameLayout1.isShowing()) {
            sendGiftAnimation(giftFrameLayout1,model);
        }else if(!giftFrameLayout2.isShowing()){
            sendGiftAnimation(giftFrameLayout2,model);
        }else{
            giftSendModelList.add(model);
        }
    }


    private void sendGiftAnimation(final GiftFrameLayout view, GiftSendModel model){
        view.setModel(model);
        AnimatorSet animatorSet = view.startAnimation(model.getGiftCount());
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                synchronized (giftSendModelList) {
                    if (giftSendModelList.size() > 0) {
                        view.startAnimation(giftSendModelList.get(giftSendModelList.size() - 1).getGiftCount());
                        giftSendModelList.remove(giftSendModelList.size() - 1);
                    }
                }
            }
        });
    }

}
