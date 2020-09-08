package com.michelbarbosa.liveon.api.request;

import android.content.Context;

import com.michelbarbosa.liveon.api.response.UserProfileResponse;

public interface LiveOnRequestContracts {

    interface AuthView {
        void signUpCallbackSuccess(String token);

        void signUpCallbackFailed(String error);

        void signInCallbackSuccess();

        void signInCallbackFailed();
    }

    interface UserProfileView {
        void loadSuccess(UserProfileResponse response);

        void loadFailed(String error);
    }

    interface Orders {

    }

    interface OrderDetails {

    }

    interface Presenter {
        void login(Context context, String email, String password);

        void login(Context context, String token);

        void loadResponseToPersist(Context context, String token);
    }

}
