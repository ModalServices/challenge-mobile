package com.michelbarbosa.liveon.utils;

import android.content.Context;
import android.os.Build;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.michelbarbosa.liveon.R;

public class Util {

    public static boolean checkMinimalAPI(int buildVersionCode) {
        return Build.VERSION.SDK_INT >= buildVersionCode;
    }

    public static boolean validateEmail(Context context, EditText edEmail, TextView tvEmailStatus){
        String emailInput = edEmail.getText().toString().trim();
        if (emailInput.isEmpty()){
            tvEmailStatus.setVisibility(View.VISIBLE);
            edEmail.setBackground(context.getDrawable(R.drawable.ed_error));
            tvEmailStatus.setText("Campo não pode estar vazio");
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            tvEmailStatus.setVisibility(View.VISIBLE);
            edEmail.setBackground(context.getDrawable(R.drawable.ed_error));
            tvEmailStatus.setText("Favor digitar um email válido");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkPasswNull(Context context, EditText edPassw, TextView tvPasswStatus){
        String passwInput = edPassw.getText().toString().trim();
        if (passwInput.isEmpty()){
            tvPasswStatus.setVisibility(View.VISIBLE);
            edPassw.setBackground(context.getDrawable(R.drawable.ed_error));
            tvPasswStatus.setText("Campo não pode estar vazio");
            return false;
        } else {
            return true;
        }
    }

}
