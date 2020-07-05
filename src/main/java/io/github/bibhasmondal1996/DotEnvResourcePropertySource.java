package io.github.bibhasmondal1996;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;

public class DotEnvResourcePropertySource  extends ResourcePropertySource {
	// Create a Pattern object
    Pattern pattern = Pattern.compile("[$][{](.+?(?=[}]))[}]");
    // Load DotEnv
    Dotenv dotEnv = Dotenv.load();

	public DotEnvResourcePropertySource(String name, EncodedResource resource) throws IOException {
        super(name, resource);
    }

    public DotEnvResourcePropertySource(EncodedResource resource) throws IOException {
        super(resource);
    }

    @Override
    public Object getProperty(String name) {
        Object value = super.getProperty(name);
        if(value != null) {
	        // Now create matcher object.
	        Matcher matcher = pattern.matcher(value.toString());
	        while(matcher.find()) {
	        	value = value.toString().replace(matcher.group(0), dotEnv.get(matcher.group(1)));
	        }
        }
        return value;
    }
}
