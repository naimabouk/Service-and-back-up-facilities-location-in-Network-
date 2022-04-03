package main;

public class Node {

	private String name;
	private double maxDist;// the maximum allowable facility distance

	public Node(String name, double maxDist) {
		this.name = name;
		this.maxDist = maxDist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMaxDist() {
		return maxDist;
	}

	public void setMaxDist(double maxDist) {
		this.maxDist = maxDist;
	}

}
