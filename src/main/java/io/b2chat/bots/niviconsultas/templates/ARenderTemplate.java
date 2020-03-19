package io.b2chat.bots.niviconsultas.templates;

import org.springframework.context.MessageSource;

import com.vertical.bot.util.BeansProvider;

public abstract class ARenderTemplate implements IRenderTemplate {

	MessageSource messageSource = BeansProvider.getBean(MessageSource.class);
}