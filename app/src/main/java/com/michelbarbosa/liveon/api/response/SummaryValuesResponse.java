package com.michelbarbosa.liveon.api.response;

import com.google.gson.annotations.SerializedName;

public class SummaryValuesResponse {

    @SerializedName("monthly_price")
    private String monthly_price;

    @SerializedName("extras")
    private String extras;

    @SerializedName("total_price")
    private String total_price;

    public SummaryValuesResponse(String monthly_price, String extras, String total_price) {
        this.monthly_price = monthly_price;
        this.extras = extras;
        this.total_price = total_price;
    }

    public String getMonthly_price() {
        return monthly_price;
    }

    public String getExtras() {
        return extras;
    }

    public String getTotal_price() {
        return total_price;
    }
}
