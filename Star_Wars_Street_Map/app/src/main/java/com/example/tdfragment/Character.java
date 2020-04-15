package com.example.tdfragment;


import android.os.Parcel;
import android.os.Parcelable;

public class Character implements Parcelable {
    private String mName;
    private String mDescription;
    private int mImage;
    public Character(String name){
        mName=name;
    }
    public Character (Parcel in){
        mName=in.readString();
        mDescription=in.readString();
        mImage=in.readInt();
    }

    public Character(String name,String description){
        mName=name;
        mDescription=description;
    }
    public Character(String name,String description,int image){
        mName=name;
        mDescription=description;
        mImage=image;
    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        public Character[] newArray(int size) {

            return new Character[size];
        }

    };

    public String getmName() {
        return mName;
    }

    public String getmDescription(){
        return mDescription;
    }
    public int getmImage(){
        return mImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeInt(mImage);
    }
}
