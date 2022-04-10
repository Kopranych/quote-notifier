package com.kopranych.quotenotifier.service.publisher.impl;

import com.kopranych.quotenotifier.model.QuoteEventType;
import com.kopranych.quotenotifier.model.dto.QuoteDto;
import com.kopranych.quotenotifier.service.publisher.Publisher;
import com.kopranych.quotenotifier.service.subscriber.Subscriber;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ChangeQuote implements Publisher <QuoteEventType, Subscriber> {

  private Map<QuoteEventType, List<Subscriber>> subscribers;

  private String ticker;
  private BigDecimal price;

  public void checkQuotePrice(final QuoteDto quoteDto) {
    var quoteEventType = price.compareTo(quoteDto.getLast()) > 0 ?
        QuoteEventType.DOWNWARD : QuoteEventType.UPWARD;

    subscribers.entrySet()
        .stream()
        .filter(subscriber -> subscriber.getKey() == quoteEventType)
        .filter(subscriber -> subscriber.getKey() == quoteEventType)
        .forEach(subscriber -> subscriber.getValue().forEach(sub -> sub.update(quoteDto)));
  }

  @Override
  public boolean subscribe(final QuoteEventType eventType, final Subscriber subscriber) {
    return false;
  }

  @Override
  public boolean unsubscribe(final QuoteEventType eventType, final Subscriber subscriber) {
    return false;
  }

  @Override
  public void notifySubscribers() {

  }
}
