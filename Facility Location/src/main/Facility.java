package main;

import java.util.ArrayList;

public class Facility {

	private String name;
	private Node node1;// node that from it we calculate the exact place of the facility
	private Node node2;
	private ArrayList<Node> coveredNodes;

	public Facility(String name, Node node1, Node node2) {
		this.name = name;
		this.node1 = node1;
		this.node2 = node2;
		coveredNodes = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNode() {
		return node1;
	}

	public void setNode(Node node) {
		this.node1 = node;
	}

	public double getDistNode() {
		return node1.getMaxDist();
	}

	public void addNode(Node n) {
		coveredNodes.add(n);
	}

	public ArrayList<Node> getCoveredNodes() {
		return coveredNodes;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Facility " + getName() + ", on edge (" + node1.getName() + ", " + node2.getName()
				+ ") from distance of " + getDistNode() + " \n");
		s.append("\t Covered nodes are ");
		for (Node n : coveredNodes)
			s.append(n.getName() + " ");
		return s.toString();
	}

}
