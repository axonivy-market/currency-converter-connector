package com.axonivy.connector.currency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import app.frankfurter.api.client.CurCodes;
import io.swagger.v3.oas.annotations.Hidden;

@Path("currencyMock")
@PermitAll
@Hidden
public class CurrencyMock {

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
