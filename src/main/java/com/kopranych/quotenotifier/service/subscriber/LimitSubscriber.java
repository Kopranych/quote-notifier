package com.kopranych.quotenotifier.service.subscriber;

import java.math.BigDecimal;

public interface LimitSubscriber extends Subscriber {

  BigDecimal getLimit();
}
