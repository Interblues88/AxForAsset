package com.example.axforasset;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

public class CustomDialogFragment extends DialogFragment {

    private String message;
    private boolean isSuccess;

    public static CustomDialogFragment newInstance(String message, boolean isSuccess) {
        CustomDialogFragment fragment = new CustomDialogFragment();
        Bundle args = new Bundle();
        args.putString("message", message);
        args.putBoolean("isSuccess", isSuccess);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_custom, null);

        TextView title = dialogView.findViewById(R.id.dialog_title);
        TextView messageText = dialogView.findViewById(R.id.dialog_message);
        Button button = dialogView.findViewById(R.id.dialog_button);

        if (getArguments() != null) {
            message = getArguments().getString("message");
            isSuccess = getArguments().getBoolean("isSuccess");
        }

        title.setText(isSuccess ? "Success!" : "Error");
        messageText.setText(message);

        builder.setView(dialogView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        return builder.create();
    }
}
