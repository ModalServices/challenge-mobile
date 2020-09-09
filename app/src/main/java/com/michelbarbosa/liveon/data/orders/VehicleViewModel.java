package com.michelbarbosa.liveon.data.orders;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.michelbarbosa.liveon.api.response.OrderResponse;
import com.michelbarbosa.liveon.data.entities.OrderVehicleEntity;

import java.util.ArrayList;
import java.util.List;


public class VehicleViewModel extends AndroidViewModel {

    private VehicleRepository repository;
    private LiveData<List<OrderVehicleEntity>> orderVEntity;
    private MutableLiveData<List<OrderVehicleEntity>> orderVEntityResult;

    public VehicleViewModel(Application application) {
        super(application);
        repository = new VehicleRepository(application);
        orderVEntity = repository.getmOrderVList();
        orderVEntityResult = repository.getmOrderVListResult();
    }

    public void insertOrderVehicle(List<OrderResponse> responseList) {
        List<OrderVehicleEntity> orderEntityList = new ArrayList<>();
        int i = 0;
        for (OrderResponse order : responseList) {
            orderEntityList.add(
                    new OrderVehicleEntity(order.getOrder_id(), order.getSubmodel_name()));
        }
        repository.insertOrderVEntityList(orderEntityList);
    }

    public LiveData<List<OrderVehicleEntity>> getOrderVEntity() {
        return orderVEntity;
    }

    public MutableLiveData<List<OrderVehicleEntity>> getOrderVEntityResult() {
        return orderVEntityResult;
    }
}
