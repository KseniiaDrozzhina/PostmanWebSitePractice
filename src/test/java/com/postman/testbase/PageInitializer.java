package com.postman.testbase;

import com.postman.pages.PageElements;

public class PageInitializer extends BaseClass {

	public static PageElements main;
	
	public static void initializePageObjects() {
		main = new PageElements();	
		}
}