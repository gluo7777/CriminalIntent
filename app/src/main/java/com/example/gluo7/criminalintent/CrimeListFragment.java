package com.example.gluo7.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by gluo7 on 6/27/2017.
 */

public class CrimeListFragment extends Fragment{

    // Widgets
    private RecyclerView mCrimeRecyclerView;

    // Adapter
    private CrimeAdapter mCrimeAdapter;

    /**
     * RecyclerView requires a layout manager that positions items and defines how scrolling works
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list,container,false);

        // Wire up widgets
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Set up UI for RecyclerView
        updateUI();

        return view;
    }

    /**
     * Configures UI for RecyclerView
     */
    private void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();

        // Connect Adapter to RecyclerView
        mCrimeAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mCrimeAdapter);
    }

    /**
     * This class contains itemView which references entire view passed into ViewHolder constructor
     * Implements OnClickListener to make entire row clickable
     * itemView represents view for entire row
     */
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTitleTextView;
        private TextView mDateTextView;

        private Crime mCrime;

        public CrimeHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime,parent,false));
            mTitleTextView = this.itemView.findViewById(R.id.crime_title);
            mDateTextView = this.itemView.findViewById(R.id.crime_date);
            this.itemView.setOnClickListener(this);
        }

        /**
         * Called each time a new Crime needs to be displayed
         * @param crime
         */
        public void bind(Crime crime){
            this.mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate().toString());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),mCrime.getTitle() + " clicked!",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Used by RecyclerView to create/display new ViewHolders and to bind Crime object to existing ViewHolder
     * Middleman between RecyclerView and ViewHolder
     * The methods you override are called by RecyclerView
     */
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){
            this.mCrimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater,parent);
        }

        /**
         * Keep this method as efficient as possible
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            holder.bind(mCrimes.get(position));
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}






















