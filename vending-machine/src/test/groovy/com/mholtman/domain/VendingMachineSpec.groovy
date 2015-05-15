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
        def quarter = new Coin(5.670, 24.26, 1.75)
        def machine = new VendingMachine()

        when:
        machine.insertCoin(quarter)

        then:
        machine.display == '$0.25'
    }
}