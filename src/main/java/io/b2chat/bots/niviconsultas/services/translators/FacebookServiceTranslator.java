package io.b2chat.bots.niviconsultas.services.translators;

import io.b2chat.bots.niviconsultas.domain.AccountUserProfile;

public interface FacebookServiceTranslator {

	AccountUserProfile translate(String response);

}
