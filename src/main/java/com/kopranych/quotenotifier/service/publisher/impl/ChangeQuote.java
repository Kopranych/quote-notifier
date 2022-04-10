package com.kopranych.quotenotifier.service.publisher.impl;

import com.kopranych.quotenotifier.model.QuoteEventType;
import com.kopranych.quotenotifier.model.dto.QuoteDto;
import com.kopranych.quotenotifier.service.publisher.Publisher;
import com.kopranych.quotenotifier.service.publisher.QuotePublisher;
import com.kopranych.quotenotifier.service.subscriber.Subscriber;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeQuote implements QuotePublisher {

  private Map<QuoteEventType, List<Subscriber>> subscribers;

  private QuoteDto quote;

  public List<Subscriber> checkQuotePrice(final QuoteDto quoteDto) {
    var quoteEventType = quote.getLast().compareTo(quoteDto.getLast()) > 0 ?
        QuoteEventType.DOWNWARD : QuoteEventType.UPWARD;

    return subscribers.entrySet()
        .stream()
        .filter(subscriber -> subscriber.getKey() == quoteEventType)
        .filter(subscriber -> subscriber.getKey() == quoteEventType)

//        .forEach(subscriber -> subscriber.getValue().forEach(sub -> sub.update(quoteDto)));
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
