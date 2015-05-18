package com.mholtman.domain

import spock.lang.Specification

class CoinValuatorSpec extends Specification {

    final static Coin QUARTER = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75)

    CoinValuator valuator;

    def setup() {
        valuator = new CoinValuator()
    }

    def "can validate quarter"() {
        expect:
        valuator.isValidCoin(QUARTER) == true
    }

    def "returns value of valid coin"() {
        expect:
        valuator.valueOf(QUARTER) == 0.25
    }
}