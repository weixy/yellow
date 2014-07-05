package nz.co.yellow.autotest.utils;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * Created by weixy on 5/07/14.
 */
public class AutoTextExcludeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
        throws IOException {
        if (metadataReader.getClassMetadata().getClassName().endsWith("Test"))
            return true;

        if (metadataReader.getClassMetadata().getClassName().endsWith("TestContext"))
            return true;

        if (metadataReader.getClassMetadata().getClassName().endsWith("YellowContext"))
            return true;
        return false;
    }
}
