package com.mholtman.domain

import spock.lang.Specification

class VendingMachineSpec extends Specification {

    def "new vending machine displays INSERT COINS message"() {
        when:
        def machine = new VendingMachine()

        then:
        machine.display == 'INSERT COINS'
    }

    def "machine accepts quarters"() {
        setup:
        def quarter = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75)
        def machine = new VendingMachine()

        when:
        machine.insertCoin(quarter)

        then:
        machine.display == '$0.25'
    }

    def "machine accepts dimes"() {
        setup:
        def dime = new Coin(weightGrams:  2.268, diameterMm:  17.91, thicknessMm:  1.35)
        def machine = new VendingMachine()

        when:
        machine.insertCoin(dime)

        then:
        machine.display == '$0.10'
    }
}