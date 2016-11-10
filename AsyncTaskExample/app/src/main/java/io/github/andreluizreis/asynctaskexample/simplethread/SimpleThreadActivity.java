package io.github.andreluizreis.asynctaskexample.simplethread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.github.andreluizreis.asynctaskexample.R;

/**
 * Simple Thread Activity
 */
public class SimpleThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_thread);

        // Create the callback
        SimpleThreadCallback simpleThreadCallback = new SimpleThreadCallback();

        // Create the Simple Thread and pass the callback instance
        SimpleThread simpleThread = new SimpleThread(simpleThreadCallback);

        // Start the Simple Thread. Calling method run().
        simpleThread.start();
    }

    // region ############### Inner Class ######################

    /**
     * Callback InnerClass from SimpleThread
     */
    private class SimpleThreadCallback implements SimpleThread.SimpleThreadCallback {

        /**
         * The Thread result will be here when the thread finishes.
         * @param response Thread result
         */
        @Override
        public void callback(String response)
        {
            if(response != null) {
                System.out.println("SimpleThreadCallback => The response is: " + response);
            }else{
                System.out.println("SimpleThreadCallback => Thread had a problem");
            }

        }
    }

    // endregion
}
