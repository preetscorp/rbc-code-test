package com.rbc.stock.exception;

public class TickerNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public TickerNotFoundException(String msg) {
		super(msg);
	}
}
