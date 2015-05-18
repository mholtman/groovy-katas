package com.mholtman.domain

class CoinValuator {

    private static final Coin quarter = new Coin(weightGrams: 5.670, diameterMm: 24.26, thicknessMm: 1.75)

    private List<Coin> validCoins = [quarter]

    def Boolean isValidCoin(Coin coin) {
        validCoins.contains(coin)
    }

    def double valueOf(Coin coin) {
        return 0.25
    }
}
