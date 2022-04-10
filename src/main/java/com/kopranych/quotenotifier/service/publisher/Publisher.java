package com.kopranych.quotenotifier.service.publisher;

public interface Publisher <T, S> {

  boolean subscribe(T eventType, S subscriber);

  boolean unsubscribe(T eventType, S subscriber);

  void notifySubscribers();

}
