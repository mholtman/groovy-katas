package com.mholtman.domain

import java.text.NumberFormat
import com.mholtman.exceptions.InvalidProductException

class VendingMachine {

    private static final String insertCoinsMessage = 'INSERT COINS'
    private Integer valueOfCoins = 0

    private def coinValuator = new CoinValuator()
    private def defaultFormat = NumberFormat.getCurrencyInstance()

    def products = [new Product(name: 'chips', price: 50),
                    new Product(name: 'cola', price: 100),
                    new Product(name: 'candy', price: 65)]

    def coinReturn = new ArrayList<Coin>()
    def dispenser = new ArrayList<Product>()

    def String getDisplay() {
        if (valueOfCoins == 0)
            return insertCoinsMessage

        defaultFormat.format(valueOfCoins/100)
    }

    def insertCoin(Coin coin) {
        coinValuator.isValidCoin(coin) ? valueOfCoins += coinValuator.valueOf(coin) : coinReturn.push(coin)
    }

    def dispense(String product) {
        def chosenProduct  = products.find { it.name == product }

        if (!chosenProduct) throw new InvalidProductException()

        if (chosenProduct.price <= valueOfCoins)
            dispenser.add(chosenProduct)
    }

    def pressReturnCoins() {
        coinValuator.provideCoinsForAmount(valueOfCoins).each {coinReturn.push(it)}
    }
}
