package com.example.gluo7.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by gluo7 on 6/27/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
