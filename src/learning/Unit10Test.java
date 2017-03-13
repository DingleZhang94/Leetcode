package learning;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class Unit10Test {
	private static Unit10 unit=new Unit10();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIntUnit(){
		int[] a= {1,2,3,5,7,11,13,17,19,23,27};
		assertArrayEquals(a, unit.intUnit());
	}
	
	@Test
	public void testProblem6(){
		ArrayList<Object> list=unit.problem6();
		assertEquals(32, list.get(0));
		assertEquals("This is a string.", list.get(1));
		assertEquals(Integer.valueOf(238), list.get(2));
		assertEquals(-410, list.get(3));
		assertEquals(null, list.get(4));
	}

}
