package com.michelbarbosa.liveon.data.user;

import android.app.Application;
import android.database.sqlite.SQLiteException;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.michelbarbosa.liveon.api.response.OrderResponse;
import com.michelbarbosa.liveon.api.response.StatusResponse;
import com.michelbarbosa.liveon.api.response.UserProfileResponse;
import com.michelbarbosa.liveon.data.entities.OrderEntity;
import com.michelbarbosa.liveon.data.entities.StatusEntity;
import com.michelbarbosa.liveon.data.entities.UserEntity;
import com.michelbarbosa.liveon.mapper.LiveOnMappers;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;
    private LiveData<UserEntity> userEntity;
    private MutableLiveData<UserEntity> userEntityResult;
    private LiveData<List<OrderEntity>> orderList;
    private MutableLiveData<List<OrderEntity>> orderResultList;
    private LiveData<List<StatusEntity>> statusList;
    private MutableLiveData<List<StatusEntity>> statusResultList;

    public UserViewModel(Application application) {
        super(application);
        repository = new UserRepository(application);
        userEntity = repository.getmUser();
        userEntityResult = repository.getmUserResult();
        orderList = repository.getmOrderList();
        orderResultList = repository.getmOrderListResult();
        statusList = repository.getmStatusList();
        statusResultList = repository.getmStatusListResult();
    }

    public void insertUser(UserProfileResponse response) {
        repository.insertUserEntity(LiveOnMappers.userMapperToEntity(response));
        int statusId = 0;
        for (OrderResponse order: response.getOrders()) {
            List<StatusEntity> statusEntityList = new ArrayList<>();
            if(order.getStatuses().size() > 0){
                for (StatusResponse status: order.getStatuses()) {
                    final StatusEntity item = new StatusEntity(
                            statusId,
                            status.getCode(),
                            status.getLabel(),
                            status.isChecked(),
                            order.getOrder_id()
                    );
                    statusEntityList.add(item);
                    statusId++;
                }
            }
            OrderEntity orderEntity = new OrderEntity(
                    order.getOrder_id(),
                    order.getSubmodel_name(),
                    1
            );
            repository.insertOrderEntity(orderEntity);
            repository.insertStatusEntity(statusEntityList);
        }
    }
    public void updateOrder(List<OrderResponse> responseList){
        for (OrderResponse order: responseList) {
            try {
                repository.updateOrderSubmodelName(new OrderEntity(order.getOrder_id(), order.getSubmodel_name(),0));
            } catch (SQLiteException sqlEx){
                sqlEx.printStackTrace();
            }
        }
    }

    public UserRepository getRepository() {
        return repository;
    }

    public LiveData<UserEntity> getUserEntity() {
        return userEntity;
    }

    public MutableLiveData<UserEntity> getUserEntityResult() {
        return userEntityResult;
    }

    public LiveData<List<OrderEntity>> getOrderList() {
        return orderList;
    }

    public MutableLiveData<List<OrderEntity>> getOrderResultList() {
        return orderResultList;
    }

    public LiveData<List<StatusEntity>> getStatusList() {
        return statusList;
    }

    public MutableLiveData<List<StatusEntity>> getStatusResultList() {
        return statusResultList;
    }

    public void fullWipe(){
        repository.deleteAllStatus();
        repository.deleteAllOrder();
        repository.deleteUser();
    }
}
