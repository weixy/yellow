package nz.co.yellow.autotest.utils;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by weixy on 5/07/14.
 */

@Configuration
@ComponentScan(
        basePackages = {"nz.co.yellow"},
        nameGenerator = AnnotationBeanNameGenerator.class,
        excludeFilters = {
                @Filter(type = FilterType.CUSTOM, value = AutoTextExcludeFilter.class)
        }
)

public class YellowAutoTestContext {

    @Bean
    static public PropertySourcesPlaceholderConfigurer yePropertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        Resource[] resourceLocations = properties();
        p.setLocations(resourceLocations);
        p.setIgnoreResourceNotFound(true);
        p.setIgnoreUnresolvablePlaceholders(false);
        return p;
    }

    static Resource[] properties() {
        return new Resource[] {
            new ClassPathResource("yellow.auto.properties")
        };
    }
}
