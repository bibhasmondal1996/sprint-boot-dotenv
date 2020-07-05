package io.github.bibhasmondal1996;

import java.io.IOException;

import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

public class DotEnvPropertySourceFactory implements PropertySourceFactory {
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		DotEnvResourcePropertySource dotEnvResourcePropertySource;
		dotEnvResourcePropertySource = name == null ?new DotEnvResourcePropertySource(resource) : new DotEnvResourcePropertySource(name, resource);
		return dotEnvResourcePropertySource;
	}
}
