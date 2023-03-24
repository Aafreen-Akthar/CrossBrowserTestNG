package edu.training.test;

import org.testng.annotations.Test;

import edu.training.base.BaseClass;
import edu.training.pages.LoginPage;

public class TestClassTask1 extends BaseClass {
	
	LoginPage l = new LoginPage();
	
    @Test
	public void testChrome() throws InterruptedException {
		browserCall("chrome");
		l.loginCommon();
    }
    @Test
    public void testEdge() throws InterruptedException {
		browserCall("edge");
		l.loginCommon();
    }
    @Test
	public void testFirefox() throws InterruptedException {	
		browserCall("firefox");
		l.loginCommon();
	}

	}

	

