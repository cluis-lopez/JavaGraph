package com.clopez.grafql;

import java.util.ArrayList;
import java.util.List;

public class Database {
	List<Node> nodes;
	List<Edge> edges;

	public Database() {
		nodes = new ArrayList<>();
		edges = new ArrayList<>();
	}

	public void writeNode(Node... n) {
		for (Node i: n)
			nodes.add(i);
	}

	public void writeEdge(Edge... e) {
		for (Edge i: e)
			edges.add(i);
	}

	public List<Node> getNode(String kind) {
		List<Node> ret = new ArrayList<>(); 
		for (Node n: nodes) {
			if (n.getKind().equals(kind))
				ret.add(n);
		}
		return ret;
	}

	public Node getNode(String kind, String key, Object v){
		List<Node> nod = getNode(kind);
		Node ret = null;
		for (Node n: nod) {
			if (n.has(key, v)) {
				ret = n;
				break;
			}
		}
		return ret;
	}
	
	public List<Node> getNodeWithEdge(String name){
		List<Node> ret= new ArrayList<>();
		List<Node> temp = new ArrayList<>();
		for (Node n: nodes) {
			temp = n.outE(name);
			ret.addAll(temp);
		}
		return ret;
	}
	
}
