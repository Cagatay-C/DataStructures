import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {
	
	private HashMap<T, List<T>> graph = new HashMap<>();
	
	public void addVertex(T s) {
		graph.put(s, new LinkedList<T>());
	}
	
	public void addEdge(T source, T destination, boolean bidirectional) {
		
		if(!graph.containsKey(source)) {
			addVertex(source);
		}
		
		if(!graph.containsKey(destination)) {
			addVertex(destination);
		}
		
		graph.get(source).add(destination);
		if(bidirectional) {
			graph.get(destination).add(source);
		}
	}
	
	public int getVertexCount() {
		return graph.keySet().size();
	}
	
	public int getEdgesCount(boolean bidirectional) {
		int count = 0;
		
		for(T key: graph.keySet()) {
			count += graph.get(key).size();
		}
		
		if(bidirectional) {
			count /= 2;
		}
		
		return count;
	}
	
	public boolean hasVertex(T s) {
		if(graph.containsKey(s)) {
			return true;
		}return false;
	}
	
	public boolean hasEdge(T source, T destination) {
		if(graph.get(source).contains(destination)) {
			return true;
		}return false;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for(T key: graph.keySet()) {
			builder.append(key.toString() + ": ");
			for(T edge: graph.get(key)) {
				builder.append(edge.toString() + " ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
	

}
