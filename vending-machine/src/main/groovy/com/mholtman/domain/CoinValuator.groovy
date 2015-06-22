package com.mholtman.domain

import com.mholtman.exceptions.InvalidCoinException

class CoinValuator {

    private static final Coin quarter = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75, label: "Quarter")
    private static final Coin dime = new Coin(weightGrams:  2.268, diameterMm:  17.91,thicknessMm:  1.35, label: "Dime")
    private static final Coin nickel = new Coin(weightGrams: 5.000, diameterMm: 21.21, thicknessMm: 1.95, label: "Nickel")

    def coinValues = [(quarter):25,
                      (dime):10,
                      (nickel):5].sort({-it.value})

    def isValidCoin(Coin coin) {
        coinValues.containsKey(coin)
    }

    def double valueOf(Coin coin) throws InvalidCoinException {
        if (!isValidCoin(coin)) throw new InvalidCoinException()

        coinValues[coin]
    }

    def ArrayList<Coin> provideCoinsForAmount(Integer amountInCents) {
        def listOfCoins = new ArrayList<Coin>()

        Integer leftOver = amountInCents

        for (c in coinValues) {
            Integer numberOfCoins
            Integer remainder = leftOver.mod(c.value)
            if (remainder != 0) {
                numberOfCoins = ((leftOver - remainder) / c.value)
            } else {
                numberOfCoins = leftOver / c.value
            }

            numberOfCoins.times({listOfCoins.add(c.key.clone())})
            numberOfCoins.times({leftOver -= c.value})
        }
        
        return listOfCoins
    }

    def Coin getQuarter() {
        quarter.clone()
    }

    def Coin getDime() {
        dime.clone()
    }

    def Coin getNickel() {
        nickel.clone()
    }
}
