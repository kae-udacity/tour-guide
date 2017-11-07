package com.example.android.tourguide.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Stores the data of the tourist attraction.
 */

public class Attraction implements Parcelable {

    private String mName;
    private String mAddress;
    private String mOpeningHours;
    private int mImageResourceId;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Object createFromParcel(Parcel parcel) {
            return new Attraction(parcel);
        }

        @Override
        public Object[] newArray(int i) {
            return new Attraction[i];
        }
    };

    public Attraction(String name, String address, int imageResourceId) {
        mName = name;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    public Attraction(String name, String address, String openingHours, int imageResourceId) {
        this(name, address, imageResourceId);
        mOpeningHours = openingHours;
    }

    public Attraction(Parcel parcel) {
        mName = parcel.readString();
        mAddress = parcel.readString();
        mOpeningHours = parcel.readString();
        mImageResourceId = parcel.readInt();
    }

    public String getName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getOpeningHours() {
        return mOpeningHours;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mAddress);
        parcel.writeString(mOpeningHours);
        parcel.writeInt(mImageResourceId);
    }
}
