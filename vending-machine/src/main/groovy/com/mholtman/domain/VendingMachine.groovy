package com.mholtman.domain

import java.text.NumberFormat

class VendingMachine {

    static final String insertCoinsMessage = 'INSERT COINS'
    static final Coin quarter = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75)
    static final Coin dime = new Coin(weightGrams:  2.268, diameterMm:  17.91,thicknessMm:  1.35)
    static final Coin nickel = new Coin(weightGrams: 5.000, diameterMm: 21.21, thicknessMm: 1.95)

    NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();

    private double valueOfCoins;

    def String getDisplay() {
        if (valueOfCoins == 0)
            return insertCoinsMessage
        return defaultFormat.format(valueOfCoins)
    }

    def insertCoin(Coin coin) {
        if (coin.equals(quarter))
            valueOfCoins += 0.25
        if (coin.equals(dime))
            valueOfCoins += 0.10
        if (coin.equals(nickel))
            valueOfCoins += 0.05
    }
}
