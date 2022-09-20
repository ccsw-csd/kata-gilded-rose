package com.ccsw.codingdojo.gildedrose;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("javadoc")
public abstract class AbstractGildedRoseTest {

    protected void testItemQuality(String itemName, int initialSellIn, int initialQuality, int deltaQuality) {

        Item item = new Item(itemName, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();

        assertEquals(initialQuality + deltaQuality, item.getQuality());
        assertEquals(initialSellIn - 1, item.getSellIn());
    }

    protected void testItemQualityAndSellin(String itemName, int initialSellIn, int initialQuality, int deltaSellin, int deltaQuality) {

        Item item = new Item(itemName, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();

        assertEquals(initialQuality + deltaQuality, item.getQuality());
        assertEquals(initialSellIn + deltaSellin, item.getSellIn());
    }

}
