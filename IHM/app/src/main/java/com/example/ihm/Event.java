package com.example.ihm;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;

public class Event implements Parcelable {

    public String mName;
    public LocalDateTime mStart;
    public LocalDateTime mEnd;

    public Event(String name,LocalDateTime start,LocalDateTime end){
        mName=name;
        mStart=start;
        mEnd=end;
    }

    protected Event(Parcel in) {
        mName = in.readString();
        int[] start=new int[5];
        int[] end=new int[5];
        in.readIntArray(start);
        in.readIntArray(end);
        mStart=LocalDateTime.of(start[0],start[1],start[2],start[3],start[4]);
        mEnd=LocalDateTime.of(end[0],end[1],end[2],end[3],end[4]);
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        //int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond
        dest.writeIntArray(new int[]{mStart.getYear(),mStart.getMonthValue(),mStart.getDayOfMonth(),mStart.getHour(),mStart.getMinute()});
        dest.writeIntArray(new int[]{mEnd.getYear(),mEnd.getMonthValue(),mEnd.getDayOfMonth(),mEnd.getHour(),mEnd.getMinute()});
    }

    @NonNull
    @Override
    public String toString() {
        return mName+"\n"+
                mStart.toString()+"\n"+
                mEnd.toString()+"\n";
    }

    public int getMonthStart() {
        return mStart.getMonthValue();
    }
    public int getYearStart(){
        return mStart.getYear();
    }
    public int getDayOfMonthStart(){
        return mStart.getDayOfMonth();
    }
}
