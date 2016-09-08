package bookmarks.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldImpl implements HelloWorld
    {
	private static final Logger log = LoggerFactory.getLogger(HelloWorldImpl.class);
	@Override
	public void printHelloWorld(String msg) {
	    	log.info("Hello : "+msg);
		
	}
    }
