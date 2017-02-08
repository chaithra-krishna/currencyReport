/**
 * 
 */
package com.currency.rest.config;

import org.mortbay.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * This class is used do the WebSocket configurations/setup.
 * 
 * @author Macbook pro
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	/**
	 * LOGGER for WebSocketConfig class.
	 */
	public static Logger LOG = LoggerFactory.getLogger(WebSocketConfig.class);

	/**
	 * to enable the broker registry.
	 */
	public void configureMessageBroker(MessageBrokerRegistry config) {
		Log.info("WebSocketConfig : configureMessageBroker : start");
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
		Log.info("WebSocketConfig : configureMessageBroker : end");
	}

	/**
	 * To register the end point of the socket.
	 */
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		Log.info("WebSocketConfig : registerStompEndpoints : start");
		registry.addEndpoint("/ws").withSockJS();
		Log.info("WebSocketConfig : registerStompEndpoints : end");
	}

}
