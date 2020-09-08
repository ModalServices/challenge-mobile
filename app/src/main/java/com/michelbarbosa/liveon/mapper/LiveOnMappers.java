package com.michelbarbosa.liveon.mapper;

import com.michelbarbosa.liveon.api.response.UserProfileResponse;
import com.michelbarbosa.liveon.data.entities.OrderEntity;
import com.michelbarbosa.liveon.data.entities.StatusEntity;
import com.michelbarbosa.liveon.data.entities.UserEntity;
import com.michelbarbosa.liveon.domain.Order;
import com.michelbarbosa.liveon.domain.Status;
import com.michelbarbosa.liveon.domain.User;

import java.util.ArrayList;
import java.util.List;

public class LiveOnMappers {

    public static String getToken(UserProfileResponse response) {
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

    public static UserEntity userMapperToEntity(UserProfileResponse response) {
        if (response != null) {
            return new UserEntity(
                    1,
                    response.getAvatar_url(),
                    response.getUsername(),
                    response.getFullname(),
                    response.getCity(),
                    response.getState_abbr()
            );
        } else {
            return null;
        }
    }

    public static User userEntityToDomain(UserEntity entity,
                                          List<OrderEntity> orderEntityList,
                                          List<StatusEntity> statusEntityList) {
        List<Order> orderList = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntityList) {
            List<Status> statusList = new ArrayList<>();

            for (StatusEntity statusEntity : statusEntityList) {
                if(statusEntity.getOrderId() == orderEntity.getOrderId()){
                    Status status = new Status(statusEntity.getCode(), statusEntity.getLabel(),
                            statusEntity.isChecked(), orderEntity.getOrderId());
                    statusList.add(status);
                }
            }
            Order order = new Order(
                    orderEntity.getOrderId(),
                    orderEntity.getSubmodel_name(),
                    statusList
            );
            orderList.add(order);
        }

        return new User(entity.getUrlPictureAvatar(),
                entity.getUsername(),
                entity.getFullname(),
                entity.getCity(),
                entity.getUf(),
                orderList);
    }


}
