package com.axonivy.connector.currency.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.axonivy.connector.currency.CurrencyMock;

import app.frankfurter.api.client.CurCodes;
import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;
import ch.ivyteam.ivy.environment.AppFixture;

@IvyProcessTest
public class CurrencyConverterTest {

  private static final BpmProcess testee = BpmProcess.path("CurrencyConverter");

  @BeforeEach
  void beforeEach(AppFixture fixture) {
    fixture.config("RestClients.'Currency Converter API (CurrencyConverter)'.Url", CurrencyMock.URI);
  }

  @Test
  void chfToEur(BpmClient bpmClient) throws NoSuchFieldException {
    BpmElement startable = testee.elementName("convert(Number,CurCodes,CurCodes)");
    ExecutionResult result = bpmClient.start()
      .subProcess(startable)
      .execute(25.0, CurCodes.CHF, CurCodes.EUR);
    assertThat(result.data().last().get("ToAmount")).isEqualTo(24.0);
  }
}
