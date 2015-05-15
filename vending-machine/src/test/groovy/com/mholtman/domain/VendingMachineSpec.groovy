package com.mholtman.domain

import spock.lang.Specification

class VendingMachineSpec extends Specification {

    VendingMachine machine;
    final static Coin QUARTER = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75)
    final static Coin DIME = new Coin(weightGrams:  2.268, diameterMm:  17.91, thicknessMm:  1.35)
    final static Coin NICKEL = new Coin(weightGrams: 5.000, diameterMm: 21.21, thicknessMm: 1.95)

    def setup() {
        machine = new VendingMachine()
    }

    def "new vending machine displays INSERT COINS message"() {
        expect:
        machine.display == 'INSERT COINS'
    }

    def "machine accepts quarters"() {
        when:
        machine.insertCoin(QUARTER)

        then:
        machine.display == '$0.25'
    }

    def "machine accepts dimes"() {
        when:
        machine.insertCoin(DIME)

        then:
        machine.display == '$0.10'
    }

    def "machine accepts nickels"() {
        when:
        machine.insertCoin(NICKEL)

        then:
        machine.display == '$0.05'
    }

    def "machine accepts multiple coins"() {
        when:
        machine.insertCoin(QUARTER)
        machine.insertCoin(DIME)

        then:
        machine.display == '$0.35'
    }
}