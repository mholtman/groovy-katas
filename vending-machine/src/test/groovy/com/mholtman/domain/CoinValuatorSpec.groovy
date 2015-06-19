package com.mholtman.domain

import com.mholtman.exceptions.InvalidCoinException
import spock.lang.Specification
import spock.lang.Unroll


class CoinValuatorSpec extends Specification {

    final static Coin QUARTER = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75, label: "Quarter")
    final static Coin DIME = new Coin(weightGrams:  2.268, diameterMm:  17.91, thicknessMm:  1.35, label: "Dime")
    final static Coin NICKEL = new Coin(weightGrams: 5.000, diameterMm: 21.21, thicknessMm: 1.95, label: "Nickel")
    final static Coin PENNY = new Coin(weightGrams: 2.500, diameterMm: 19.05, thicknessMm: 1.52, label: "Penny")

    CoinValuator valuator;

    def setup() {
        valuator = new CoinValuator()
    }

    @Unroll
    def "can validate #coin.label"() {
        expect:
        valuator.isValidCoin(coin) == validity

        where:
        coin    | validity
        QUARTER | true
        DIME    | true
        NICKEL  | true
        PENNY   | false
    }

    @Unroll
    def "returns value of #coin.label"() {
        expect:
        valuator.valueOf(coin) == value

        where:
        coin    | value
        QUARTER | 0.25
        DIME    | 0.10
        NICKEL  | 0.05
    }

    def "trying to value an invalid coin throws a InvalidCoin exception"() {
        when:
        valuator.valueOf(PENNY)

        then:
        thrown(InvalidCoinException)
    }

    def "creates quarters"() {
        expect:
        valuator.getQuarter() == QUARTER
    }

    def "creates dimes"() {
        expect:
        valuator.getDime() == DIME
    }

    def "creates nickels"() {
        expect:
        valuator.getNickel() == NICKEL
    }

    @Unroll
    def "provides coins for #amount"() {
        expect:
        valuator.provideCoinsForAmount(amount) == coinArray

        where:
        amount  | coinArray
        0.25    | new ArrayList<Coin>([QUARTER.clone()])
    }
}