package com.michelbarbosa.liveon.api.response;

import com.google.gson.annotations.SerializedName;

public class OrderDetailsResponse {

    @SerializedName("vehicle_details")
    private VehicleDetailsResponse vehicle_details;

    @SerializedName("signature_details")
    private SignatureDetailsResponse signature_details;

    @SerializedName("summary_values")
    private SummaryValuesResponse summary_values;

    public OrderDetailsResponse(VehicleDetailsResponse vehicle_details,
                                SignatureDetailsResponse signature_details,
                                SummaryValuesResponse summary_values) {
        this.vehicle_details = vehicle_details;
        this.signature_details = signature_details;
        this.summary_values = summary_values;
    }

    public VehicleDetailsResponse getVehicle_details() {
        return vehicle_details;
    }

    public SignatureDetailsResponse getSignature_details() {
        return signature_details;
    }

    public SummaryValuesResponse getSummary_values() {
        return summary_values;
    }
}
