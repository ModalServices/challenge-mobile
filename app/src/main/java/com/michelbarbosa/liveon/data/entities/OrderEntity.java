package com.michelbarbosa.liveon.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = UserEntity.class, parentColumns =
        "pk_id", childColumns = "fk_id", onDelete = ForeignKey.CASCADE))
public class OrderEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "pk_order_id")
    private int orderId;

    @ColumnInfo(name = "submodel_name")
    private String submodel_name;

    @NonNull
    @ColumnInfo(name = "fk_id", index = true)
    private int id;

    public OrderEntity(int orderId, String submodel_name, int id) {
        this.orderId = orderId;
        this.submodel_name = submodel_name;
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSubmodel_name() {
        return submodel_name;
    }

    public int getId() {
        return id;
    }

}
