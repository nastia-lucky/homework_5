package com.contexts;

import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.soap.SoapMessageFactory;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

@Configuration
public class SoapContext {

  @Bean("messageFactory")
  public SoapMessageFactory messageFactory() {
    try {
      SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());
    } catch (SOAPException e) {
      e.printStackTrace();
    }
    return messageFactory();
  }
}
