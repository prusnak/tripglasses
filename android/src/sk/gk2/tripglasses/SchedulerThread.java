package sk.gk2.tripglasses;

import android.os.Handler;

public class SchedulerThread extends Thread {

	private Handler handler;
	private boolean finished = false;
	
	public SchedulerThread(Handler handler) {
		this.handler = handler;
		finished = false;
	}
	
    public void finish() {
        finished = true;
    }

	public void run() {
		try {
			handler.sendEmptyMessage(2); if (finished) return; sleep(60000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(10000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep(20000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(20000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep(10000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(30000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep( 5000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(60000); if (finished) return;
			handler.sendEmptyMessage(4); if (finished) return; sleep(10000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(30000); if (finished) return;
			handler.sendEmptyMessage(4); if (finished) return; sleep(20000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(30000); if (finished) return;
			handler.sendEmptyMessage(4); if (finished) return; sleep(30000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(4); if (finished) return; sleep(60000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep( 1000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(4); if (finished) return; sleep(60000); if (finished) return;
			handler.sendEmptyMessage(3); if (finished) return; sleep( 1000); if (finished) return;
			handler.sendEmptyMessage(4); if (finished) return; sleep(10000); if (finished) return;
			handler.sendEmptyMessage(3); if (finished) return; sleep( 1000); if (finished) return;
			handler.sendEmptyMessage(4); if (finished) return; sleep(10000); if (finished) return;
			handler.sendEmptyMessage(3); if (finished) return; sleep( 1000); if (finished) return;
			handler.sendEmptyMessage(4); if (finished) return; sleep(30000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep( 1000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(4); if (finished) return; sleep(30000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep( 1000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(20000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep( 5000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(20000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(15000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep(20000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep(10000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep(25000); if (finished) return;
			handler.sendEmptyMessage(1); if (finished) return; sleep( 5000); if (finished) return;
			handler.sendEmptyMessage(2); if (finished) return; sleep(60000); if (finished) return;
			handler.sendEmptyMessage(0);		
		} catch (InterruptedException e) {
			// Pokemon
		}
	}
}
