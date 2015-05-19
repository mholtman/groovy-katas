package com.mholtman.domain

import com.mholtman.exceptions.InvalidCoinException

class CoinValuator {

    private static final Coin quarter = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75, label: "Quarter")
    private static final Coin dime = new Coin(weightGrams:  2.268, diameterMm:  17.91,thicknessMm:  1.35, label: "Dime")
    private static final Coin nickel = new Coin(weightGrams: 5.000, diameterMm: 21.21, thicknessMm: 1.95, label: "Nickel")
    
    def coinValues = [(quarter):0.25,
                      (dime):0.10,
                      (nickel):0.05]

    def Boolean isValidCoin(Coin coin) {
        coinValues.containsKey(coin)
    }

    def double valueOf(Coin coin) throws InvalidCoinException {
        if (!isValidCoin(coin)) throw new InvalidCoinException()

        coinValues[coin]
    }
}
