package br.com.farmacia.exception;

public enum ErrorCode {
	
	NOT_FOUND_ERROR(4000);

	private final int value;

	private ErrorCode(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
