package com.kopranych.quotenotifier.service;

import com.kopranych.quotenotifier.model.dto.QuoteDto;
import com.kopranych.quotenotifier.service.subscriber.LimitSubscriber;
import com.kopranych.quotenotifier.service.subscriber.Subscriber;

public class TelegramMessageDistributor {

  public void notify(LimitSubscriber subscriber, QuoteDto quote) {
    System.out.println(
        "Send message to " + subscriber.getAddress() + " for quote " + quote.getTicker()
            + " limit " + subscriber.getLimit() + " was " + subscriber.getType()
    );
  }

}
