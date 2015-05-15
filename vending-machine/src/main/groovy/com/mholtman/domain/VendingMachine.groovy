package com.mholtman.domain


class VendingMachine {

    static final String insertCoinsMessage = 'INSERT COINS'

    private String displayMessage = insertCoinsMessage

    def String getDisplay() {
        displayMessage
    }

    def insertCoin(Coin coin) {
        displayMessage = '$0.25'
    }
}
