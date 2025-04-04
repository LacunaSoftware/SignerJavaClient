package com.lacunasoftware.signer.uploads;

import com.google.gson.annotations.SerializedName;

public class SignatureImageUploadModel {

    @SerializedName("showSignerInformation")
    public boolean showSignerInformation;

    @SerializedName("alignTextOnMiddle")
    public boolean alignTextOnMiddle;

    public boolean isShowSignerInformation() {
        return showSignerInformation;
    }

    public void setShowSignerInformation(boolean showSignerInformation) {
        this.showSignerInformation = showSignerInformation;
    }

    public boolean isAlignTextOnMiddle() {
        return alignTextOnMiddle;
    }

    public void setAlignTextOnMiddle(boolean alignTextOnMiddle) {
        this.alignTextOnMiddle = alignTextOnMiddle;
    }

    

}
