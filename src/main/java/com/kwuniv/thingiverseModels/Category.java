package com.kwuniv.thingiverseModels;

public class Category {

    private static Category category = new Category();

    private Category() {

    }
    public static Category getInstance() {
        return category;
    }

    public String getBigCategory(String slug) {
        if (slug.equals("3d-printer-accessories")||
                slug.equals("3d-printer-extruders")||
                slug.equals("3d-printer-parts")||
                slug.equals("3d-printers")||
                slug.equals("3d-printing-tests")) {
            return "3D Printing";
        } else if (slug.equals("2d-art")||
                slug.equals("coins-and-badges")||
                slug.equals("interactive-art")||
                slug.equals("math-art")||
                slug.equals("scans-and-replicas")||
                slug.equals("sculptures")||
                slug.equals("signs-and-logos")) {
            return "Art";
        }
        else if (slug.equals("accessories")||
                slug.equals("bracelets")||
                slug.equals("costume")||
                slug.equals("earrings")||
                slug.equals("glasses")||
                slug.equals("jewelry")||
                slug.equals("keychains")||
                slug.equals("rings")) {
            return "Fashion";
        }
        else if (slug.equals("audio")||
                slug.equals("camera")||
                slug.equals("computer")||
                slug.equals("mobile-phone")||
                slug.equals("tablet")||
                slug.equals("video-games")) {
            return "Gadgets";
        }
        else if (slug.equals("automotive")||
                slug.equals("diy")||
                slug.equals("electronics")||
                slug.equals("music")||
                slug.equals("rc-vehicles")||
                slug.equals("robotics")||
                slug.equals("sport-and-outdoors")){
            return "Hobby";
        }
        else if (slug.equals("bathroom")||
                slug.equals("containers")||
                slug.equals("decor")||
                slug.equals("household")||
                slug.equals("supplies")||
                slug.equals("kitchen-and-dining")||
                slug.equals("office-organization")||
                slug.equals("outdoors-and-garden")||
                slug.equals("pets")){
            return "Household";
        }
        else if (slug.equals("biology")||
                slug.equals("engineering")||
                slug.equals("math")||
                slug.equals("physics-and-astronomy")){
            return "Learning";
        }
        else if (slug.equals("animals")||
                slug.equals("building-and-structures")||
                slug.equals("creatures")||
                slug.equals("food-and-drinks")||
                slug.equals("model-furniture")||
                slug.equals("model-robots")||
                slug.equals("people")||
                slug.equals("props")||
                slug.equals("vehicles")){
            return "Models";
        }
        else if (slug.equals("hand-tools")||
                slug.equals("machine-tools")||
                slug.equals("tool-holders-and-boxes")){
            return "Tools";
        }
        else if (slug.equals("chess")||
                slug.equals("construction-toys")||
                slug.equals("dice")||
                slug.equals("games")||
                slug.equals("mechanical-toys")||
                slug.equals("playsets")||
                slug.equals("puzzles")||
                slug.equals("toy-and-game-accessories")){
            return "Toys & Games";
        }
        return "None";
    }

    public  void iter() {
        for (SmallCategory value : SmallCategory.values()) {
            System.out.println(value.getName());

        }
    }
}
