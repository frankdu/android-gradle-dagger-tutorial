package com.frankdu.cool.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frankdu.common.BaseFragment;
import com.frankdu.cool.R;
import com.frankdu.cool.annotations.FacebookApiKey;
import com.frankdu.cool.annotations.FacebookApiSecret;

import javax.inject.Inject;

import dagger.Lazy;

public class IntroFragment extends BaseFragment {

    @Inject @FacebookApiKey
    String mFacebookApiKey;

    @Inject @FacebookApiSecret
    Lazy<String> mFacebookApiSecretLazy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String introHtmlText = "A cool Android project, which shows how to use gradle + dagger. Brought to you by <a href=\"https://twitter.com/frankdu\">@frankdu</a> ;-)";
        TextView introTextView = getView(R.id.intro_text);
        introTextView.setMovementMethod(LinkMovementMethod.getInstance());
        introTextView.setText(Html.fromHtml(introHtmlText));

        TextView keyTextView = getView(R.id.fb_api_key);
        keyTextView.setText(mFacebookApiKey);

        TextView secretTextView = getView(R.id.fb_api_secret);
        secretTextView.setText(mFacebookApiSecretLazy.get());
    }
}
