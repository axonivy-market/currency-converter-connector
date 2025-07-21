package com.axonivy.connector.currency.utils;

import com.axonivy.connector.currency.CurrencyMock;
import com.axonivy.connector.currency.constant.CurrencyConverterTestConstant;

import ch.ivyteam.ivy.environment.AppFixture;

public class CurrencyConverterTestUtils {
	public static void setUpConfigForContext(String contextName, AppFixture fixture) {
		if (contextName.equals(CurrencyConverterTestConstant.MOCK_SERVER_CONTEXT_DISPLAY_NAME)) {
			fixture.config("RestClients.'Currency Converter API (CurrencyConverter)'.Url", CurrencyMock.URI);
		}
	}
}
