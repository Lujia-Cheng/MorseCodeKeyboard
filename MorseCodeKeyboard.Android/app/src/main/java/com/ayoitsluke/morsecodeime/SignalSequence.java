package com.ayoitsluke.morsecodeime;

import androidx.annotation.NonNull;

public enum Signal {
    DIT, DAH, SYMBOL_SPACE, LETTER_SPACE, WORD_SPACE
}

/**
 *
 */
public class SignalSequence implements CharSequence {
    private int size;

    public void append() {
    }

    public Signal remove(int i) {
    }

    public Signal remove(Signal s) {
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }

    @NonNull
    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }
}
