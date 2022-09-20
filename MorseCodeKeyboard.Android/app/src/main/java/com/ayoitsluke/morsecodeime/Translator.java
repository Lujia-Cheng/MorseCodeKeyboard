package com.ayoitsluke.morsecodeime;

/**
 * Convert between strings and morse code.
 */
public class Translator {
    private MorseCodeHelper mc;
    private final int FARNSWORTH_TIMING_CUTOFF = 18; // See http://www.arrl.org/files/file/Technology/x9004008.pdf
    /**
     * speed of transmission, in words per minute
     */
    private int wpm;
    /**
     * Period of one unit, in seconds
     */
    private double unit;
    private double farnsworthUnit;
    private double dit = unit;
    private double dah = 3 * unit;
    private double intraChar = unit;
    private double interChar = 3 * farnsworthUnit; // Eg. space between P_A_R_I_S
    private double space = 7 * farnsworthUnit; // Eg. space between HELLO_WORLD


    /**
     *
     */
    Translator() {
        this(5);
    }

    Translator(int c) {
        this.wpm = c;
        unit = wpm < FARNSWORTH_TIMING_CUTOFF ? 1.2 / 18 : 1.2 / wpm;
        intraChar = 3 * unit;
        interChar = unit;
    }

    /**
     * Translate a string to morse code
     *
     * @param string input string to be translate to morse code
     */
    public Signal[] stringToSignal(String string) {
        Queue<Signal> out = new Queue<>();
        char[] chars = string.toCharArray();
        for (Character c : chars) {
            out.enqueue(MorseCodeHelper.signalLookUp(c)); // TODO

        }

        return null;
    }

    /**
     * Translate signals to strings
     *
     * @param signal
     * @return
     */
    public String toString(MorseCodeHelper[] signal) {
        return "";
    }

}