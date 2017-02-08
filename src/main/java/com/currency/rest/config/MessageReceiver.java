/**
 * 
 */
package com.currency.rest.config;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.currency.rest.model.CurrencyData;

/**
 * This class receives the message or object from the ActiveMQ and sends it to
 * WebSocket.
 * 
 * @author Macbook pro
 *
 */
@Component
public class MessageReceiver {

	/**
	 * SimpMessagingTemplate for WebSocket.
	 */
	@Autowired
	private SimpMessagingTemplate template;

	/**
	 * LOGGER for MessageReceiver class.
	 */
	public static Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

	/**
	 * Name of the queue from which messages needs to retrieved.
	 */
	private static final String QUEUE_NAME = "currencyQueue";

	/**
	 * This method gets the data from the ActiveMQ and puts into the WebSoctket.
	 * 
	 * @param message
	 *            - the actual message or the CurrencyData object.
	 * @throws JMSException
	 */
	@JmsListener(destination = QUEUE_NAME)
	public void receiveMessage(final Message<CurrencyData> message) throws JMSException {
		try {
			LOG.info("SimpMessagingTemplate : receiveMessage : start");
			MessageHeaders headers = message.getHeaders();
			LOG.info("SimpMessagingTemplate : receiveMessage : headers received : {}", headers);
			CurrencyData response = message.getPayload();
			this.template.convertAndSend("/topic/greetings", response);
			LOG.info("SimpMessagingTemplate : receiveMessage : response received : {}", response);
			LOG.info("SimpMessagingTemplate : receiveMessage : End");
		} catch (MessagingException e) {
			LOG.error("SimpMessagingTemplate : receiveMessage : MessagingException exception occured {}",
					e.getMessage());
		}
	}
}
