package com.michelbarbosa.liveon.domain;

public class OrderVehicle {

    private int orderId;
    private String submodel_name;
    private Vehicle vehicle;

    public OrderVehicle(int orderId, String submodel_name) {
        this.orderId = orderId;
        this.submodel_name = submodel_name;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSubmodel_name() {
        return submodel_name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
