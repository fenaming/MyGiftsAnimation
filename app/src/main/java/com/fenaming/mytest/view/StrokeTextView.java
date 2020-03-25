package com.fenaming.mytest.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author fenaming
 * @date 2020/3/25
 * @e-mail fenaming@163.com
 * @description 描边字体-引入下载的字体库
 */
public class StrokeTextView extends TextView {

    private TextView outlineTextView = null;
    private TextPaint strokePaint;
    private Context mContext;

    public StrokeTextView(Context context) {
        super(context);
        mContext = context;

        outlineTextView = new TextView(context);
    }

    public StrokeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        outlineTextView = new TextView(context, attrs);
    }

    public StrokeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;

        outlineTextView = new TextView(context, attrs, defStyle);
    }

    @Override
    public void setLayoutParams (ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        outlineTextView.setLayoutParams(params);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        AssetManager manager = mContext.getAssets();
//        String path = "fonts/live_show_gifts_num.ttf";
//        Typeface type = Typeface.createFromAsset(manager, path);
//
//        //设置轮廓文字
//        CharSequence outlineText = outlineTextView.getText();
//        if (outlineText == null || !outlineText.equals(this.getText())) {
//            outlineTextView.setText(getText());
//            outlineTextView.setTypeface(type);
//            setTypeface(type);
//            postInvalidate();
//        }
//        outlineTextView.measure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout (boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        outlineTextView.layout(left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        AssetManager manager = mContext.getAssets();
//        String path = "fonts/live_show_gifts_num.ttf";
//        Typeface type = Typeface.createFromAsset(manager, path);
        if (strokePaint == null) {
            strokePaint = new TextPaint();
        }
        //复制原来TextViewg画笔中的一些参数
        TextPaint paint = getPaint();
        strokePaint.setTextSize(paint.getTextSize());
        strokePaint.setTypeface(paint.getTypeface());
        strokePaint.setFlags(paint.getFlags());
        strokePaint.setAlpha(paint.getAlpha());

        //自定义描边效果
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(Color.parseColor("#FFFFFF"));
        strokePaint.setStrokeWidth(2);

        String text = getText().toString();

        //在文本底层画出带描边的文本
        canvas.drawText(text, (getWidth() - strokePaint.measureText(text)) / 2,
                getBaseline(), strokePaint);
    }
}