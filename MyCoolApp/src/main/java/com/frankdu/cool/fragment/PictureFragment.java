package com.frankdu.cool.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.frankdu.common.BaseFragment;
import com.frankdu.cool.R;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class PictureFragment extends BaseFragment {

    /**
     * Inject the instance
     */
    @Inject
    Picasso mPicasso;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_picture, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String imageUrl = "https://graph.facebook.com/du.frank/picture?type=large";

        ImageView imageView = getView(R.id.profile_image_view);
        mPicasso.load(imageUrl).into(imageView);

    }
}
