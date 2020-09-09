package com.michelbarbosa.liveon.api.response;

import com.google.gson.annotations.SerializedName;

public class VehicleDetailsResponse {

    @SerializedName("image_url")
    private String[] image_url;

    @SerializedName("vehicle_year")
    private String vehicle_year;

    @SerializedName("vehicle_brand")
    private String vehicle_brand;

    @SerializedName("vehicle_model")
    private String vehicle_model;

    @SerializedName("engine")
    private String engine;

    @SerializedName("engine_type")
    private String engine_type;

    @SerializedName("fuel_type")
    private String fuel_type;

    @SerializedName("doors_qtd")
    private String doors_qtd;

    @SerializedName("delivery_delay")
    private String delivery_delay;

    @SerializedName("km")
    private String km;

    public VehicleDetailsResponse(String[] image_url, String vehicle_year, String vehicle_brand,
                                  String vehicle_model, String engine, String engine_type,
                                  String fuel_type, String doors_qtd, String delivery_delay, String km) {
        this.image_url = image_url;
        this.vehicle_year = vehicle_year;
        this.vehicle_brand = vehicle_brand;
        this.vehicle_model = vehicle_model;
        this.engine = engine;
        this.engine_type = engine_type;
        this.fuel_type = fuel_type;
        this.doors_qtd = doors_qtd;
        this.delivery_delay = delivery_delay;
        this.km = km;
    }

    public String[] getImage_url() {
        return image_url;
    }

    public String getVehicle_year() {
        return vehicle_year;
    }

    public String getVehicle_brand() {
        return vehicle_brand;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public String getEngine() {
        return engine;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public String getDoors_qtd() {
        return doors_qtd;
    }

    public String getDelivery_delay() {
        return delivery_delay;
    }

    public String getKm() {
        return km;
    }
}