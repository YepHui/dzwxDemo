package com.example.dzwxdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class TextUtils {

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private SpannableStringBuilder strBuilder;

        private Builder() {
            strBuilder = new SpannableStringBuilder();
        }

        public Builder append(CharSequence text) {
            strBuilder.append(text);
            return this;
        }

        public Builder append(CharSequence text, int color) {

            int start = strBuilder.length();
            strBuilder.append(text);
            int end = strBuilder.length();
            strBuilder.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return this;
        }

        public Builder replace(CharSequence text, int color, String... replaces) {

            strBuilder.append(text);
            for (int i = 0; i < replaces.length; i++) {
                String replace = replaces[i];
                int start = text.toString().indexOf(replace);
                if (start >= 0) {
                    int end = start + replace.length();
                    strBuilder.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }

            return this;
        }

        public Builder click(CharSequence text, final int color, final OnClickListener onClickListener,String... clickTexts) {

            strBuilder.append(text);

            for (int i = 0; i < clickTexts.length; i++) {

                String clickText = clickTexts[i];
                final int postion=i;
                int start = text.toString().indexOf(clickText);
                if (start >= 0) {
                    int end = start + clickText.length();
                    strBuilder.setSpan(new ClickableSpan() {
                        @Override
                        public void onClick(View view) {
                            if (onClickListener != null) {
                                onClickListener.onClick(postion);
                            }
                        }

                        @Override
                        public void updateDrawState(TextPaint ds) {
                            super.updateDrawState(ds);
                            ds.setColor(color);
                            ds.setUnderlineText(false);
                        }
                    }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
            return this;
        }

        private boolean isChecked = false;
        //??????????????? ????????????????????????strBuilder.append()??????????????????????????????????????????strBuilder???????????????????????????????????????
        public Builder checkBox(Context context, TextView tv, OnImageClickListener listener){
            setImageSpan(context, strBuilder, R.drawable.uncheck);
            strBuilder.setSpan(new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    isChecked = !isChecked;
                    if (isChecked){
                        setImageSpan(context, strBuilder, R.drawable.checked);
                        tv.setText(strBuilder);//????????????
                        listener.onChecked();
                    } else {
                        setImageSpan(context, strBuilder, R.drawable.uncheck);
                        tv.setText(strBuilder);
                        listener.onUnChecked();
                    }
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setColor(Color.WHITE);
                    ds.setUnderlineText(false);
                }
            }, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return this;
        }

        public Builder clickInto(TextView tv) {
            tv.setMovementMethod(LinkMovementMethod.getInstance());//?????????????????????
            tv.setHighlightColor(Color.TRANSPARENT); //?????????????????????????????????
            tv.setText(strBuilder);
            return this;
        }

        public Builder into(TextView tv) {
            tv.setText(strBuilder);
            return this;
        }
    }

    public interface OnClickListener {
        void onClick(int position);
    }

    public interface OnImageClickListener{
        void onChecked();
        void onUnChecked();
    }

    private static void setImageSpan(Context context, SpannableStringBuilder builder, int resourceId){
        MyImageSpan imageSpan = new MyImageSpan(context, resourceId, 2);//????????????
        builder.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    public static class MyImageSpan extends ImageSpan {
        //??????????????????????????????,?????????ImageSpan??????????????????????????????????????????????????????ImageSpan,??????draw??????,??????????????????
        public MyImageSpan(@NonNull Context context, int resourceId, int verticalAlignment) {
            super(context, resourceId, verticalAlignment);
        }

        @Override
        public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            //???????????????????????????????????????????????????
            Paint.FontMetricsInt fm = paint.getFontMetricsInt();
            int transY = bottom - drawable.getBounds().bottom;
            if (mVerticalAlignment == ALIGN_BASELINE) {
                transY -= fm.descent;
            } else if (mVerticalAlignment == ALIGN_CENTER) {//?????????????????????
                //???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                // y+ascent????????????????????????????????????y+descent?????????????????????????????????????????????+???????????????/2=???????????????????????????
                transY = ((y + fm.descent) + (y + fm.ascent)) / 2 - drawable.getBounds().bottom / 2;
            }
            canvas.translate(x, transY);
            drawable.draw(canvas);
            canvas.restore();
        }
    }
}