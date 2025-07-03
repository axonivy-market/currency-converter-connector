package com.axonivy.connector.currency.context;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import com.axonivy.connector.currency.constant.CurrencyConverterConstant;

public class MultiEnvironmentContextProvider implements TestTemplateInvocationContextProvider {

	@Override
	public boolean supportsTestTemplate(ExtensionContext context) {
		return true;
	}

	@Override
	public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
		return Stream.of(new TestEnironmentInvocationContext(CurrencyConverterConstant.REAL_CALL_CONTEXT_DISPLAY_NAME),
				new TestEnironmentInvocationContext(CurrencyConverterConstant.MOCK_SERVER_CONTEXT_DISPLAY_NAME));
	}

}
