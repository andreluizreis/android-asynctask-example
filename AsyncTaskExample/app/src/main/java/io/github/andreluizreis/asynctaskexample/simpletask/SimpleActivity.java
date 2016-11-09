package io.github.andreluizreis.asynctaskexample.simpletask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.github.andreluizreis.asynctaskexample.R;

public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        SimpleTaskCallback dummyTaskCallback = new SimpleTaskCallback();
        SimpleTask simpleTask = new SimpleTask(dummyTaskCallback);
        simpleTask.execute("Parameter");
    }

    // region ############### Inner Class ######################

    /**
     * Callback InnerClass
     */
    private class SimpleTaskCallback implements SimpleTask.TaskCallbacks {

        @Override
        public void onPostExecute(Integer integer)
        {
            System.out.println("The number is: " + integer);
        }
    }
}
