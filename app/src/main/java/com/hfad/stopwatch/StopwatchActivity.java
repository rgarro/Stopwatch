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
 *
 *
 *
 * @author Rolando <rgarro@gmail.com>
 */
public class StopwatchActivity extends Activity {

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        this.runTimer();
    }

    //start the stopwatch running when the start button is clicked
    public void onClickStart(View view){
        this.running = true;
    }

    //stop the stopwatch running when the stop button is clicked
    public void onClickStop(View view){
        this.running = false;
    }

    //reset the stopwatch when the reset button is clicked
    public void onClickReset(View view){
        this.running = false;
        this.seconds = 0;
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
                String time = String.format(Locale.getDefault(),"%d:%02d",hours,minutes,secs);
                timeView.setText(time);
                if(running){
                    seconds ++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}

