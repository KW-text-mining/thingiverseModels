package com.kwuniv.thingiverseModels;

public enum BigCategory {
    TDPrinting("3D Printing"),
    Art("Art"),
    Fashion("Fashion"),
    Gadgets("Gadgets"),
    Hobby("Hobby"),
    Household("Household"),
    Learning("Learning"),
    Models("Models"),
    Tools("Tools"),
    ToysNGames("Toys & Games");


    private final String name;

    private BigCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
