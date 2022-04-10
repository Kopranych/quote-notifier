package com.kopranych.quotenotifier.service.subscriber.impl;

import com.kopranych.quotenotifier.service.subscriber.Subscriber;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailQuoteSubscriber implements Subscriber<String, String> {

  private final String email;

  @Override
  public boolean update(final String eventType, final String data) {
    System.out.println("Send notify " + eventType + " to " + email);
    return true;
  }
}
