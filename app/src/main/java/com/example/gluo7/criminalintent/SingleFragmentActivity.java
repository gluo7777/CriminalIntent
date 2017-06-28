package com.example.gluo7.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gluo7 on 6/27/2017.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    /**
     * This is abstract because the implementing class needs to define this method
     * Different way to create fragments for different methods
     * @return
     */
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // Set up management
        FragmentManager manager = getSupportFragmentManager(); // getFragmentManager for default framework
        // Retrieve fragment
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);
        // Create a new fragment if one does not already exists
        if(fragment == null){
            // Creates and commits a fragment transaction
            fragment = createFragment();
            manager.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
}

/*
findFragmentById

Finds a fragment that was identified by the given id either when inflated from XML or as the container ID when added in a transaction.
This first searches through fragments that are currently added to the manager's activity; if no such fragment is found,
then all fragments currently on the back stack associated with this ID are searched.
 */