package sk.gk2.tripglasses;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

enum Wave {
    None,
    Alpha,
    Beta,
    Delta,
    Theta
}

public class MainActivity extends Activity {

    private AudioTrack audio;
    short[] bufAlpha = new short[44100*2];
    short[] bufBeta  = new short[44100*2];
    short[] bufDelta = new short[44100*2];
    short[] bufTheta = new short[44100*2];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 44100; i++) {
            double time = i / 44100.0;
            bufAlpha[i*2  ] = (short)(Math.sin(2*Math.PI*200.321*time) * Short.MAX_VALUE);
            bufAlpha[i*2+1] = (short)(Math.sin(2*Math.PI*211.416*time) * Short.MAX_VALUE);
            bufBeta [i*2  ] = (short)(Math.sin(2*Math.PI*200.321*time) * Short.MAX_VALUE);
            bufBeta [i*2+1] = (short)(Math.sin(2*Math.PI*214.719*time) * Short.MAX_VALUE);
            bufDelta[i*2  ] = (short)(Math.sin(2*Math.PI*200.321*time) * Short.MAX_VALUE);
            bufDelta[i*2+1] = (short)(Math.sin(2*Math.PI*202.521*time) * Short.MAX_VALUE);
            bufTheta[i*2  ] = (short)(Math.sin(2*Math.PI*200.321*time) * Short.MAX_VALUE);
            bufTheta[i*2+1] = (short)(Math.sin(2*Math.PI*206.324*time) * Short.MAX_VALUE);
        }

        int minSize = AudioTrack.getMinBufferSize( 44100, AudioFormat.CHANNEL_CONFIGURATION_STEREO, AudioFormat.ENCODING_PCM_16BIT );
        audio = new AudioTrack( AudioManager.STREAM_MUSIC, 44100,  AudioFormat.CHANNEL_CONFIGURATION_STEREO, AudioFormat.ENCODING_PCM_16BIT, minSize, AudioTrack.MODE_STREAM);
        audio.play();
        audio.write(bufAlpha, 0, bufAlpha.length);
        audio.write(bufBeta,  0, bufBeta.length);
        audio.write(bufDelta, 0, bufDelta.length);
        audio.write(bufTheta, 0, bufTheta.length);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
