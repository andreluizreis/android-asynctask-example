package io.github.andreluizreis.asynctaskexample.normaltask;

import android.os.AsyncTask;
import android.os.SystemClock;

/**
 * Created by Alcar on 2016-11-08.
 */

public class DummyTask extends AsyncTask<String, Integer, Integer> {

    /**
     * Callback interface through which the fragment will report the
     * task's progress and results back to the Activity.
     */
    interface TaskCallbacks {
        //void onPreExecute();
        void onProgressUpdate(int percent);
        //void onCancelled();
        void onPostExecute(Integer integer);
    }

    /**
     * TaskCallbacks Attribute
     */
    TaskCallbacks mTaskCallbacks;

    /**
     *  Constructor
     */
    public DummyTask( TaskCallbacks taskCallbacks){
        mTaskCallbacks = taskCallbacks;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Integer doInBackground(String... parameters) {
        for (int i = 0; !isCancelled() && i < 100; i++) {
            SystemClock.sleep(50);
            publishProgress(i);
        }
        System.out.println(parameters[0]);

        return 1000;
    }

    @Override
    protected void onProgressUpdate(Integer... percent) {
        super.onProgressUpdate(percent[0]);
        mTaskCallbacks.onProgressUpdate(percent[0]);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        mTaskCallbacks.onPostExecute(integer);
    }
}
