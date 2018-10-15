package com.example.alien.course05task07;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
        setOrientation(VERTICAL);
        View view = inflate(context, R.layout.avatar_view, this);

        mIvImage = view.findViewById(R.id.ivImage);
        mTvUserName = view.findViewById(R.id.tvName);
        mTvState = view.findViewById(R.id.tvSate);

        TypedArray mainTypedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AvatarView, 0, R.style.DefaultAvatarView);
        String userName = mainTypedArray.getString(R.styleable.AvatarView_userName);
        setUserName(userName);

        boolean isOnline = mainTypedArray.getBoolean(R.styleable.AvatarView_isOnline, false);
        setState(isOnline);

        Drawable icon = mainTypedArray.getDrawable(R.styleable.AvatarView_icon);
        setImage(icon);

        mainTypedArray.recycle();
    }

    public void setImage(Drawable drawable) {
        if (drawable != null) {
            mIvImage.setImageDrawable(drawable);
        } else {
            mIvImage.setImageResource(R.drawable.ic_account_box_black_24dp);
        }
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
