package com.example.collegeapplicationsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapplicationsystem.JSONParsing.College;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CollegeAdapter extends FirestoreRecyclerAdapter<College, CollegeAdapter.CollegeHolder> {

    public CollegeAdapter(@NonNull FirestoreRecyclerOptions<College> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CollegeHolder holder, int position, @NonNull College model) {
        holder.title.setText(model.getSchoolName());
        holder.id.setText(String.valueOf(model.getId()));
        holder.state.setText(model.getSchoolState());
        holder.city.setText(model.getSchoolCity());
        holder.zip.setText(model.getSchoolZip());
        holder.url.setText(model.getSchoolSchoolUrl());
        holder.inStateTuition.setText(String.valueOf(model.getLatestCostTuitionInState()));
        holder.outOfStateTuition.setText(String.valueOf(model.getLatestCostTuitionOutOfState()));
        holder.reading25.setText(String.valueOf(model.getLatestAdmissionsSatScores25thPercentileCriticalReading()));
        holder.reading75.setText(String.valueOf(model.getLatestAdmissionsSatScores75thPercentileCriticalReading()));
        holder.math25.setText(String.valueOf(model.getLatestAdmissionsSatScores25thPercentileMath()));
        holder.math75.setText(String.valueOf(model.getLatestAdmissionsSatScores75thPercentileMath()));
    }

    @NonNull
    @Override
    public CollegeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_item,
                parent, false);
        return new CollegeHolder(view);
    }

    class CollegeHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView id;
        TextView state;
        TextView city;
        TextView zip;
        TextView url;
        TextView inStateTuition;
        TextView outOfStateTuition;
        TextView reading25;
        TextView reading75;
        TextView math25;
        TextView math75;

        public CollegeHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.collegeTitle);
            id = itemView.findViewById(R.id.id);
            state = itemView.findViewById(R.id.state);
            city = itemView.findViewById(R.id.city);
            zip = itemView.findViewById(R.id.zip);
            url = itemView.findViewById(R.id.url);
            inStateTuition = itemView.findViewById(R.id.inStateTuition);
            outOfStateTuition = itemView.findViewById(R.id.outOfStateTuition);
            reading25 = itemView.findViewById(R.id.reading25);
            reading75 = itemView.findViewById(R.id.reading75);
            math25 = itemView.findViewById(R.id.math25);
            math75 = itemView.findViewById(R.id.math75);
        }
    }
}
