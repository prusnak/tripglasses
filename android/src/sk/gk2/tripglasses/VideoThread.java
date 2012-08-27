package sk.gk2.tripglasses;

import android.os.Handler;

public class VideoThread extends Thread {

    private WaveType wave = WaveType.None;
    private boolean finished = false;
    private Handler handler;

    public VideoThread(Handler handler) {
        this.handler = handler;
    }

    public void setWave(WaveType wave) {
        this.wave = wave;
    }

    public void finish() {
        finished = true;
    }

    public void run() {
        try {
            while (!finished) {
                switch (wave) {
                case Alpha:
                    handler.sendEmptyMessage(0xFFFF0000);
                    sleep(45,065);
                    handler.sendEmptyMessage(0xFF000000);
                    sleep(45,065);
                    break;
                case Beta:
                    sleep(34,727);
                    handler.sendEmptyMessage(0xFFFF0000);
                    sleep(34,727);
                    handler.sendEmptyMessage(0xFF000000);
                    break;
                case Delta:
                    handler.sendEmptyMessage(0xFFFF0000);
                    sleep(83,292);
                    handler.sendEmptyMessage(0xFF000000);
                    sleep(83,292);
                    break;
                case Theta:
                    handler.sendEmptyMessage(0xFFFF0000);
                    sleep(227,273);
                    handler.sendEmptyMessage(0xFF000000);
                    sleep(227,273);
                    break;
                default:
                    sleep(400);
                    break;
                }
            }
        } catch (InterruptedException e) {
            // Pokemon
        }
    }
}
