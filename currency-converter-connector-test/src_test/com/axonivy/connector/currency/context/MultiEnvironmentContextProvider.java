package com.axonivy.connector.currency.context;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import com.axonivy.connector.currency.constant.CurrencyConverterTestConstant;

public class MultiEnvironmentContextProvider implements TestTemplateInvocationContextProvider {

	@Override
	public boolean supportsTestTemplate(ExtensionContext context) {
		return true;
	}

	@Override
	public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
		return Stream.of(new TestEnironmentInvocationContext(CurrencyConverterTestConstant.REAL_CALL_CONTEXT_DISPLAY_NAME),
				new TestEnironmentInvocationContext(CurrencyConverterTestConstant.MOCK_SERVER_CONTEXT_DISPLAY_NAME));
	}

}
