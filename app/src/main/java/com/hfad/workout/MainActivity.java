package com.hfad.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowDetails(View view) {
        startActivity(new Intent(this, DetailActivity.class));
    }

    @Override
    public void itemClicked(long id) {
        View detail_container = findViewById(R.id.detail_container);
        if(detail_container != null) {
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
            workoutDetailFragment.setWorkoutID(id);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detail_container, workoutDetailFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}