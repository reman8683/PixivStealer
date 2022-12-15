package com.reman8683.pixivstealer.controller.pixivstealer;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PixivStealerController}
 */
public class PixivStealerController__BeanDefinitions {
  /**
   * Get the bean definition for 'pixivStealerController'
   */
  public static BeanDefinition getPixivStealerControllerBeanDefinition() {
    Class<?> beanType = PixivStealerController.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(PixivStealerController::new);
    return beanDefinition;
  }
}
