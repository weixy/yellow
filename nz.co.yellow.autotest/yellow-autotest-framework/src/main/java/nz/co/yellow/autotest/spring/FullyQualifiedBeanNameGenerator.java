package nz.co.yellow.autotest.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * Created by jim.wei@yellow.co.nz on 29/06/14.
 */
public class FullyQualifiedBeanNameGenerator extends AnnotationBeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        String[] components = definition.getBeanClassName().split("\\.");
        if (components.length > 2)
            if (components[components.length - 2].matches("v[0-9]+"))
                return buildDefaultBeanName(definition) + "V" + components[components.length - 2].substring(1);

        return super.generateBeanName(definition, registry);
    }
}
