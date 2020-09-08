package com.michelbarbosa.liveon.api.response;

import com.google.gson.annotations.SerializedName;

public class SignatureDetailsResponse {

    @SerializedName("months")
    private String months;

    @SerializedName("plan_type")
    private String plan_type;

    @SerializedName("additional_franchise")
    private String additional_franchise;

    public SignatureDetailsResponse(String months, String plan_type, String additional_franchise) {
        this.months = months;
        this.plan_type = plan_type;
        this.additional_franchise = additional_franchise;
    }

    public String getMonths() {
        return months;
    }

    public String getPlan_type() {
        return plan_type;
    }

    public String getAdditional_franchise() {
        return additional_franchise;
    }

}