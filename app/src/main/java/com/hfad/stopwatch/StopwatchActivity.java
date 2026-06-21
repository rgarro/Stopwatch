package com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
}
