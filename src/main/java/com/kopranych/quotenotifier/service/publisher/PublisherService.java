package com.kopranych.quotenotifier.service.publisher;

import static java.util.stream.Collectors.toSet;

import com.kopranych.quotenotifier.model.dto.QuoteDto;
import com.kopranych.quotenotifier.service.subscriber.Subscriber;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PublisherService {


  public void processAll() {
    List<QuotePublisher> publishers = getAllPublishers();
    final var tickers = publishers.stream()
        .map(QuotePublisher::getQuote)
        .map(QuoteDto::getTicker)
        .collect(toSet());

    Map<String, QuoteDto> quotes = getQuotes(tickers);

    publishers.stream()
        .map(publisher -> {
          final var quote = quotes.get(publisher.getQuote().getTicker());
          final var subscribers = publisher.checkQuotePrice(quote);

        })
  }

}
