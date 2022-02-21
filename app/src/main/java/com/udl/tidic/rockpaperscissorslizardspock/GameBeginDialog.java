package com.udl.tidic.rockpaperscissorslizardspock;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.udl.tidic.rockpaperscissorslizardspock.models.Game;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameBeginDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameBeginDialog extends DialogFragment {

    private GameActivity activity;
    private TextInputLayout playerLayout;
    private TextInputEditText playerEditText;
    private String player;
    private View rootView;

    public GameBeginDialog() {
        // Required empty public constructor
    }

    public static GameBeginDialog newInstance(String title) {
        GameBeginDialog dialog = new GameBeginDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        dialog.setArguments(args);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(rootView)
                .setTitle(R.string.game_dialog_title)
                .setCancelable(false)
                .setPositiveButton(R.string.start, null)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.setOnShowListener(dialog -> {
            onDialogShow(alertDialog);
        });
        return alertDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_begin_dialog, container, false);
    }

    private void onDialogShow(AlertDialog dialog) {
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(v -> {
            onDoneClicked();
        });
    }

    private void onDoneClicked() {
        if (isAValidName(playerLayout, player) ) {
            Log.d("GameBeginDialog", "Starting the game");
            //TODO: Aqui hauriem de retornar a l'activitat amb el nom que hem recollit.
        }
    }

    private boolean isAValidName(TextInputLayout layout, String name) {
        if (TextUtils.isEmpty(name)) {
            layout.setErrorEnabled(true);
            layout.setError("Empty name");
            return false;
        }

        layout.setErrorEnabled(false);
        layout.setError("");
        return true;
    }
}