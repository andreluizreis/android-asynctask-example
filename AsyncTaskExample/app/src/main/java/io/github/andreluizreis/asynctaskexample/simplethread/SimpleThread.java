package io.github.andreluizreis.asynctaskexample.simplethread;

/**
 * Simple Thread
 */
public class SimpleThread extends Thread {

    /**
     * Callback Interface that needs to be implemented in the Activity.
     */
    interface SimpleThreadCallback {
        /**
         * Callback Method that needs to be implemented in the Activity.
         * @param response Return the result to the activity.
         */
        void callback(String response);
    }

    /**
     * Callback instance
     */
    private final SimpleThreadCallback mSTCallback;

    /**
     * Constructor
     * @param stCallback Simple Thread Callback instance
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
                    mSTCallback.callback(null);
                    return;
                }
            }
            mSTCallback.callback("SimpleThread => I finished correctly.");
        } catch(InterruptedException ex){
            ex.printStackTrace();
            mSTCallback.callback(null);
        }
    }
}
