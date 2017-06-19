package com.example.android.logthoughts;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 *  Created by Jessica on 2017-05-12.
 *  Thoughts is a class that stores the answers a user gives to various exercises.
 */

public class Thoughts implements Parcelable {

    /*
            VARIABLES
     */

    // Stores the answer to the Situation exercise
    private String mSitAnswer;

    // Stores the answer to the Moods exercise
    private String mMoodsAnswer;

    // Stores the answer to the Automatic Thoughts exercise
    private String mAutoAnswer;

    // Stores the answer to the Pro Hot Thought exercise
    private String mProAnswer;

    // Stores the answer to the Con Hot Thought exercise
    private String mConAnswer;

    // Stores the answer to the Alternate Thoughts exercise
    private String mAltAnswer;

    // Stores the answer to the Moods Now exercise
    private String mNowAnswer;


    /*
            CONSTRUCTORS
     */

    /**
     *  SitActivity constructor
     */
    public Thoughts(){
        mSitAnswer = "Nothing to show";
        mMoodsAnswer  = "Nothing to show";
        mAutoAnswer = "Nothing to show";
        mProAnswer = "Nothing to show";
        mConAnswer = "Nothing to show";
        mAltAnswer = "Nothing to show";
        mNowAnswer = "Nothing to show";
    }

    /**
     *  MoodsActivity constructor
     */
    public Thoughts(String sitAnswer){
        mSitAnswer = sitAnswer;
        mMoodsAnswer = "Nothing to show";
        mAutoAnswer = "Nothing to show";
        mProAnswer = "Nothing to show";
        mConAnswer = "Nothing to show";
        mAltAnswer = "Nothing to show";
        mNowAnswer = "Nothing to show";
    }

    /**
     *  AutoActivity constructor
     */
    public Thoughts(String sitAnswer, String moodsAnswer){
        mSitAnswer = sitAnswer;
        mMoodsAnswer = moodsAnswer;
        mAutoAnswer = "Nothing to show";
        mProAnswer = "Nothing to show";
        mConAnswer = "Nothing to show";
        mAltAnswer = "Nothing to show";
        mNowAnswer = "Nothing to show";
    }

    /**
     *  ProActivity constructor
     */
    public Thoughts(String sitAnswer,
                    String moodsAnswer,
                    String autoAnswer){
        mSitAnswer = sitAnswer;
        mMoodsAnswer = moodsAnswer;
        mAutoAnswer = autoAnswer;
        mProAnswer = "Nothing to show";
        mConAnswer = "Nothing to show";
        mAltAnswer = "Nothing to show";
        mNowAnswer = "Nothing to show";
    }

    /**
     *  ConActivity constructor
     */
    public Thoughts(String sitAnswer,
                    String moodsAnswer,
                    String autoAnswer,
                    String proAnswer){
        mSitAnswer = sitAnswer;
        mMoodsAnswer = moodsAnswer;
        mAutoAnswer = autoAnswer;
        mProAnswer = proAnswer;
        mConAnswer = "Nothing to show";
        mAltAnswer = "Nothing to show";
        mNowAnswer = "Nothing to show";
    }

    /**
     *  AltActivity constructor
     */
    public Thoughts(String sitAnswer,
                    String moodsAnswer,
                    String autoAnswer,
                    String proAnswer,
                    String conAnswer){
        mSitAnswer = sitAnswer;
        mMoodsAnswer = moodsAnswer;
        mAutoAnswer = autoAnswer;
        mProAnswer = proAnswer;
        mConAnswer = conAnswer;
        mAltAnswer = "Nothing to show";
        mNowAnswer = "Nothing to show";
    }

    /**
     *  NowActivity constructor
     */
    public Thoughts(String sitAnswer,
                    String moodsAnswer,
                    String autoAnswer,
                    String proAnswer,
                    String conAnswer,
                    String altAnswer){
        mSitAnswer = sitAnswer;
        mMoodsAnswer = moodsAnswer;
        mAutoAnswer = autoAnswer;
        mProAnswer = proAnswer;
        mConAnswer = conAnswer;
        mAltAnswer = altAnswer;
        mNowAnswer = "Nothing to show";
    }

    /**
     *  SummaryActivity constructor
     */
    public Thoughts(String sitAnswer,
                    String moodsAnswer,
                    String autoAnswer,
                    String proAnswer,
                    String conAnswer,
                    String altAnswer,
                    String nowAnswer){
        mSitAnswer = sitAnswer;
        mMoodsAnswer = moodsAnswer;
        mAutoAnswer = autoAnswer;
        mProAnswer = proAnswer;
        mConAnswer = conAnswer;
        mAltAnswer = altAnswer;
        mNowAnswer = nowAnswer;
    }

    /*
            GETTERS AND SETTERS
     */

    /**
     *  Gets the Situation answer.
     */
    public String getmSitAnswer() {
        return mSitAnswer;
    }

    /**
     *  Gets the Situation answer.
     */
    public String getmMoodsAnswer() {
        return mMoodsAnswer;
    }

    /**
     *  Gets the Situation answer.
     */
    public String getmAutoAnswer() {
        return mAutoAnswer;
    }

    /**
     *  Gets the Situation answer.
     */
    public String getmProAnswer() {
        return mProAnswer;
    }

    /**
     *  Gets the Situation answer.
     */
    public String getmConAnswer() {
        return mConAnswer;
    }

    /**
     *  Gets the Situation answer.
     */
    public String getmAltAnswer() {
        return mAltAnswer;
    }

    /**
     *  Gets the Situation answer.
     */
    public String getmNowAnswer() {
        return mNowAnswer;
    }


    public void setmSitAnswer(String mSitAnswer) {
        this.mSitAnswer = mSitAnswer;
    }

    public void setmMoodsAnswer(String mMoodsAnswer) {
        this.mMoodsAnswer = mMoodsAnswer;
    }

    public void setmAutoAnswer(String mAutoAnswer) {
        this.mAutoAnswer = mAutoAnswer;
    }

    public void setmProAnswer(String mProAnswer) {
        this.mProAnswer = mProAnswer;
    }

    public void setmConAnswer(String mConAnswer) {
        this.mConAnswer = mConAnswer;
    }

    public void setmAltAnswer(String mAltAnswer) {
        this.mAltAnswer = mAltAnswer;
    }

    public void setmNowAnswer(String mNowAnswer) {
        this.mNowAnswer = mNowAnswer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSitAnswer);
        dest.writeString(mMoodsAnswer);
        dest.writeString(mAutoAnswer);
        dest.writeString(mProAnswer);
        dest.writeString(mConAnswer);
        dest.writeString(mAltAnswer);
        dest.writeString(mNowAnswer);
    }

    public static final Parcelable.Creator<Thoughts> CREATOR
            = new Parcelable.Creator<Thoughts>() {
        public Thoughts createFromParcel(Parcel in) {
            return new Thoughts(in);
        }

        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };
}
