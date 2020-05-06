package com.zuo.msg;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.elvishew.xlog.XLog;

public class Message implements Parcelable {

    private String location;
    private String poiName;
    private String phoneNumber;
    private int distance;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Message() {

    }
    protected Message(Parcel in) {
        this.location = in.readString();
        this.poiName = in.readString();
        this.phoneNumber = in.readString();
        this.distance = in.readInt();
        XLog.i(this);
    }

    @Override
    public String toString() {
        return String.format("location [%s]%npoi name [%s]%nphone number [%s]%n distance [%d]",
            location, poiName, phoneNumber, distance);
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(location);
        dest.writeString(poiName);
        dest.writeString(phoneNumber);
        dest.writeInt(distance);
    }
}
