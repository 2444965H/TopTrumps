package testing;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import commandline.Cards;

/**
 * @author Miruna
 * @author Linh
 */
public class CardsTest {
	public static Cards cardTest;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cardTest = new Cards("Test", 1, 2, 3, 4, 5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		cardTest = null;
	}

///////// Getting an array with values of all the attributes of the card
	@Test
	public void attributeArray() {
		ArrayList<Integer> attributes = cardTest.attributeArray(); //attributeArray() is method from Cards 
		//that returns an Integer Array with the 5 values of the card
		
		ArrayList<Integer> expectedAttributes = new ArrayList<Integer>();
		expectedAttributes.add(1);
		expectedAttributes.add(2);
		expectedAttributes.add(3);
		expectedAttributes.add(4);
		expectedAttributes.add(5);
		assertEquals(expectedAttributes, attributes);
	}

/////////// Testing getting the max index
	@Test
	public void getMax() {
		int maxIndex = cardTest.getMax();
		assertEquals(4,maxIndex);

	}

/////////// Getting an array with the names of the attributes of the card
	@Test
	public void attributeNames() {
		ArrayList<String> attributes = cardTest.attributeNames();//attributeNames() is method from Cards 
		//that returns an String Array with the 5 values of the card
		
		ArrayList<String> expectedAttributes = new ArrayList<String>();
		expectedAttributes.add("size");
		expectedAttributes.add("speed");
		expectedAttributes.add("cargo");
		expectedAttributes.add("range");
		expectedAttributes.add("firepower");
		assertEquals(expectedAttributes, attributes);
	}
}
