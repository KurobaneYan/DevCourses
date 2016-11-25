package com.netcracker.sd4.portlet.configuration;

import com.netcracker.sd4.client.configuration.RestClientConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RestClientConfiguration.class)
public class PortletConfiguration {
}
