package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// Initialize the graph
		Node[] nodes = { new Node("1", 1), new Node("2", 4), new Node("3", 3), new Node("4", 5), new Node("5", 2),
				new Node("6", 1), new Node("7", 7), new Node("8", 1), new Node("9", 4), new Node("10", 6),
				new Node("11", 3), new Node("12", 3), new Node("13", 1) };

		Graph graph = new Graph(nodes.length);

		
		for(Node n:  nodes)
			n.setMaxDist(7);
		
		for (int i = 0; i < graph.V(); i++) {
			graph.setLabel(i, nodes[i]);
		}

		graph.addEdge(0, 1, 4);
		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 4, 3);
		graph.addEdge(4, 5, 2);
		graph.addEdge(3, 6, 2);
		graph.addEdge(6, 7, 6);
		graph.addEdge(7, 10, 4);
		graph.addEdge(10, 11, 2);
		graph.addEdge(11, 12, 3);
		graph.addEdge(9, 8, 1);
		graph.addEdge(8, 7, 7);

		System.out.println(graph);
		System.out.println();

		// Placing the facilities
		ArrayList<Facility> facilities = new ArrayList<>();

		ArrayList<Integer> tipNodes = graph.getTipNodes();

		while (!tipNodes.isEmpty()) {

			int tipNode = tipNodes.get(0);

			int nextNode = graph.getAdj(tipNode).get(0);

			Facility facility = new Facility("x" + (facilities.size() + 1), graph.getLabel(tipNode),
					graph.getLabel(nextNode));

			double[] dist = graph.Dijkstra(tipNode);
			for (int i = 0; i < dist.length; i++)
				if (dist[i] - facility.getDistNode() <= graph.getLabel(i).getMaxDist()) {
					facility.addNode(graph.getLabel(i));
					graph.removeNode(i);
				}

			facilities.add(facility);
			tipNodes = graph.getTipNodes();
		}
		for (Facility f : facilities)
			System.out.println(f);

	}

}
