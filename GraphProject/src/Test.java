
public class Test {

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<Integer>();
		graph.addEdge(0, 1, true);
		graph.addEdge(0, 2, false);
		graph.addEdge(2, 3, false);
		
		System.out.println(graph.toString());

	}

}
