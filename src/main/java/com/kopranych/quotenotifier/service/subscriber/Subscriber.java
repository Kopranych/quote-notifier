package com.kopranych.quotenotifier.service.subscriber;

public interface Subscriber <S, T> {

  boolean update(S eventType, T data);
}
