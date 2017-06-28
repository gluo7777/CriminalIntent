package com.example.gluo7.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by gluo7 on 6/27/2017.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private static List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        // sample data
        for (int i=0 ; i<100 ; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Every other one
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID uuid){
        for(Crime crime : mCrimes){
            if(crime.getID().equals(uuid)){
                return crime;
            }
        }
        return null;
    }
}

