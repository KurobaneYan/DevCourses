package com.netcracker.sd4.rest.configuratin;

import com.netcracker.sd4.persistence.configuration.PersistenceConfiguration;
import com.netcracker.sd4.rest.converters.CarToCarDtoConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@PropertySource("classpath:messages.properties")
@Import(PersistenceConfiguration.class)
public class RestConfiguration {

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(getConverters());
        return conversionServiceFactoryBean;
    }

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
//        converters.add(new CountryToCountryDTOConverter());
//        converters.add(new CountryDTOToCountryConverter());
//        converters.add(new FlightToFlightDTOConverter());
        converters.add(new CarToCarDtoConverter());
        return converters;
    }
}
