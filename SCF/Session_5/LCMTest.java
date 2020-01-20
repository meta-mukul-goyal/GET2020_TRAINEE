package scf_5;

import static org.junit.Assert.*;

import org.junit.Test;


public class LCMTest {

	LcmHcf LcmHcfObj = new LcmHcf();

	@Test
	public void WhenTwoIntegersArePassed() {
		int result = LcmHcfObj.lcm(5,7);
		assertEquals(35,result);
	}
	
	@Test
	public void WhenTwoIntegersArePassed1() {
		int result = LcmHcfObj.lcm(1,15);
		assertEquals(30,result);
	}

	@Test
	public void WhenTwoIntegersArePassed2() {
		int result = LcmHcfObj.lcm(25,30);
		assertEquals(150,result);
	}
	
	@Test
	public void WhenTwoIntegersArePassed3() {
		int result = LcmHcfObj.lcm(75,30);
		assertEquals(150,result);
	}
	
	
	@Test
	public void WhenTwoIntegersArePassed4() {
		int result = LcmHcfObj.hcf(5,7);
		assertEquals(1,result);
	}
	
	@Test
	public void WhenTwoIntegersArePassed5() {
		int result = LcmHcfObj.hcf(10,15);
		assertEquals(5,result);
	}

	@Test
	public void WhenTwoIntegersArePassed6() {
		int result = LcmHcfObj.hcf(25,30);
		assertEquals(5,result);
	}
	
	@Test
	public void WhenTwoIntegersArePassed7() {
		int result = LcmHcfObj.hcf(75,30);
		assertEquals(15,result);
	}
	
}
