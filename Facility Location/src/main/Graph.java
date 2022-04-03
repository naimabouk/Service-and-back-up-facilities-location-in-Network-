package main;

import java.util.ArrayList;

public class Graph {

	private double[][] edges;
	private Node[] labels;
	private final int V;
	private int E;

	public Graph(int v) {
		V = v;
		edges = new double[V][V];
		labels = new Node[V];
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void setLabel(int vertex, Node label) {
		labels[vertex] = label;
	}

	public Node getLabel(int vertex) {
		return labels[vertex];
	}

	public void addEdge(int node1, int node2, double w) {
		edges[node1][node2] = w;
		edges[node2][node1] = w;
		E++;
	}

	public boolean isEdge(int node1, int node2) {
		return edges[node1][node2] > 0;
	}

	public void removeEdge(int node1, int node2) {
		edges[node1][node2] = 0;
		edges[node2][node1] = 0;
		E--;
	}

	public double getWeight(int node1, int node2) {
		return edges[node1][node2];
	}

	public void removeNode(int node) {
		for (int i = 0; i < V; i++) {
			edges[node][i] = 0;
			edges[i][node] = 0;
		}
	}

	public ArrayList<Integer> getAdj(int node) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < V(); i++)
			if (edges[node][i] > 0)
				list.add(i);
		return list;
	}

	public ArrayList<Integer> getTipNodes() {
		ArrayList<Integer> list = new ArrayList<>();
		int count;
		for (int i = 0; i < V(); i++) {
			count = 0;
			for (int j = 0; j < V() && count <= 1; j++)
				if (edges[i][j] > 0)
					count++;

			if (count == 1)
				list.add(i);
		}
		return list;
	}

	public double[] Dijkstra(int src) {
		Boolean sptSet[] = new Boolean[V];
		double dist[] = new double[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && edges[u][v] != 0 && dist[u] != Double.POSITIVE_INFINITY
						&& dist[u] + edges[u][v] < dist[v])
					dist[v] = dist[u] + edges[u][v];
		}
		return dist;
	}

	private int minDistance(double dist[], Boolean sptSet[]) {
		double min = Double.POSITIVE_INFINITY;
		int minIndex = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}
		return minIndex;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("vertex: " + V() + " , Edges : " + E());
		for (int i = 0; i < V(); i++) {
			s.append("\n" + labels[i].getName() + " => ");
			for (int j = 0; j < V(); j++)
				if (edges[i][j] > 0)
					s.append("[" + labels[j].getName() + " , " + edges[i][j] + "] ");
		}
		return s.toString();
	}

}
