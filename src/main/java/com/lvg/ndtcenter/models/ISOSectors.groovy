package com.lvg.ndtcenter.models


enum ISOSectors {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8)

    ISOSectors(Integer val){
        number = val
    }

    private final Integer number

    Integer number(){number}
}
