/**
 * 
 */
package com.currency.rest.config;

/**
 * @author Macbook pro
 *
 */
import javax.jms.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

/**
 * This class is used to make the listener configurations for ActiveMQ.
 * 
 * @author Macbook pro
 *
 */
@Configuration
@EnableJms
public class MessagingListnerConfiguration {

	/**
	 * LOGGER for MessagingListnerConfiguration class.
	 */
	public static Logger LOG = LoggerFactory.getLogger(MessagingListnerConfiguration.class);

	/**
	 * connectionFactory object for listener connections.
	 */
	@Autowired
	ConnectionFactory connectionFactory;

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		LOG.info("MessagingListnerConfiguration : jmsListenerContainerFactory : start");
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrency("1-1");
		LOG.info("MessagingListnerConfiguration : jmsListenerContainerFactory : end");
		return factory;
	}

}
