package com.michelbarbosa.liveon.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = OrderEntity.class, parentColumns = "pk_order_id",
        childColumns = "fk_order_id", onDelete = ForeignKey.CASCADE))
public class StatusEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "status_id")
    private int statusId;

    @ColumnInfo(name = "code")
    private String code;

    @ColumnInfo(name = "label")
    private String label;

    @ColumnInfo(name = "checked")
    private boolean checked;

    @NonNull
    @ColumnInfo(name = "fk_order_id", index = true)
    private int orderId;

    public StatusEntity(int statusId, String code, String label, boolean checked, int orderId) {
        this.statusId = statusId;
        this.code = code;
        this.label = label;
        this.checked = checked;
        this.orderId = orderId;
    }

    public int getStatusId() {
        return statusId;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public boolean isChecked() {
        return checked;
    }

    public int getOrderId() {
        return orderId;
    }
}
