package com.michelbarbosa.liveon.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Order implements Parcelable {

    private int orderId;
    private String submodel_name;
    private List<Status> statusList;

    public Order(int orderId, String submodel_name, List<Status> statusList) {
        this.orderId = orderId;
        this.submodel_name = submodel_name;
        this.statusList = statusList;
    }

    protected Order(Parcel in) {
        orderId = in.readInt();
        submodel_name = in.readString();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public int getOrderId() {
        return orderId;
    }

    public String getSubmodel_name() {
        return submodel_name;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(orderId);
        parcel.writeString(submodel_name);
    }
}
