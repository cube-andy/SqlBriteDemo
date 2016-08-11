package com.ztiany.sqlbritedemo.todocagetory;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.squareup.sqlbrite.BriteDatabase;
import com.ztiany.data.entity.TodoCategoryEntity;
import com.ztiany.data.entity.TodoCategoryModel;
import com.ztiany.sqlbritedemo.AppContext;
import com.ztiany.sqlbritedemo.R;
import com.ztiany.sqlbritedemo.utils.ToastUtil;

import javax.inject.Inject;

/**
 * <br/>    功能描述：
 * <br/>    Email     : ztiany3@gmail.com
 *
 * @author Ztiany
 * @see
 * @since 1.0
 */

public class CreateCategoryFragment extends AppCompatDialogFragment {

    public static CreateCategoryFragment newInstance() {
        return new CreateCategoryFragment();
    }

    @Inject
    BriteDatabase mBriteDatabase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppContext.getAppComponent().inject(this);
    }





    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View view = View.inflate(getContext(),R.layout.dialog_new_category, null);


        final EditText editText = (EditText) view.findViewById(android.R.id.input);

        return new AlertDialog.Builder(getContext())
                .setTitle("new Category")
                .setView(view)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (TextUtils.isEmpty(editText.getText())) {
                            ToastUtil.showToast("enter a category name");

                            return;
                        }
                        addCategory(editText.getText().toString());

                    }
                }).create();

    }

    private void addCategory(String s) {
        mBriteDatabase.insert(
                TodoCategoryModel.TABLE_NAME, TodoCategoryEntity.
                        FACTORY
                        .marshal()
                        .name(s)
                        .asContentValues()
        );
        dismiss();
    }
}
