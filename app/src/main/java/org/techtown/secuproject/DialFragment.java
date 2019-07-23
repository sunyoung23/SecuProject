package org.techtown.secuproject;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.DialogFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialFragment extends android.support.v4.app.DialogFragment {


    public DialFragment() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        MainActivity mainActivity = (MainActivity)getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setTitle("타이틀입니다");
        builder.setMessage("메시지 입니다");
        builder.setIcon(R.drawable.good);
        DialogListener listener = new DialogListener();

        builder.setPositiveButton("positive", listener);
        builder.setNeutralButton("neutral", listener);
        builder.setNegativeButton("negative", listener);

        AlertDialog alert = builder.create();

        return alert;
    }

    class DialogListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            MainActivity activity = (MainActivity)getActivity();



        }
    }
}
