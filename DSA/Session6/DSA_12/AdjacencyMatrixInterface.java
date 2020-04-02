package DSA_12;

public interface AdjacencyMatrixInterface {

	void display();
	boolean isConnected(int source);
	int[] reachable(int source);
	int[] mst(int source);
	void addEdge(int source, int destination, int weight);
}
