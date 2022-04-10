package com.kopranych.quotenotifier.service.subscriber.impl;

import com.kopranych.quotenotifier.service.subscriber.LimitSubscriber;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuoteLimitSubscriber implements LimitSubscriber<String, String> {

  private String address;
  private BigDecimal limit;

  @Override
  public boolean update(final String eventType, final String data) {
    System.out.println("Send notify " + eventType + " to " + email);
    return true;
  }

  @Override
  public Object getType() {
    return null;
  }

  @Override
  public boolean update(final Object eventType, final Object data) {
    return false;
  }
}
