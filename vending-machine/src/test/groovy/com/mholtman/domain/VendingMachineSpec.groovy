package com.mholtman.domain

import spock.lang.Specification

class VendingMachineSpec extends Specification {

    def "new vending machine displays INSERT COINS message"() {
        when:
        def machine = new VendingMachine()

        then:
        machine.display == 'INSERT COINS'
    }
}