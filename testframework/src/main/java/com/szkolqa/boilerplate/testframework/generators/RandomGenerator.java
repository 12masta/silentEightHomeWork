package com.szkolqa.boilerplate.testframework.generators;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {
    public static String getRandomString(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
