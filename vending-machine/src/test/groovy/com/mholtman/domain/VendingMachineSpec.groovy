package com.mholtman.domain

import spock.lang.Specification

class VendingMachineSpec extends Specification {

    VendingMachine machine;
    final static Coin QUARTER = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75, label: "Quarter")
    final static Coin DIME = new Coin(weightGrams:  2.268, diameterMm:  17.91, thicknessMm:  1.35, label: "Dime")
    final static Coin NICKEL = new Coin(weightGrams: 5.000, diameterMm: 21.21, thicknessMm: 1.95, label: "Nickel")
    final static Coin PENNY = new Coin(weightGrams: 2.500, diameterMm: 19.05, thicknessMm: 1.52, label: "Penny")

    def setup() {
        machine = new VendingMachine()
    }

    def "new machine displays INSERT COINS message"() {
        expect:
        machine.display == 'INSERT COINS'
    }

    def "accepts quarters"() {
        when:
        machine.insertCoin(QUARTER)

        then:
        machine.display == '$0.25'
    }

    def "accepts dimes"() {
        when:
        machine.insertCoin(DIME)

        then:
        machine.display == '$0.10'
    }

    def "accepts nickels"() {
        when:
        machine.insertCoin(NICKEL)

        then:
        machine.display == '$0.05'
    }

    def "accepts multiple coins"() {
        when:
        machine.insertCoin(QUARTER)
        machine.insertCoin(DIME)

        then:
        machine.display == '$0.35'
    }

    def "does not accept pennies"() {
        when:
        machine.insertCoin(PENNY)

        then:
        machine.display == 'INSERT COINS'
    }

    def "returns invalid coins via coin return"() {
        when:
        machine.insertCoin(PENNY)

        then:
        machine.coinReturn.contains(PENNY)
    }

    def "contains products"() {
        expect:
        machine.products.size == 3
    }
}