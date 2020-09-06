package com.michelbarbosa.liveon.mapper;

import com.michelbarbosa.liveon.api.response.ProfileResponse;
import com.michelbarbosa.liveon.domain.User;

public class LiveOnMappers {

    public static String getToken(ProfileResponse response) {
        if (response != null) {
            if (response.getToken() != null) {
                return response.getToken();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static User userMapper(ProfileResponse response) {
        if (response != null) {
            return new User(
                    response.getAvatar_url(),
                    response.getUsername(),
                    response.getFullname(),
                    response.getCity(),
                    response.getState_abbr(),
                    null
            );
        } else {
            return null;
        }
    }

}
