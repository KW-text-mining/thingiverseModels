package com.kwuniv.thingiverseModels;

public enum SmallCategory {
    Tdprinteraccessories("3d-printer-accessories"),
    Tdprinterextruders("3d-printer-extruders"),
    Tdprinterparts("3d-printer-parts"),
    Tdprinters("3d-printers"),
    Tdprintingtests("3d-printing-tests"),
    cnb("coins-and-badges"),
    ia("interactive-art"),
    ma("math-art"),
    snr("scans-and-replicas"),
    sculptures("sculptures"),
    snl("signs-and-logos"),

    accessories("accessories"),
    bracelets("bracelets"),
    costume("costume"),
    earrings("earrings"),
    glasses("glasses"),
    jewelry("jewelry"),
    keychains("keychains"),
    rings("rings"),

    audio("audio"),
    camera("camera"),
    computer("computer"),
    mp("mobile-phone"),
    tablet("tablet"),
    vg("video-games"),

    automotive("automotive"),
    diy("diy"),
    electronics("electronics"),
    music("music"),
    rcV("rc-vehicles"),
    robotics("robotics"),
    sno("sport-and-outdoors"),

    bathroom("bathroom"),
    containers("containers"),
    decor("decor"),
    household("household"),
    supplies("supplies"),
    knd("kitchen-and-dining"),
    oo("office-organization"),
    ong("outdoors-and-garden"),
    pets("pets"),

    biology("biology"),
    engineering("engineering"),
    math("math"),
    pna("physics-and-astronomy"),

    animals("animals"),
    bns("building-and-structures"),
    creatures("creatures"),
    fnd("food-and-drinks"),
    mf("model-furniture"),
    mr("model-robots"),
    people("people"),
    props("props"),
    vehicles("vehicles"),

    ht("hand-tools"),
    mt("machine-tools"),
    thab("tool-holders-and-boxes"),

    chess("chess"),
    ct("construction-toys"),
    dice("dice"),
    games("games"),
    mtoys("mechanical-toys"),
    playsets("playsets"),
    puzzles("puzzles"),
    tnga("toy-and-game-accessories");


    private final String name;

    private SmallCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
