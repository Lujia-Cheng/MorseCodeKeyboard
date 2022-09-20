package com.ayoitsluke.morsecodeime;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;


/**
 * Converter between telegraphic and letter
 * TODO output as byteSet
 */
public class MorseCodeHelper {
    private ImmutableBiMap<Character, String> map;

    public MorseCodeHelper() {
        buildChart();
    }

    public void buildChart() {
        ImmutableBiMap.Builder<Character, String> mb = ImmutableBiMap.builder();
        // Letters
        mb.put('a', ".-");
        mb.put('b', "-...");
        mb.put('c', "-.-.");
        mb.put('d', "-..");
        mb.put('e', ".");
        mb.put('f', "..-.");
        mb.put('g', "--.");
        mb.put('h', "....");
        mb.put('i', "..");
        mb.put('j', ".---");
        mb.put('k', "-.-");
        mb.put('l', ".-..");
        mb.put('m', "--");
        mb.put('n', "-.");
        mb.put('o', "---");
        mb.put('p', ".--.");
        mb.put('q', "--.-");
        mb.put('r', ".-.");
        mb.put('s', "...");
        mb.put('t', "-");
        mb.put('u', "..-");
        mb.put('v', "...-");
        mb.put('w', ".--");
        mb.put('x', "-..-");
        mb.put('y', "-.--");
        mb.put('z', "--..");
        // Numbers
        mb.put('0', "-----");
        mb.put('1', ".----");
        mb.put('2', "..---");
        mb.put('3', "...--");
        mb.put('4', "....-");
        mb.put('5', ".....");
        mb.put('6', "-....");
        mb.put('7', "--...");
        mb.put('8', "---..");
        mb.put('9', "----.");
        // Punctuation
        mb.put('.', ".-.-.-");
        mb.put(',', "--..--");
        mb.put('?', "..--..");
        mb.put('\'', ".----.");
        mb.put('!', "-.-.--");
        mb.put('/', "-..-.");
        mb.put('(', "-.--.");
        mb.put(')', "-.--.-");
        mb.put('&', ".-...");
        mb.put(':', "---...");
        mb.put(';', "-.-.-.");
        mb.put('=', "-...-");
        mb.put('+', ".-.-.");
        mb.put('-', "-....-");
        mb.put('_', "..--.-");
        mb.put('"', ".-..-.");
        mb.put('$', "...-..-");
        mb.put('@', ".--.-.");
        //  Prosigns TODO
        //  Non-Latin extensions TODO
        map = mb.build();
    }
}
