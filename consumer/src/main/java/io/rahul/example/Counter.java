package io.rahul.example;

import java.io.Serializable;

public class Counter implements Serializable {
    private static final long serialVersionUID = -4102850449146212144L;
    
	private int value;

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Counter [value=" + value + "]";
	}
}
