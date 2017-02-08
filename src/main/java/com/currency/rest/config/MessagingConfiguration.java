package com.currency.rest.config;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

/**
 * This class is used to configure the ActiveMQ.
 * 
 * @author Macbook pro
 *
 */
@Configuration
public class MessagingConfiguration {

	/**
	 * LOGGER for MessagingConfiguration class.
	 */
	public static Logger LOG = LoggerFactory.getLogger(MessagingConfiguration.class);

	/**
	 * default url for the ActiveMQ connection.
	 */
	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

	/**
	 * Name of the queue, which is used to store in the ActiveMQ.
	 */
	private static final String QUEUE_NAME = "currencyQueue";

	/**
	 * This method is used to make the connection to ActiveMQ.
	 * 
	 * @return ActiveMQConnectionFactory -
	 */
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		LOG.info("MessagingConfiguration : connectionFactory : start");
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		// connectionFactory).setTrustedPackages(Arrays.asList("com.currency.rest","java.util"));
		return connectionFactory;
	}

	/**
	 * This method is used to make the connection to the queue in ActiveMQ.
	 * 
	 * @return JmsTemplate - template for the ActiveMQ.
	 */
	@Bean
	public JmsTemplate jmsTemplate() {
		LOG.info("MessagingConfiguration : jmsTemplate : start");
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(QUEUE_NAME);
		return template;
	}

}
