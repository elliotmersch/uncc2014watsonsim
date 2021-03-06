package uncc2014watsonsim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScorerTest {

	// Setup possible inputs
	Answer yahoo1;
	Answer yahoo2;
	Answer bing1;
	Answer bing2;
	Learner ml;
	
	@Before
	public void setUp() {
		// Setup possible inputs
		yahoo1 = new Answer("yahoo", "Alligators", "text", "reference", 1, 0.75);
		yahoo2 = new Answer("yahoo", "Eels", "text", "reference", 2, 0.38);
		bing1 = new Answer("bing", "Alligators", "text", "reference", 1, 0.25);
		bing2 = new Answer("bing", "Elk", "text", "reference", 2, 0.19);
		ml = new AverageLearner();
	}

	@Test
	public void testOne() throws Exception {
		// Make an exact copy when there is 1 result
		Question q = new Question("Fake Question?");
		q.add(yahoo1);
		ml.test(q);
		assertEquals(q.get(0), yahoo1);
		assertEquals(q.get(0).scores.get("combined"), AverageLearner.logistic(0.75), 0.001);
	}
	
	@Test
	public void testTwo() throws Exception {
		// Average two results
		Question q = new Question("Fake Question?");
		q.add(yahoo1);
		q.add(bing1);
		ml.test(q);
		assertEquals(q.get(0), yahoo1);
		assertEquals(q.get(0).scores.get("combined"), AverageLearner.logistic(0.5), 0.001);
	}
		
	@Test
	public void testSort() throws Exception {
		// Sort unique results
		Question q = new Question("Fake Question?");
		q.add(yahoo1);
		q.add(yahoo2);
		q.add(bing1);
		q.add(bing2);
		ml.test(q);
		assertEquals("Alligators", q.get(0).getTitle());
		assertEquals("Eels", q.get(1).getTitle());
		assertEquals("Elk", q.get(2).getTitle());
	}

}
