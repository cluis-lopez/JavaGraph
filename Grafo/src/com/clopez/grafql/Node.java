package com.clopez.grafql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node {
	
	/**
	 * 
	 */

	private String kind;
	private HashMap<String,Object> keypair;
	private ArrayList<Edge> edges;
	
	public Node(String k) {
		kind = k;
		keypair = new HashMap<>();
		edges = new ArrayList<>();
	}
	
	public Node(String k, String key, Object val) {
		kind = k;
		keypair = new HashMap<>();
		edges = new ArrayList<>();
		keypair.put(key, val);
	}
	
	public String getKind() {
		return kind;
	}
	
	public Edge addEdge(String name, Node n) {
		Edge e = new Edge(name, this, n);
		edges.add(e);
		return e;
	}
	
	public void addKeyPair(String k, Object v) {
		keypair.put(k, v);
	}
	
	public List<Edge> getEdges(){
		return edges;
	}
	
	public boolean has(String k, Object v) {
		if ( ! keypair.containsKey(k))
			return false;
		if (keypair.get(k).equals(v))
			return true;
		return false;
	}
	
	public Object has(String k) {
		return keypair.get(k);
	}
	
	public ArrayList<Node> outE(){
		ArrayList<Node> nodes = new ArrayList<>();
		for(Edge e: edges) {
			nodes.add(e.getTo());
		}
		return nodes;
		
	}
	
	public ArrayList<Node> outE(String key){
		ArrayList<Node> nodes = new ArrayList<>();
		for(Edge e: edges) {
			if (e.getName().equals(key))
				nodes.add(e.getTo());
		}
		return nodes;
		
	}
	
	public boolean hasEdges() {
		return !edges.isEmpty();
	}

}
