package com.michelbarbosa.liveon.api.request;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

import com.michelbarbosa.liveon.api.DataService;
import com.michelbarbosa.liveon.api.network.RetrofitClientInstance;
import com.michelbarbosa.liveon.api.response.ProfileResponse;
import com.michelbarbosa.liveon.mapper.LiveOnMappers;
import com.michelbarbosa.liveon.utils.UiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveOnRequest implements LiveOnRequestContracts.RepositoryCallbacks, LiveOnRequestContracts.Presenter {

    private LiveOnRequestContracts.AuthView authView;

    public LiveOnRequest(LiveOnRequestContracts.AuthView authView) {
        this.authView = authView;
    }

    @Override
    public void signUp(Context context, String email, String password) {
        DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);
        Call<ProfileResponse> call = service.Auth(email, password);
        serviceAuth(context, call);
    }

    @Override
    public void signIn(Context context, String token) {
        DataService service = RetrofitClientInstance.getRetrofitInstance().create(DataService.class);
        Call<ProfileResponse> call = service.Profile(token);
        serviceLoadUserProfile(context, call);
    }

    private void serviceAuth(final Context context, Call<ProfileResponse> call) {
        final AlertDialog requestDialog = UiUtil.progressDialog(context, "Autenticando...");
        requestDialog.show();
        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                requestDialog.dismiss();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        authView.signUpCallbackSuccess(LiveOnMappers.getToken(response.body()));
                        //impl carregamento de User no sqlite  no repositorio

                    } else {
                        authView.signUpCallbackFailed("Erro " + response.code() + "->" + response.toString());
                    }
                } else {
                    try {
                        //TODO: TRATAMENTO DE ERRO E DA RESPOSTA DO ERRORBODY
                      authView.signUpCallbackFailed("Erro " + response.errorBody());
                    } catch (NullPointerException npe) {
                        npe.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                if (t.getMessage() != null) {
                    Log.e(context.getClass().getName(), t.getMessage());
                }
                authView.signUpCallbackFailed(t.getMessage());
                requestDialog.dismiss();
            }
        });
    }

    private void serviceLoadUserProfile(final Context context, Call<ProfileResponse> call){
        final AlertDialog requestDialog = UiUtil.progressDialog(context, "Logando...");
        requestDialog.show();
        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        authView.signInCallbackSuccess();
                        //impl carregamento de User no sqlite no repositorio

                    } else {
                        authView.signUpCallbackFailed("");
                    }
                } else {
                    authView.signUpCallbackFailed("");
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                authView.signUpCallbackFailed("");
            }
        });
    }

}
