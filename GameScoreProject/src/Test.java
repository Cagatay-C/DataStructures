
public class Test {

	public static void main(String[] args) {
		GameEntry game = new GameEntry("cagatay", 100);
		GameEntry game2 = new GameEntry("caglar", 50);
		GameEntry game3 = new GameEntry("cagan", 500);
		Scores gameScores = new Scores();
		
		gameScores.add(game);
		gameScores.add(game2);
		gameScores.add(game3);
		System.out.println(gameScores.toString());
		gameScores.remove(2);
		System.out.println("After remove operation---");
		System.out.println(gameScores.toString());
	}

}
