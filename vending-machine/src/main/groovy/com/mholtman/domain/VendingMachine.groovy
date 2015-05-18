package com.mholtman.domain

import java.text.NumberFormat

class VendingMachine {

    private static final String insertCoinsMessage = 'INSERT COINS'

    def coinReturn = new ArrayList<Coin>()

    def coinValuator = new CoinValuator()

    private def defaultFormat = NumberFormat.getCurrencyInstance()

    private double valueOfCoins

    def String getDisplay() {
        if (valueOfCoins == 0)
            return insertCoinsMessage

        defaultFormat.format(valueOfCoins)
    }

    def insertCoin(Coin coin) {
        if (coinValuator.isValidCoin(coin))
            valueOfCoins += coinValuator.valueOf(coin)
        else
            coinReturn.push(coin)
    }

}
