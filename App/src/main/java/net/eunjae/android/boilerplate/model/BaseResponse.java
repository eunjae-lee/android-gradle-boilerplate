package net.eunjae.android.boilerplate.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Parcelable {

    @JsonProperty("status")
    private int status;

    public BaseResponse() {
    }

    public BaseResponse(Parcel src) {
        readSource(src);
    }

    public boolean isOk() {
        return status == 200;
    }

    protected void readSource(Parcel src) {
        if (src == null) {
            return;
        }
        status = src.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static final Parcelable.Creator<BaseResponse> CREATOR = new Parcelable.Creator<BaseResponse>() {

        @Override
        public BaseResponse createFromParcel(Parcel source) {
            return new BaseResponse(source);
        }

        @Override
        public BaseResponse[] newArray(int size) {
            return new BaseResponse[size];
        }

    };
}
