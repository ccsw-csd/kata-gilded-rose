package com.ccsw.codingdojo.gildedrose;

/**
 * NO TOCAR ESTA CLASE, EL GOBLIN NO PERMITE SU MODIFICACIÓN
 * @author ccsw
 *
 */
public final class Item {

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {

        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    /**
     * @return name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name new value of {@link #getname}.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return sellIn
     */
    public int getSellIn() {

        return this.sellIn;
    }

    /**
     * @param sellIn new value of {@link #getsellIn}.
     */
    public void setSellIn(int sellIn) {

        this.sellIn = sellIn;
    }

    /**
     * @return quality
     */
    public int getQuality() {

        return this.quality;
    }

    /**
     * @param quality new value of {@link #getquality}.
     */
    public void setQuality(int quality) {

        this.quality = quality;
    }

}
