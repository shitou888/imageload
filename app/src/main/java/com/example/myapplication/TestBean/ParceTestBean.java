package com.example.myapplication.TestBean;

import android.os.Parcel;
import android.os.Parcelable;

public class ParceTestBean implements Parcelable {
    protected ParceTestBean(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ParceTestBean> CREATOR = new Creator<ParceTestBean>() {
        @Override
        public ParceTestBean createFromParcel(Parcel in) {
            return new ParceTestBean(in);
        }

        @Override
        public ParceTestBean[] newArray(int size) {
            return new ParceTestBean[size];
        }
    };
}
