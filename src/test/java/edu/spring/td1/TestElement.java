package edu.spring.td1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.spring.td1.models.Element;

public class TestElement {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testElement() {
		Element a=new Element("A");
		assertEquals("A", a.getNom());
	}

	@Test
	public void testEqualsObject() {
		Element a=new Element("A");
		Element b=new Element("B");
		assertNotEquals(a, b);
		Element c=new Element("A");
		assertEquals(a, c);
	}

}
