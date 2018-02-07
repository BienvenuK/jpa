
import poe.blablacar.converter.DateTimeConverter;

import org.springframework.context.annotation.Configuration;
	import org.springframework.format.FormatterRegistry;
	import org.springframework.web.servlet.config.annotation.EnableWebMvc;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
	
	//@Configuration
		//@EnableWebMvc
public class WebMvcContext extends WebMvcConfigurerAdapter{
	


	    @Override
	    public void addFormatters(FormatterRegistry registry) {
	        registry.addConverter(new DateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
	    }
	    
	    //nnn
	}


