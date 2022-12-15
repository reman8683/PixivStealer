package com.reman8683.pixivstealer;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link PixivStealerApplication}
 */
public class PixivStealerApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'pixivStealerApplication'
   */
  public static BeanDefinition getPixivStealerApplicationBeanDefinition() {
    Class<?> beanType = PixivStealerApplication.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(PixivStealerApplication.class);
    beanDefinition.setInstanceSupplier(PixivStealerApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
