package io.github.andreluizreis.asynctaskexample.simplethread;

/**
 * Created by André Luiz Reis on 2016-11-10.
 */

/**
 * Simple Thread Example
 */
public class SimpleThread extends Thread {

    /**
     * Callback Interface that needs to be implemented in the Activity.
     */
    interface SimpleThreadCallback {
        /**
         * Callback Method that needs to be implemented in the Activity.
         * @param response
         */
        void callback(String response);
    }

    /**
     * Callback instance
     */
    SimpleThreadCallback mSTCallback;

    /**
     * Constructor
     * @param stCallback
     */
    public SimpleThread(SimpleThreadCallback stCallback){
        mSTCallback = stCallback;
    }

    /**
     * Run Method
     */
    @Override
    public void run() {
        super.run();

        try {
            for (int i = 0; i < 100; i++) {
                if(!isInterrupted()){
                    Thread.sleep(50);
                } else {
                    return;
                }
            }
            mSTCallback.callback("SimpleThread => I finished correctly.");
        } catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
