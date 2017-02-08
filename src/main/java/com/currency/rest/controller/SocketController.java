/**
 * 
 */
package com.currency.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.currency.rest.model.Greeting;
import com.currency.rest.model.HelloMessage;

/**
 * This class is the front controller. It handles all the requests.
 * 
 * @author Macbook pro
 */
@Controller
public class SocketController {

	/**
	 * LOGGER for SocketController class.
	 */
	public static Logger LOG = LoggerFactory.getLogger(SocketController.class);

	@MessageMapping("/greeting")
	@SendTo("/topic/greetings")
	@RequestMapping("/currencyReport")
	public Greeting getReport(HelloMessage message) throws Exception {
		LOG.info("SocketController : getReport : start");
		return new Greeting("Welcome");
	}
}
