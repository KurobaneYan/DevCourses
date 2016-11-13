package com.netcracker.sd4.rest.configuratin;

import com.netcracker.sd4.persistence.configuration.PersistenceConfiguration;
import com.netcracker.sd4.rest.converters.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import weather.WeatherConfiguration;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@PropertySource("classpath:messages.properties")
@Import({PersistenceConfiguration.class, WeatherConfiguration.class})
public class RestConfiguration {

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(getConverters());
        return conversionServiceFactoryBean;
    }

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();

        converters.add(new CarToCarDtoConverter());
        converters.add(new CarDtoToCarConverter());

        converters.add(new UserToUserDtoConverter());
        converters.add(new UserDtoToUserConverter());

        converters.add(new RoleToRoleDtoConverter());
        converters.add(new RoleDtoToRoleConverter());

        converters.add(new OrderToOrderDtoConverter());
        converters.add(new OrderDtoToOrderConverter());

        converters.add(new CarInOrderToCarInOrderDtoConverter());
        converters.add(new CarInOrderDtoToCarInOrderConverter());

        return converters;
    }
}
