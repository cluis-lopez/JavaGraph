package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.clopez.grafql.Edge;
import com.clopez.grafql.Node;

public class NodeTest {

	Node c, g, l, d;
	Edge a1, a2, a3, marido;
	List<Node> n = new ArrayList<>();
	
	@Test
	public void testOutE() {
		c = new Node("Persona", "name", "Carlos");
		g = new Node("Persona", "name", "Pepe");
		l = new Node("Persona", "name", "Maria");
		d = new Node("Persona", "name", "Dani");
		a1 = c.addEdge("amigo_de", g);
		a2 = g.addEdge("amigo_de", d);
		a3 = c.addEdge("amigo_de", l);
		marido = g.addEdge("casado_con", l);
		n = c.outE();
		assertTrue("Los nodos están conectados", c.hasEdges() && g.hasEdges());
		assertTrue("Los amigos de carlos son Pepe y Maria", n.contains(g) && n.contains(l));
		assertTrue("Dani no es amigo de Carlos", !n.contains(d));
		n = g.outE("casado_con");		
		assertTrue("Pepe es marido de Maria", n.contains(l));
		
	}

}
