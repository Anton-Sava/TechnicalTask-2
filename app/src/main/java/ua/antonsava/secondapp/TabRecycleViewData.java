package ua.antonsava.secondapp;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Apple on 20.04.2016.
 */
public class TabRecycleViewData {

    int mMark;
    String mTitle;
    String mAdress;
    String mData;
    String mDays;
    int mLike;

    public TabRecycleViewData(int mMark, String mTitle,
                              String mAdress, String mData, String mDays, int mLike) {

        this.mMark = mMark;
        this.mTitle = mTitle;
        this.mAdress = mAdress;
        this.mData = mData;
        this.mDays = mDays;
        this.mLike = mLike;

    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {

        this.mTitle = mTitle;
    }

    public int getmLike() {
        return mLike;
    }

    public void setmLike(int mLike) {

        this.mLike = mLike;
    }

    public int getmMark() {
        return mMark;
    }

    public void setmMark(int mMark) {

        this.mMark = mMark;
    }

    public String getmAdress() {
        return mAdress;
    }

    public void setmAdress(String mAdress) {

        this.mAdress = mAdress;
    }

    public String getmData() {
        return mData;
    }

    public void setmData(String mData) {

        this.mData = mData;
    }

    public String getmDays() {
        return mDays;
    }

    public void setmDays(String mDays) {
        this.mDays = mDays;
    }
}
