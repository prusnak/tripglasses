package sk.gk2.tripglasses;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private AudioThread audio;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio = new AudioThread();
        audio.setWave(WaveType.Alpha);
        audio.start();        
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
    		break;
    	case R.id.menu_beta:
    		audio.setWave(WaveType.Beta);
    		break;
    	case R.id.menu_delta:
    		audio.setWave(WaveType.Delta);
    		break;
    	case R.id.menu_theta:
    		audio.setWave(WaveType.Theta);
    		break;
    	case R.id.menu_exit:
    		audio.finish();
    		this.finish();
    		break;
    	}
    	
    	return super.onMenuItemSelected(featureId, item);
    }

}
