package io.github.andreluizreis.asynctaskexample.normaltask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.andreluizreis.asynctaskexample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DummyTaskCallback dummyTaskCallback = new DummyTaskCallback();
        DummyTask dummyTask = new DummyTask(dummyTaskCallback);
        dummyTask.execute("Parameter");
    }



    // region ############### Inner Class ######################

    /**
     * Callback InnerClass
     */
    private class DummyTaskCallback implements DummyTask.TaskCallbacks {

        @Override
        public void onProgressUpdate(int percent) {
            System.out.println("Progress: " + percent);
        }

        @Override
        public void onPostExecute(Integer integer)
        {
            System.out.println("The number is: " + integer);
        }
    }
}
