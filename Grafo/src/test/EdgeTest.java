package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.clopez.grafql.Edge;
import com.clopez.grafql.Node;

public class EdgeTest {

	private Node c;
	private Node g;
	private Edge e;

	@Test
	public void testHas() {
		c = new Node("Persona", "name", "Carlos");
		g = new Node("Persona", "name", "Gorka");
		e = c.addEdge("amigo_de", g);
		e.addKeyPair("desde", 1995);
		assertTrue("La clave 'pepe' no debe existir", !e.has("pepe", "otro"));
		assertTrue("la clave 'desde' debe de ser 1995", e.has("desde", 1995));
		assertTrue("Diferenciamos entre entero y string", !e.has("desde", "1995"));
	}

	@Test
	public void testToString() {
		c = new Node("Persona");
		g = new Node("Persona");
		e = c.addEdge("amigo_de", g);
		e.addKeyPair("desde", "1995");
		assertTrue("toString debe devolver el substring 'desde'", e.toString().subSequence(9, 14).equals("desde"));
	}

}
