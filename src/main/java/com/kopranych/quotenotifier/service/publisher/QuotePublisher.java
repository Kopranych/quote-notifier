package com.kopranych.quotenotifier.service.publisher;

import com.kopranych.quotenotifier.model.QuoteEventType;
import com.kopranych.quotenotifier.model.dto.QuoteDto;
import com.kopranych.quotenotifier.service.subscriber.Subscriber;
import java.util.List;

public interface QuotePublisher extends Publisher<QuoteEventType, Subscriber>{

  QuoteDto getQuote();
  List<Subscriber> checkQuotePrice(final QuoteDto quoteDto);

}
