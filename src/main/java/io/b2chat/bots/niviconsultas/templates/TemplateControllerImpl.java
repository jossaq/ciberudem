package io.b2chat.bots.niviconsultas.templates;

import com.vertical.bot.domain.MessagingProvider;

import io.b2chat.bots.niviconsultas.Context;

public class TemplateControllerImpl implements ITemplateController{
	
	private IRenderTemplate IRenderTemplateImpl;
	protected Context automatedAdvisor;
	
	public TemplateControllerImpl(Context automatedAdvisor) {
		this.automatedAdvisor = automatedAdvisor;
		
		MessagingProvider messagingProvider = automatedAdvisor.getMessagingProvider();
		
		if(messagingProvider.equals(MessagingProvider.FACEBOOK))
			this.IRenderTemplateImpl= new RenderTemplateFB();
		else if(messagingProvider.equals(MessagingProvider.TELEGRAM))
			this.IRenderTemplateImpl= new RenderTemplateTG();
		/*else if(messagingProvider.equals(MessagingProvider.LIVECHAT))
			this.IRenderTemplateImpl= new RenderTemplateLC();*/
	}
	
	@Override
	public IRenderTemplate getRenderTemplate() {
		return this.IRenderTemplateImpl;
	}
	

}
