package com.rxandroid.elice.skeletonpj.presentation.view.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.rxandroid.elice.skeletonpj.R;

import butterknife.ButterKnife;

/**
 * Created by elice.kim on 2017. 7. 15..
 */

public class BaseActivity extends AppCompatActivity {

    boolean dialogVisible;
    private AlertDialog loadingDialog;

    /**
     * dialog
     */
    public void showLoading() {
        hideLoading();
        dialogVisible = true;

        buildNewLoadingDialog().show();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    /**
     * common progressbar hide
     */
    public void hideLoading() {
        if (isDialogShowing()) {
            dialogVisible = false;
            try {
                if (loadingDialog != null) {
                    loadingDialog.dismiss();
                }
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    /**
     * common progressbar checking
     */
    boolean isDialogShowing() {
        return dialogVisible;
    }

    /**
     * common progressbar show
     */
    AlertDialog buildNewLoadingDialog() {
        loadingDialog = new AlertDialog.Builder(this)
                .setView(R.layout.dialog_loading)
                .setCancelable(false)
                .create();

        loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return loadingDialog;
    }
}
