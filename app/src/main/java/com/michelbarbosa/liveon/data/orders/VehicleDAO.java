package com.michelbarbosa.liveon.data.orders;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.michelbarbosa.liveon.data.entities.OrderVehicleEntity;

import java.util.List;

@Dao
public interface VehicleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrderVehicleEntity(List<OrderVehicleEntity> orderVehicleEntityList);

    @Query("SELECT * FROM OrderVehicleEntity")
    List<OrderVehicleEntity> findOrderVehicleEntityList();

    @Query("SELECT * FROM OrderVehicleEntity")
    LiveData<List<OrderVehicleEntity>> getOrderVehicleEntityList();

}
