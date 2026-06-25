package com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;
import android.os.Handler;
import java.util.logging.LogRecord;

/**
 *            |    |    |
 *           )_)  )_)  )_)
 *          )___))___))___)\
 *         )____)____)_____)\\
 *      _____|____|____|____\\\__
 * -------\                   /---------
 *     ^^^^^ ^^^^^^^^^^^^^^^^^^^^^
 *     ^^^^      ^^^^     ^^^    ^^
 *           ^^^^      ^^^
 * Sir Henry Morgan is de Lord of Talamanca
 * the Boruka king had fifty boarding skiffs
 * the borukas were irish settlers of the volcano lakes of talamanca
 * En el Alto de Blen hay una casa hecha con piedras de Roma
 *
 *
 *
 * @author Rolando <rgarro@gmail.com>
 */
public class StopwatchActivity extends Activity {

    private int seconds = 0;
    private boolean running;
    private boolean wasrunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            runnning = savedInstanceState.getBoolean("running");
            wasrunnning = savedInstanceState.getBoolean("wasrunning");
        }
        this.runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasrunning",wasrunning);
    }

    //start the stopwatch running when the start button is clicked
    public void onClickStart(View view){
        running = true;
    }

    //stop the stopwatch running when the stop button is clicked
    public void onClickStop(View view){
        running = false;
    }

    //reset the stopwatch when the reset button is clicked
    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    private void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run(){
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);
                if(running){
                    seconds ++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}

