package com.hfad.workout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {

    private long workoutID;

    private static final String WORKOUTID_SAVED_STATE = "WorkoutDetailFragment/WorkoutID";

    public WorkoutDetailFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            workoutID = savedInstanceState.getLong(WORKOUTID_SAVED_STATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null) {
            TextView title = view.findViewById(R.id.workoutTitle);
            TextView desc = view.findViewById(R.id.workoutDesc);
            Workout workout = Workout.workouts[(int) workoutID];
            title.setText(workout.getName());
            desc.setText(workout.getDesc());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong(WORKOUTID_SAVED_STATE, workoutID);
    }

    public void setWorkoutID(long id) {
        this.workoutID = id;
    }
}