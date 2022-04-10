package com.kopranych.quotenotifier.service;

import com.kopranych.quotenotifier.model.dto.QuoteDto;
import java.util.List;

public interface QuoteScheduler {

  default void quoteSchedule() {
    List<QuoteDto> quotes = getQuotes(getTickers(), date);

  }

  List<String> getTickers();

}
