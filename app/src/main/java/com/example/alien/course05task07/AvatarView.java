package com.example.alien.course05task07;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AvatarView extends LinearLayout {

    private ImageView mIvImage;
    private TextView mTvUserName;
    private TextView mTvState;

    public AvatarView(Context context) {
        this(context, null);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = inflate(context, R.layout.avatar_view, this);

        mIvImage = view.findViewById(R.id.ivImage);
        mTvUserName = view.findViewById(R.id.tvName);
        mTvState = view.findViewById(R.id.tvSate);
    }

    public void setImage(@DrawableRes int resId) {
        mIvImage.setImageResource(resId);
    }

    public void setUserName(CharSequence name) {
        mTvUserName.setText(name);
    }

    public void setState(boolean isOnline) {
        mTvState.setText(isOnline ? R.string.online : R.string.offline);
    }
//    public AvatarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//

}
