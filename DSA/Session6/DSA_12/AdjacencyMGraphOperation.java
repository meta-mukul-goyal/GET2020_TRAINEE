package DSA_12;

public class AdjacencyMGraphOperation {
	public static void main(String[] args){
		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5);
		graph.addEdge(0,1,1);
		graph.addEdge(0,2,1);
		graph.addEdge(1,2,4);
//		graph.addEdge(2,0,4);
		graph.addEdge(2,3,15);
		graph.addEdge(1,3,1);
		graph.addEdge(2,4,7);
		graph.addEdge(3,4,20);
		graph.display();
		
		int source = 4, destination = 3;
		boolean isConnected = graph.isConnected(source);
		System.out.print("1. graph is connected: "+isConnected);
		
		if (isConnected){
			int[] reachableNodes = graph.reachable(source);
			System.out.println("\n2. reachable nodes from "+source);
			for (int i=0; i<graph.count; i++)
				System.out.println("\t"+source +" -> " + reachableNodes[i]);
//			System.out.println("minimum spanning tree:");
			int[] mstGraph = graph.mst(source);
//			for (int i=0; i<mstGraph.length-1; i++)
//				System.out.println(mstGraph[i] +" -> " + mstGraph[i+1]);
			System.out.println("3. minimum weight of graph: " + graph.total);
			
			boolean visited[] = new boolean[5];
			System.out.println("4. shortest path: "+graph.shortestPathDijk(source, destination, visited));
		}
	}

}
