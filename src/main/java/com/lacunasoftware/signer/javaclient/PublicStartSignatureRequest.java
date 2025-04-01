package com.lacunasoftware.signer.javaclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.lacunasoftware.signer.javaclient.requests.StartSignatureRequest;

public class PublicStartSignatureRequest extends StartSignatureRequest {

    @SerializedName("ticket")
    @JsonProperty("ticket")
    public String ticket;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

}
