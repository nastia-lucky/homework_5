package com.otus.homeWorkStub.citrusTests;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.ws.actions.SoapActionBuilder;
import com.contexts.SoapContext;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

public class SOAPTests extends TestNGCitrusTestDesigner {

  private TestContext context;

  @Test
  @CitrusTest
  public void testSoapService() {
    context = citrus.getCitrusContext().createTestContext();

    soap().client("soapClient")
        .send()
        .payload(
            "<NumberToDollars xmlns=\"http://www.dataaccess.com/webservicesserver/\">\n" +
                "      <dNum>15</dNum>\n" +
                "    </NumberToDollars>");

    soap().client("soapClientHelper")
        .receive()
        .payload(" <NumberToDollarsResponse xmlns=\"http://www.dataaccess.com/webservicesserver/\">\n" +
            "      <NumberToDollarsResult>fifteen dollars</NumberToDollarsResult>\n" +
            "    </NumberToDollarsResponse>\n");

  }

}
