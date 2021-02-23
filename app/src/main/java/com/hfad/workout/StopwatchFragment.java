package com.hfad.workout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchFragment extends Fragment implements View.OnClickListener {

    private int seconds = 0;
    private boolean running = false;
    private boolean wasRunning = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        registerListeners(layout);
        runTimer(layout);
        return layout;
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(wasRunning) {
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
        Log.d("Workout Debug", "onSavedInstanceState Called!");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_button :
                running = true;
                break;
            case R.id.stop_button:
                running = false;
                break;
            case R.id.reset_button:
                running = false;
                seconds = 0;
                break;
            default:
                break;
        }
    }

    private void registerListeners(final View layout) {
        Button btnStart = layout.findViewById(R.id.start_button);
        Button btnStop = layout.findViewById(R.id.stop_button);
        Button btnReset = layout.findViewById(R.id.reset_button);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    private void runTimer(View layout) {
        final TextView mTimeView = layout.findViewById(R.id.time_view);
        final Handler mHandler = new Handler(Looper.getMainLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                mTimeView.setText(
                        String.format(Locale.getDefault(),
                                "%d:%02d:%02d", hours, minutes, secs));
                if(running) seconds++;

                mHandler.postDelayed(this, 1000);
            }
        });
    }


}