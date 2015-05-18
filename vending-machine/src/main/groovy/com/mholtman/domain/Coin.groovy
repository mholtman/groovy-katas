package com.mholtman.domain

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Coin {
    double weightGrams,diameterMm,thicknessMm
    String label = "Default Coin"
}
