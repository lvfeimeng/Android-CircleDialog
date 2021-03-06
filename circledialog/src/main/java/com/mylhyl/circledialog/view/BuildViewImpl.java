package com.mylhyl.circledialog.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.mylhyl.circledialog.BuildView;
import com.mylhyl.circledialog.CircleParams;

/**
 * Created by hupei on 2017/3/29.
 * @hide
 */

public final  class BuildViewImpl implements BuildView {
    private Context mContext;
    private CircleParams mParams;
    private LinearLayout mRoot;
    private TitleView mTitleView;
    private BodyTextView mBodyTextView;
    private BodyItemsView mBodyItemsView;
    private BodyProgressView mBodyProgressView;
    private BodyInputView mBodyInputView;
    private ItemsButton mItemsButton;
    private MultipleButton mMultipleButton;

    public BuildViewImpl(Context context, CircleParams params) {
        this.mContext = context;
        this.mParams = params;
    }

    @Override
    public View buildRoot() {
        if (mRoot == null) {
            mRoot = new ScaleLinearLayout(mContext);
            mRoot.setOrientation(LinearLayout.VERTICAL);
        }
        return mRoot;
    }

    @Override
    public View buildTitle() {
        if (mTitleView == null) {
            mTitleView = new TitleView(mContext, mParams);
            mRoot.addView(mTitleView);
        }
        return mTitleView;
    }

    @Override
    public View buildText() {
        if (mBodyTextView == null) {
            mBodyTextView = new BodyTextView(mContext, mParams);
            mRoot.addView(mBodyTextView);
        }
        return mBodyTextView;
    }

    @Override
    public View refreshText() {
        if (mBodyTextView != null) mBodyTextView.refreshText();
        return mBodyTextView;
    }

    @Override
    public BodyItemsView buildItems() {
        if (mBodyItemsView == null) {
            mBodyItemsView = new BodyItemsView(mContext, mParams);
            mRoot.addView(mBodyItemsView);
        }
        return mBodyItemsView;
    }

    @Override
    public ItemsButton buildItemsButton() {
        if (mItemsButton == null) {
            mItemsButton = new ItemsButton(mContext, mParams);
            mRoot.addView(mItemsButton);
        }
        return mItemsButton;
    }

    @Override
    public ListView refreshItems() {
        if (mBodyItemsView != null) mBodyItemsView.refreshItems();
        return mBodyItemsView;
    }

    @Override
    public View buildProgress() {
        if (mBodyProgressView == null) {
            mBodyProgressView = new BodyProgressView(mContext, mParams);
            mRoot.addView(mBodyProgressView);
        }
        return mBodyProgressView;
    }


    @Override
    public View refreshProgress() {
        if (mBodyProgressView != null) mBodyProgressView.refreshProgress();
        return mBodyProgressView;
    }

    @Override
    public BodyInputView buildInput() {
        if (mBodyInputView == null) {
            mBodyInputView = new BodyInputView(mContext, mParams);
            mRoot.addView(mBodyInputView);
        }
        return mBodyInputView;
    }

    @Override
    public MultipleButton buildMultipleButton() {
        if (mMultipleButton == null) {
            mMultipleButton = new MultipleButton(mContext, mParams);
            DividerView dividerView = new DividerView(mContext);
            dividerView.setVertical();
            mRoot.addView(dividerView);
            mRoot.addView(mMultipleButton);
        }
        return mMultipleButton;
    }

    @Override
    public MultipleButton refreshMultipleButtonText() {
        if (mMultipleButton != null)
            mMultipleButton.refreshText();
        return mMultipleButton;
    }

    @Override
    public View getView() {
        return mRoot;
    }
}
