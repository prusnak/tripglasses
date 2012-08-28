package sk.gk2.tripglasses;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

    private AudioThread audio;
    private VideoThread video;
    private SchedulerThread scheduler;
    private Handler handler;
    private TextView rect;
    private Activity thisact;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        rect = (TextView)findViewById(R.id.rectangle);
        thisact = this;

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0) {
                    thisact.finish();
                } else if (msg.what == 1) {
                    audio.setWave(WaveType.Alpha);
                    video.setWave(WaveType.Alpha);
                    rect.setText("α");
                } else if (msg.what == 2) {
                    audio.setWave(WaveType.Beta);
                    video.setWave(WaveType.Beta);
                    rect.setText("β");
                } else if (msg.what == 3) {
                    audio.setWave(WaveType.Delta);
                    video.setWave(WaveType.Delta);
                    rect.setText("δ");
                } else if (msg.what == 4) {
                    audio.setWave(WaveType.Theta);
                    video.setWave(WaveType.Theta);
                    rect.setText("θ");
                } else {
                    rect.setBackgroundColor(msg.what);
                }
            }
        };

        audio = new AudioThread();
        video = new VideoThread(handler);

        scheduler = new SchedulerThread(handler);

        audio.setWave(WaveType.Alpha);
        video.setWave(WaveType.Alpha);
        rect.setText("Alpha");

        audio.start();
        video.start();
        scheduler.start();

    }

    @Override
    public void finish() {
        audio.finish();
        video.finish();
        scheduler.finish();
        super.finish();
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_alpha:
            scheduler.finish();
            audio.setWave(WaveType.Alpha);
            video.setWave(WaveType.Alpha);
            rect.setText("α");
            break;
        case R.id.menu_beta:
            scheduler.finish();
            audio.setWave(WaveType.Beta);
            video.setWave(WaveType.Beta);
            rect.setText("β");
            break;
        case R.id.menu_delta:
            scheduler.finish();
            audio.setWave(WaveType.Delta);
            video.setWave(WaveType.Delta);
            rect.setText("δ");
            break;
        case R.id.menu_theta:
            scheduler.finish();
            audio.setWave(WaveType.Theta);
            video.setWave(WaveType.Theta);
            rect.setText("θ");
            break;
        case R.id.menu_exit:
            scheduler.finish();
            audio.finish();
            video.finish();
            this.finish();
            break;
        }

        return super.onMenuItemSelected(featureId, item);
    }

}
