package com.michelbarbosa.liveon.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.michelbarbosa.liveon.R;
import com.michelbarbosa.liveon.api.request.LiveOnRequest;
import com.michelbarbosa.liveon.api.request.LiveOnRequestContracts;
import com.michelbarbosa.liveon.utils.UiUtil;
import com.michelbarbosa.liveon.utils.Util;

public class LoginActivity extends AppCompatActivity implements LiveOnRequestContracts.AuthView {

    private LiveOnRequestContracts.Presenter authPresenter = new LiveOnRequest(this);

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String SHARED_PREF = "preferences";
    private static final String TOKEN_PREF = "token_pref";
    private static String senha;

    private EditText edEmail, edSenha;
    private TextView tvEmailError, tvSenhaError;
    private Button btLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        startSharedPref();
        customizeLayout();
        setViews();
        setBtLoginConfig();

        String storedToken = sharedPreferences.getString(TOKEN_PREF, "");
        if(!storedToken.isEmpty()){
            autoSignIn();
        }
    }

    private void startSharedPref() {
        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private void customizeLayout() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        ImageView ivBackground = findViewById(R.id.iv_loginBackground);
        int[] widthForHeightCompress = {7, 7};
        UiUtil.setCustomImageToBackground(this, getWindowManager(),
                ivBackground, R.drawable.montain_road, widthForHeightCompress);
    }

    private void setViews() {
        edEmail = findViewById(R.id.ed_loginEmail);
        edSenha = findViewById(R.id.ed_loginSenha);
        btLogin = findViewById(R.id.bt_Login);
        tvEmailError = findViewById(R.id.tv_login_emailError);
        tvSenhaError = findViewById(R.id.tv_login_senhaError);
    }

    private void setBtLoginConfig() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btLogin.setEnabled(false);
                //todo remover depois dos testes
                // autoPrenchimento();

                senha = null;
                if (Util.validateEmail(LoginActivity.this, edEmail, tvEmailError) &&
                        Util.checkPasswNull(LoginActivity.this, edSenha, tvSenhaError)) {
                    String email = edEmail.getText().toString();
                    senha = edSenha.getText().toString();
                    authPresenter.signUp(LoginActivity.this, email, senha);
                }
                btLogin.setEnabled(true);
            }
        });

        resetOnClickEditText(edEmail);
        resetOnClickEditText(edSenha);
    }

    private void autoPrenchimento() {
        edEmail.setText("jessica@challenge.com");
        edSenha.setText("pass123");
    }

    private void resetOnClickEditText(EditText et) {
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetUi();
            }
        });
    }

    private void resetUi() {
        edEmail.setBackground(getResources().getDrawable(R.drawable.ed_normal));
        edEmail.setText("");
        edSenha.setBackground(getResources().getDrawable(R.drawable.ed_normal));
        edSenha.setText("");
        tvEmailError.setText(null);
        tvEmailError.setVisibility(View.GONE);
        tvSenhaError.setText(null);
        tvSenhaError.setVisibility(View.GONE);
    }

    private void autoSignIn() {
        authPresenter.signIn(this, sharedPreferences.getString(TOKEN_PREF, ""));
    }

    @Override
    public void signUpCallbackSuccess(String token) {
        storeToken(token);
        advanceToUserProfileActivity();
    }

    @Override
    public void signUpCallbackFailed(String error) {
        tvEmailError.setVisibility(View.VISIBLE);
        edEmail.setBackground(getDrawable(R.drawable.ed_error));
        tvEmailError.setText(error);
    }

    @Override
    public void signInCallbackSuccess() {
        advanceToUserProfileActivity();
    }

    private void storeToken(String token){
        editor.putString(TOKEN_PREF, token);
        editor.apply();
    }

    private void advanceToUserProfileActivity(){
        this.startActivity(new Intent(
                this,UserProfileActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private void clearData(){
        sharedPreferences.getAll().clear();
    }

}
