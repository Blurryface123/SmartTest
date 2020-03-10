package com.validator.validatorExample;

/**
 * Implementations are capable of verifying whether a specific message is valid.
 */
public interface Validator {

    /**
     * Indicate if the given message is valid.
     *
     * @param message The message to check
     * @return {@code true} if the message starts with STX, ends with ETX and the
     *         correct LRC, and has correctly-escaped data; {@code false}
     *         otherwise.
     */
    public boolean isValid(byte[] message);

}
