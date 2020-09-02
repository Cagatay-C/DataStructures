import java.util.Arrays;

public class Scores {
	public static final int maxEntries = 10;
	protected int numEntries;
	protected GameEntry[] entries;
	
	public Scores() {
		numEntries = 0;
		entries = new GameEntry[maxEntries];
	}

	@Override
	public String toString() {
		return "Scores [numEntries=" + numEntries + ", entries=" + Arrays.toString(entries) + "]";
	}
	
	public void add(GameEntry game) {
		int score = game.getScore();
		
		if(numEntries == maxEntries) {
			if(entries[numEntries-1].getScore() >= score) {
				return;
			}
		}
		
		else
			numEntries++;
		
		int i = numEntries - 1;
		
		for(; (i >= 1) && (entries[i-1].getScore() < score); i--) {
			entries[i] = entries[i - 1];
		}
		
		entries[i] = game;
	}
	
	public GameEntry remove(int i) throws IndexOutOfBoundsException {
		if((i < 0) || (i >= maxEntries))
			throw new IndexOutOfBoundsException("Invalid index " + i);
		
		GameEntry temp = entries[i];
		for(int j=i; j < numEntries - 1; j++) {
			entries[j] = entries[j+1];
		}
		entries[numEntries-1] = null;
		numEntries--;
		return temp;
	}
}
