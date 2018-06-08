package com.clopez.grafql;

import java.util.HashMap;

public class Edge {
	
	private HashMap<String, Object> keypair;
	private String name;
	private Node from, to;
	
	public Edge(String name, Node from, Node to) {
		keypair = new HashMap<>();
		this.name = name;
		this.from = from;
		this.to= to;
	}
	
	public Node getFrom() {
		return from;
	}
	
	public Node getTo() {
		return to;
	}
	
	public void addKeyPair(String k, Object v) {
		keypair.put(k, v);
	}
	
	public boolean has(String k, Object v) {
		if ( ! keypair.containsKey(k))
			return false;
		return (keypair.get(k).equals(v));
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String ret = "";
		ret = name + "\n";
		for (String k : keypair.keySet()) {
			ret = ret + k + " : " + keypair.get(k) + "\n";
		}
		return ret;
	}

}
