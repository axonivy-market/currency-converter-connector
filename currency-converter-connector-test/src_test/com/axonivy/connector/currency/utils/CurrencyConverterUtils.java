package com.axonivy.connector.currency.utils;

import com.axonivy.connector.currency.CurrencyMock;
import com.axonivy.connector.currency.constant.CurrencyConverterConstant;

import ch.ivyteam.ivy.environment.AppFixture;

public class CurrencyConverterUtils {
	public static void setUpConfigForContext(String contextName, AppFixture fixture) {
		if (contextName.equals(CurrencyConverterConstant.MOCK_SERVER_CONTEXT_DISPLAY_NAME)) {
			fixture.config("RestClients.'Currency Converter API (CurrencyConverter)'.Url", CurrencyMock.URI);
		}
	}
}
