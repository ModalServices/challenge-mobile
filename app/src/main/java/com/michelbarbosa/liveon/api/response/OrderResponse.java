package com.michelbarbosa.liveon.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderResponse {

    @SerializedName("order_id")
    private int order_id;

    @SerializedName("submodel_name")
    private String submodel_name;

    @SerializedName("statuses")
    private List<StatusResponse> statuses;

    public OrderResponse(int order_id, String submodel_name, List<StatusResponse> statuses) {
        this.order_id = order_id;
        this.submodel_name = submodel_name;
        this.statuses = statuses;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getSubmodel_name() {
        return submodel_name;
    }

    public List<StatusResponse> getStatuses() {
        return statuses;
    }
}
