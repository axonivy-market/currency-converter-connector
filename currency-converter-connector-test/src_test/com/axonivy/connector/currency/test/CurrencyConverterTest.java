package com.axonivy.connector.currency.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static com.axonivy.utils.e2etest.enums.E2EEnvironment.REAL_SERVER;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import com.axonivy.connector.currency.CurrencyMock;
import com.axonivy.utils.e2etest.context.MultiEnvironmentContextProvider;
import com.axonivy.utils.e2etest.utils.E2ETestUtils;
import app.frankfurter.api.client.CurCodes;
import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;
import ch.ivyteam.ivy.environment.AppFixture;

@IvyProcessTest(enableWebServer = true)
@ExtendWith(MultiEnvironmentContextProvider.class)
public class CurrencyConverterTest {

  private static final BpmProcess testee = BpmProcess.path("CurrencyConverter");

  @BeforeEach
  void beforeEach(ExtensionContext context, AppFixture fixture) {
    E2ETestUtils.determineConfigForContext(context.getDisplayName(), runRealEnv(fixture), runMockEnv(fixture));
  }

  private Runnable runRealEnv(AppFixture fixture) {
    return () -> {
    };
  }

  private Runnable runMockEnv(AppFixture fixture) {
    return () -> {
      fixture.config("RestClients.'Currency Converter API (CurrencyConverter)'.Url", CurrencyMock.URI);
    };
  }

  @TestTemplate
  void chfToEur(ExtensionContext context, BpmClient bpmClient) throws NoSuchFieldException {
    boolean isRealContext = context.getDisplayName().equals(REAL_SERVER.getDisplayName());
    BpmElement startable = testee.elementName("convert(Number,CurCodes,CurCodes)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute(25.0, CurCodes.CHF, CurCodes.EUR);
    if (isRealContext) {
      assertNotNull(result.data().last().get("ToAmount"));
    } else {
      assertThat(result.data().last().get("ToAmount")).isEqualTo(24.0);
    }
  }
}
