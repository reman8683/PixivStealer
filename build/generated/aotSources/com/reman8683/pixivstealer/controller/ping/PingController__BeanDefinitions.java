package com.reman8683.pixivstealer.controller.ping;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PingController}
 */
public class PingController__BeanDefinitions {
  /**
   * Get the bean definition for 'pingController'
   */
  public static BeanDefinition getPingControllerBeanDefinition() {
    Class<?> beanType = PingController.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(PingController::new);
    return beanDefinition;
  }
}
