package com.michelbarbosa.liveon.data.user;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.michelbarbosa.liveon.data.entities.OrderEntity;
import com.michelbarbosa.liveon.data.entities.StatusEntity;
import com.michelbarbosa.liveon.data.entities.UserEntity;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUserEntity(UserEntity userEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrderEntity(OrderEntity orderEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStatusEntityList(List<StatusEntity> statusEntities);

    @Query("DELETE FROM UserEntity")
    void deleteUser();

    @Query("DELETE FROM OrderEntity")
    void deleteAllOrder();

    @Query("DELETE FROM StatusEntity")
    void deleteAllStatus();

    @Query("SELECT * FROM UserEntity")
    LiveData<UserEntity> getUserEntity();

    @Query("SELECT * FROM OrderEntity")
    LiveData<List<OrderEntity>> getOrderEntityList();

    @Query("SELECT * FROM StatusEntity")
    LiveData<List<StatusEntity>> getStatusEntityList();

    @Query("SELECT * FROM UserEntity")
    UserEntity findUserEntity();

    @Query("SELECT * FROM OrderEntity")
    List<OrderEntity> findOrderEntityList();

    @Query("SELECT * FROM StatusEntity")
    List<StatusEntity> findStatusEntityList();

    @Query("UPDATE Orderentity SET submodel_name = :submodelName WHERE pk_order_id = :orderId")
    void updateOrderSubmodelName(int orderId, String submodelName);

}
