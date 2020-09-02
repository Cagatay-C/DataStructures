
public class GameEntry {
	protected String name;
	protected int score;
	
	public GameEntry(String n, int s) {
		name = n;
		score = s;
	}
	
	public String getName() {return name;}
	public int getScore() {return score;}

	@Override
	public String toString() {
		return "GameEntry [name=" + name + ", score=" + score + "]";
	}
	
}
