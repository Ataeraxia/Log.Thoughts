package com.example.android.logthoughts;

/**
 *  Created by Jessica on 2017-05-12.
 *  AnswerBook is a class that stores the answers a user gives to various exercises.
 */

public class AnswerBook {

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
    private AnswerBook(){}


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
}
