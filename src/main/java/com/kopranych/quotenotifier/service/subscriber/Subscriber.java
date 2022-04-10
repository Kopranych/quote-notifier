package com.kopranych.quotenotifier.service.subscriber;

public interface Subscriber <S, T, R> {

  String getAddress();
  R getType();



  boolean update(S eventType, T data);
}
