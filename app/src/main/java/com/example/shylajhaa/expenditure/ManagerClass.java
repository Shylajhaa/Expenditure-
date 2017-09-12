package com.example.shylajhaa.expenditure;

import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.regions.Regions;

/**
 * Created by Shylajhaa on 02-09-2017.
 */

public class ManagerClass {

    public CognitoCredentialsProvider getCredentials(Context context)
    {
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(context,
                "ap-south-1:ecde1808-7da1-4d73-8a27-b5c7fd8f6918", // Identity pool ID
                Regions.AP_SOUTH_1 // Region
        );

        return credentialsProvider;
    }

}
