package com.axonivy.connector.currency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import app.frankfurter.api.client.CurCodes;
import io.swagger.v3.oas.annotations.Hidden;

@Path(CurrencyMock.PATH_SUFFIX)
@PermitAll
@Hidden
public class CurrencyMock {

  static final String PATH_SUFFIX = "currencyMock";
  // URI where this mock can be reached: to be referenced in tests that use it!
  public static final String URI = "{ivy.app.baseurl}/api/" + PATH_SUFFIX;

  @GET
  @Path("latest")
  @Produces(MediaType.APPLICATION_JSON)
  public Response latest(@QueryParam("amount") Double amount,
          @QueryParam("from") CurCodes from,
          @QueryParam("to") CurCodes to) {

    return Response.status(200)
            .entity(load(amount, from, to))
            .build();
  }

  private static String load(Double amount, CurCodes from, CurCodes to) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    var today = LocalDate.now().format(formatter);
    return "{\n"
            + "    \"amount\": " + amount + ",\n"
            + "    \"base\": \"" + from + "\",\n"
            + "    \"date\": \"" + today + "\",\n"
            + "    \"rates\": {\n"
            + "        \"" + to + "\": " + (amount - 1) + "\n"
            + "    }\n"
            + "}";
  }
}
