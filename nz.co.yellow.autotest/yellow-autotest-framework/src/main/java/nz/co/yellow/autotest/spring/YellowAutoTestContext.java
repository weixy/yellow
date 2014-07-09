package nz.co.yellow.autotest.spring;

import nz.co.yellow.autotest.utils.WaitForLoading;
import nz.co.yellow.sandbox.ScriptWithTryAgain;
import org.springframework.beans.factory.annotation.Value;
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
        nameGenerator = FullyQualifiedBeanNameGenerator.class,
        excludeFilters = {
                @Filter(type = FilterType.CUSTOM, value = AutoTextExcludeFilter.class)
        }
)
@Import(YellowSeleniumTestContext.class)
@EnableAspectJAutoProxy

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

//    @Bean
//    static public String printProperties(@Value("${beryllium.map.package}") String a) {
//
//        //System.out.println(a);
//        return a;
//    }

    @Bean
    static public ScriptWithTryAgain scriptWithTryAgain() {
        return new ScriptWithTryAgain();
    }


    static Resource[] properties() {
        return new Resource[] {
            new ClassPathResource("yellow.auto.properties"),
            new ClassPathResource("selenium.properties")
        };
    }
}
