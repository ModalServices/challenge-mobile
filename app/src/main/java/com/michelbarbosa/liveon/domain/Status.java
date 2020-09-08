package com.michelbarbosa.liveon.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Status implements Parcelable {

    private String code;
    private String label;
    private boolean checked;
    private int orderId;

    public Status(String code, String label, boolean checked, int orderId) {
        this.code = code;
        this.label = label;
        this.checked = checked;
        this.orderId = orderId;
    }

    protected Status(Parcel in) {
        code = in.readString();
        label = in.readString();
        checked = in.readByte() != 0;
        orderId = in.readInt();
    }

    public static final Creator<Status> CREATOR = new Creator<Status>() {
        @Override
        public Status createFromParcel(Parcel in) {
            return new Status(in);
        }

        @Override
        public Status[] newArray(int size) {
            return new Status[size];
        }
    };

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(code);
        parcel.writeString(label);
        parcel.writeByte((byte) (checked ? 1 : 0));
        parcel.writeInt(orderId);
    }
}
