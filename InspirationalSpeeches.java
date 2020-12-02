// Kate McCarthy
// 12-01-2020
// Builds inspirational speeches featuring quotes by famous speakers

import java.util.concurrent.locks.ReentrantLock;

public class InspirationalSpeeches {
	public static void main(String[] args) {

		Podium front = new Podium();
		Teleprompter primary = new Teleprompter();
		Thread sp1 = new Thread( new Speaker ( primary.pPicasso, front));
		Thread sp2 = new Thread( new Speaker (primary.dLama, front));
		Thread sp3 = new Thread( new Speaker (primary.bObama, front));
		Thread sp4 = new Thread( new Speaker (primary.mObama, front));
		Thread sp5 = new Thread( new Speaker (primary.aEinstein, front));
		Thread sp6 = new Thread( new Speaker (primary.aristotle, front));

		sp1.start();
		sp2.start();
		sp3.start();
		sp4.start();
		sp5.start();
		sp6.start();

	}
}

class Podium {
	public ReentrantLock speakerLock;
	public Podium() {
		speakerLock = new ReentrantLock();
	}
	public void PASystem(String broadcast) {
		System.out.println(broadcast);
	}
}

class Speaker implements Runnable {
	private String[] quotes;
	public Podium podium;
	public Speaker(String[] quotes, Podium podium) {
		this.quotes = quotes;
		this.podium = podium;
	}
    public void run() {
    	podium.speakerLock.lock();
    	try {
	    	for(int i=0;i<quotes.length;i++) {

	    		try {
	    			Thread.sleep(800);
	    		} catch (InterruptedException e) {
	    			System.out.println("Interrupted!");
	    			System.exit(1);
	    		}

	    		podium.PASystem(quotes[i]);
	    		if (i== (quotes.length-1)) {
	    			System.out.println("\n");
	    		}
	    	}
    	} finally {
    		podium.speakerLock.unlock();
    	}
    }

}

class Teleprompter {
	public String[] pPicasso = {"Everything you can imagine is real","Good artists copy, great artists steal."};
	public String[] dLama = {"Give the ones you love wings to fly, roots to come back, and reasons to stay","Just one small positive thought in the morning can change your whole day."};
	public String[] bObama = {"I say, ‘You know what? It’s better,’ and I sleep at night","It's a long-running story; We just try to get our paragraph right."};
	public String[] mObama = {"The same sun comes up, but looking slightly different from what you know","We go high when they go low."};
	public String[] aEinstein = {"The important thing is not to stop questioning","Curiosity has its own reason for existing."};
	public String[] aristotle = {"It is possible to fail in many ways…while to succeed is possible only in one", "A friend to all is a friend to none."};
}
