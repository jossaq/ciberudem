package io.b2chat.bots.niviconsultas;

import org.slf4j.LoggerFactory;

public class BotLogger {
	
	public static final void info(Class<?> clazz, String message) {
		LoggerFactory.getLogger(clazz).info(message);
	}
	
	public static final void debug(Class<?> clazz, String message) {
		LoggerFactory.getLogger(clazz).debug(message);
	}
	
	public static final void error(Class<?> clazz, String message) {
		LoggerFactory.getLogger(clazz).error(message);
	}
	
}
