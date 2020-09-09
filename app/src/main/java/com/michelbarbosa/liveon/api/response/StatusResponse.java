package com.michelbarbosa.liveon.api.response;

import com.google.gson.annotations.SerializedName;

public class StatusResponse {

    @SerializedName("code")
    private String code;

    @SerializedName("label")
    private String label;

    @SerializedName("checked")
    private boolean checked;

    public StatusResponse(String code, String label, boolean checked) {
        this.code = code;
        this.label = label;
        this.checked = checked;
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
}
