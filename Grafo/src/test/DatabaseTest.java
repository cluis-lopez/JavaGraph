package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.clopez.grafql.Database;
import com.clopez.grafql.Edge;
import com.clopez.grafql.Node;

public class DatabaseTest {

	Node c, g, p;
	Edge e1, e2, f1, f2;
	Database db;

	@Test
	public void testDatabase() {
		db = new Database();
		c = new Node("Persona", "name", "Carlos");
		g = new Node("Persona", "name", "Gorka");
		p = new Node("Ciudad", "name", "Las Rozas");
		p.addKeyPair("Alcalde", "PP");
		e1 = c.addEdge("amigo_de", g);
		e2 = g.addEdge("amigo_de", c);
		f1 = c.addEdge("vive_en", p);
		f2 = g.addEdge("vive_en", p);
		db.writeNode(c, g, p);
		db.writeEdge(e1, e2, f1, f2);
		assertTrue("Hay dos nodos de tipo 'Persona'", db.getNode("Persona").size() == 2);
		assertTrue("Carlos es amigo de Gorka", db.getNode("Persona", "name", "Carlos").outE().contains(g));
		assertTrue("Gorka es amigo de Carlos", db.getNode("Persona", "name", "Gorka").outE().contains(c));
		assertTrue("Gorka vive en Las Rozas", (db.getNode("Persona", "name", "Gorka").outE("vive_en")).get(0).has("name").equals("Las Rozas"));
		assertTrue("Dos presonas viven en Las Rozas", db.getNodeWithEdge("vive_en").size() == 2);
	}

}
