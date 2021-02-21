package com.hfad.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String WORKOUT_ID = "DETAIL_ACTIVITY_WORKOUT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment workoutDetailFragment =
                (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_workout_detail);
        workoutDetailFragment.setWorkoutID(getIntent().getIntExtra(WORKOUT_ID, 0));
    }
}