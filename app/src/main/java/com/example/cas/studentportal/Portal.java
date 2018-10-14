package com.example.cas.studentportal;

import android.os.Parcel;
import android.os.Parcelable;

public class Portal implements Parcelable {
    private String mName;
    private String mUrl;

    public Portal(String mName, String mUrl) {
        this.mName = mName;
        this.mUrl = mUrl;
    }

    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUrl() {
        return mUrl;
    }
    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    @Override
    public String toString() {
        return mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
    }

    protected Portal(Parcel in) {
        this.mName = in.readString();
    }

    public static final Parcelable.Creator<Portal> CREATOR = new Parcelable.Creator<Portal>() {
        @Override
        public Portal createFromParcel(Parcel source) {
            return new Portal(source);
        }

        @Override
        public Portal[] newArray(int size) {
            return new Portal[size];
        }
    };
}
