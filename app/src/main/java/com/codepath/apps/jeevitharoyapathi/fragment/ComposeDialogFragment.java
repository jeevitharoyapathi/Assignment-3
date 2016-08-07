package com.codepath.apps.jeevitharoyapathi.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.apps.jeevitharoyapathi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComposeDialogFragment extends DialogFragment {

    @BindView(R.id.NewTweet)
    EditText mBody;
    @BindView(R.id.tvRemainingCharCount)
    TextView mCount;
    private NewTweetListener mNewTweetListener;
    public final static String SETTINGS = "Settings";
    private static Context mContext;

    public static ComposeDialogFragment newInstance(Context context) {
        ComposeDialogFragment newDialogFragment = new ComposeDialogFragment();
        mContext = context;
        Bundle args = new Bundle();
        newDialogFragment.setArguments(args);
        return newDialogFragment;
    }

    public interface NewTweetListener {
        void onNewTweet();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mNewTweetListener = (NewTweetListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement Listener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View container = inflater.inflate(R.layout.fragment_compose, null);
        ButterKnife.bind(this, container);
        View view = inflater.inflate(R.layout.dialog_custom_title, null);
        builder.setCustomTitle(view);
        builder.setView(container);
        mBody.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(getActivity(), "fdsfsf", Toast.LENGTH_SHORT).show();
                //                mBody.setText(editable.toString());
//                if (mBody != null && !mBody.getText().equals("")) {
//                    mCount.setText(140 - editable.length());
//                }
            }
        });
        builder.setPositiveButton("Tweet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }
}
