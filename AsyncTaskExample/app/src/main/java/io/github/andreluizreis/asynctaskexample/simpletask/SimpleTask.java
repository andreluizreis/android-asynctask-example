package io.github.andreluizreis.asynctaskexample.simpletask;

/**
 * Created by Andre Luiz Reis on 2016-11-09.
 */

import android.os.AsyncTask;
import android.os.SystemClock;

/**
 * Created by Alcar on 2016-11-08.
 */

public class SimpleTask extends AsyncTask<String, Void, Integer> {

    /**
     * Callback interface through which the fragment will report the
     * task's progress and results back to the Activity.
     */
    interface TaskCallbacks {
        void onPostExecute(Integer integer);
    }

    /**
     * TaskCallbacks Attribute
     */
    TaskCallbacks mTaskCallbacks;

    /**
     *  Constructor
     */
    public SimpleTask( TaskCallbacks taskCallbacks){
        mTaskCallbacks = taskCallbacks;
    }

    /**
     * Process what it needs to do
     * @param parameters
     * @return
     */
    @Override
    protected Integer doInBackground(String... parameters) {
        for (int i = 0; !isCancelled() && i < 100; i++) {
            SystemClock.sleep(50);
        }
        System.out.println(parameters[0]);

        return 1000;
    }

    /**
     * Return Method with the result to the Activity
     * @param integer
     */
    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        mTaskCallbacks.onPostExecute(integer);
    }
}
