package com.bugsite.service;

public class PageHelper {
	public static long computePages(long recordCount, int pageSize) {
		int remainder = (int) (recordCount % pageSize);
		long pages=(recordCount/pageSize);
		if(remainder>0) {
			pages =(pages+1);
		}
		return pages;
	}
}
