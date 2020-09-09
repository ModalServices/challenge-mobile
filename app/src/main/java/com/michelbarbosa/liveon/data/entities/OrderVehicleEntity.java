package com.michelbarbosa.liveon.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class OrderVehicleEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "pk_order_id")
    private int orderId;

    @ColumnInfo(name = "submodel_name")
    private String submodel_name;

    public OrderVehicleEntity(int orderId, String submodel_name) {
        this.orderId = orderId;
        this.submodel_name = submodel_name;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSubmodel_name() {
        return submodel_name;
    }
}
