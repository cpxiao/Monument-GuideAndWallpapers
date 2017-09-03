package com.cpxiao.monument_guideandwallpapers.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cpxiao.R;
import com.cpxiao.gamelib.fragment.BaseFragment;

/**
 * @author cpxiao on 2017/08/30.
 */

public class FullscreenFragment extends BaseFragment {
    public static final String ID = "ID";
    private ImageView mImageView;

    public static FullscreenFragment newInstance(Bundle bundle) {
        FullscreenFragment fragment = new FullscreenFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mImageView = (ImageView) view.findViewById(R.id.gif_image_view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int id = bundle.getInt(ID, -1);
            if (id != -1) {
                //此处不要用glide加载，比较卡。用pl.droidsonroids.gif.GifImageView
                mImageView.setImageResource(id);
                //                Glide.with(getActivity()).load(id).into(mImageView);
            } else {
                onDestroy();
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fullscreen;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImageView != null) {
            mImageView.clearAnimation();
            mImageView.destroyDrawingCache();
        }
    }
}
