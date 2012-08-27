package sk.gk2.tripglasses;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

public class AudioThread extends Thread {

    final int FREQ = 44100;
    private AudioTrack audio;
    private short[] buf;
    private WaveType wave = WaveType.None;
    double time = 0;
    int bufSize;
    boolean finished = false;

    public void setWave(WaveType wave) {
		this.wave = wave;
	}

    public AudioThread() {
    	int minSize = AudioTrack.getMinBufferSize( FREQ, AudioFormat.CHANNEL_CONFIGURATION_STEREO, AudioFormat.ENCODING_PCM_16BIT );
        audio = new AudioTrack( AudioManager.STREAM_MUSIC, FREQ,  AudioFormat.CHANNEL_CONFIGURATION_STEREO, AudioFormat.ENCODING_PCM_16BIT, minSize, AudioTrack.MODE_STREAM);
        bufSize = minSize * 2;
    	buf = new short[bufSize];
    }
    
    public void finish() {
    	finished = true;
    }
    
    public void run() {
        audio.play();
        while (!finished) {
	        switch (wave) {
			case Alpha:
				for (int i = 0; i < bufSize/2; i++) {
			        buf[i*2  ] = (short)(Math.sin(2*Math.PI*200.321*time) * Short.MAX_VALUE);
			        buf[i*2+1] = (short)(Math.sin(2*Math.PI*211.416*time) * Short.MAX_VALUE);
			        time += 1.0/FREQ;
				}
				break;
			case Beta:
				for (int i = 0; i < bufSize/2; i++) {
					buf[i*2  ] = (short)(Math.sin(2*Math.PI*200.321*time) * Short.MAX_VALUE);
					buf[i*2+1] = (short)(Math.sin(2*Math.PI*214.719*time) * Short.MAX_VALUE);
			        time += 1.0/FREQ;
				}
				break;
			case Delta:
				for (int i = 0; i < bufSize/2; i++) {
					buf[i*2  ] = (short)(Math.sin(2*Math.PI*200.321*time) * Short.MAX_VALUE);
					buf[i*2+1] = (short)(Math.sin(2*Math.PI*202.521*time) * Short.MAX_VALUE);
			        time += 1.0/FREQ;
				}
				break;
			case Theta:
				for (int i = 0; i < bufSize/2; i++) {
					buf[i*2  ] = (short)(Math.sin(2*Math.PI*200.321*time) * Short.MAX_VALUE);
					buf[i*2+1] = (short)(Math.sin(2*Math.PI*206.324*time) * Short.MAX_VALUE);
			        time += 1.0/FREQ;
				}
		    	break;
			default:
				for (int i = 0; i < bufSize; i++) {
					buf[i] = 0;
				}
				break;
			}
	        audio.write(buf, 0, bufSize);
        }
        
    }
}