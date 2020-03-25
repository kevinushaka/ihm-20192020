package com.example.tdfragment;


import android.os.Parcel;
import android.os.Parcelable;

public class Character implements Parcelable {
    private String mName;
    private String mDescription;
    private String mImage;
    public Character(String name){
        mName=name;
    }
    public Character (Parcel in){
        mName=in.readString();
    }

    public Character(String name,String description){
        mName=name;
        mDescription=description;
    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        public Character[] newArray(int size) {

            return new Character[size];
        }

    };

    public void  setDescritpion(String descritpion){
        mDescription=descritpion;
    }

    public String getmName() {
        return mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
    }
}
