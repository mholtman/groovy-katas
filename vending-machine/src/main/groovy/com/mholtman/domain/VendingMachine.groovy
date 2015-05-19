package com.mholtman.domain

import java.text.NumberFormat

class VendingMachine {

    private static final String insertCoinsMessage = 'INSERT COINS'
    private double valueOfCoins

    private def coinValuator = new CoinValuator()
    private def defaultFormat = NumberFormat.getCurrencyInstance()

    def products = ["", "", ""]
    def coinReturn = new ArrayList<Coin>()

    def String getDisplay() {
        if (valueOfCoins == 0)
            return insertCoinsMessage

        defaultFormat.format(valueOfCoins)
    }

    def insertCoin(Coin coin) {
        coinValuator.isValidCoin(coin) ? valueOfCoins += coinValuator.valueOf(coin) : coinReturn.push(coin)
    }

}
