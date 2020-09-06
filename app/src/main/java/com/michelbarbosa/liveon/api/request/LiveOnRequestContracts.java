package com.michelbarbosa.liveon.api.request;

import android.content.Context;

public interface LiveOnRequestContracts {

    interface AuthView{
        void signUpCallbackSuccess(String token);
        void signUpCallbackFailed(String error);
        void signInCallbackSuccess();
    }

    interface UserProfile{

    }

    interface Orders{

    }

    interface OrderDetails{

    }

    interface RepositoryCallbacks{
    }

    interface Presenter{
        void signUp(Context context, String email, String password);
        void signIn(Context context, String token);
    }

}
