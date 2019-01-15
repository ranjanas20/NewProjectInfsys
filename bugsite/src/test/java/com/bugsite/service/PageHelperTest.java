package com.bugsite.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class PageHelperTest {

	@Test
	public void testComputePages() {
		PageHelper ph = new PageHelper();
		assertTrue("Case 11-5",ph.computePages(11,5)==3);
		assertTrue("Case 10-5",ph.computePages(10,5)==2);

		assertTrue("Case 5-5",ph.computePages(5,5)==1);
		assertTrue("Case 0-5",ph.computePages(0,5)==0);

	}

}
