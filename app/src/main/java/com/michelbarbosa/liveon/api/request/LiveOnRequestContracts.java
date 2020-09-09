package com.michelbarbosa.liveon.api.request;

import android.content.Context;

import com.michelbarbosa.liveon.api.response.OrderResponse;
import com.michelbarbosa.liveon.api.response.UserProfileResponse;

import java.util.List;

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

    interface OrderListView {
        void loadSuccess(List<OrderResponse> responseList);
        void loadFailed(String error);
    }

    interface OrderDetailsView {

    }

    interface Presenter {
        void login(Context context, String email, String password);

        void login(Context context, String token);

        void loadUserProfileResponse(Context context, String token);

        void loadOrdersResponse(Context context, String token);
    }

}
