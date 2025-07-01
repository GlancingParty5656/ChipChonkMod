package net.colby.chipchonkmod.block.custom;

import net.minecraft.util.StringIdentifiable;

public enum PortalBlockColor implements StringIdentifiable {
    BLUE("blue"), ORANGE("orange");

    private final String name;

    PortalBlockColor(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
