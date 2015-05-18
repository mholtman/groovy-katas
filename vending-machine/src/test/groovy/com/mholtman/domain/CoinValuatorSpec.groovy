package com.mholtman.domain

import spock.lang.Specification

class CoinValuatorSpec extends Specification {

    final static Coin QUARTER = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75)

    def "can validate quarter"() {
        setup:
        def valuator = new CoinValuator()

        expect:
        valuator.isValidCoin(QUARTER) == true
    }
}