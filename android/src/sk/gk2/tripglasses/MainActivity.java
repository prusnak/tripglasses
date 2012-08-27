package sk.gk2.tripglasses;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    private AudioThread audio;
    private VideoThread video;
    private Handler handler;
    private View rect;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rect = findViewById(R.id.rectangle);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                rect.setBackgroundColor(msg.what);
            }
        };

        audio = new AudioThread();
        video = new VideoThread(handler);

        audio.setWave(WaveType.Alpha);
        video.setWave(WaveType.Alpha);

        audio.start();
        video.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_auto:
            // TODO
            break;
        case R.id.menu_alpha:
            audio.setWave(WaveType.Alpha);
            video.setWave(WaveType.Alpha);
            break;
        case R.id.menu_beta:
            audio.setWave(WaveType.Beta);
            video.setWave(WaveType.Beta);
            break;
        case R.id.menu_delta:
            audio.setWave(WaveType.Delta);
            video.setWave(WaveType.Delta);
            break;
        case R.id.menu_theta:
            audio.setWave(WaveType.Theta);
            video.setWave(WaveType.Theta);
            break;
        case R.id.menu_exit:
            audio.finish();
            video.finish();
            this.finish();
            break;
        }

        return super.onMenuItemSelected(featureId, item);
    }

}
