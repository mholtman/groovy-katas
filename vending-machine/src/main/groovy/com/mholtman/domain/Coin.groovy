package com.mholtman.domain

import groovy.transform.EqualsAndHashCode
import java.lang.Cloneable

@EqualsAndHashCode
class Coin implements Cloneable {
    double weightGrams,diameterMm,thicknessMm
    String label = "Default Coin"
}
