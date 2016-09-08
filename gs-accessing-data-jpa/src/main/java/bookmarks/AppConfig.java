package bookmarks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bookmarks.hello.HelloWorld;
import bookmarks.hello.HelloWorldImpl;

@Configuration
public class AppConfig
    {

	@Bean(name="helloBean")
	public HelloWorld helloWorld()
	{
	    return new HelloWorldImpl();
	}
    }
