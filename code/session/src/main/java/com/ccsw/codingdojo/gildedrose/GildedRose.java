package com.ccsw.codingdojo.gildedrose;

/**
 * @author ccsw
 *
 */
public class GildedRose {
    private static final int LIMIT_QUALITY = 50;
    private static final int THRESHOLD_TRIPLE = 6;
    private static final int THRESHOLD_DOUBLE = 11;
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < this.items.length; i++) {

            Item item = this.items[i];

            updateQuality(item);

            updateSellIn(item);

            applyExpiredRules(item);
        }
    }

    private void applyExpiredRules(Item item) {
        if (isExpired(item) == false)
            return;

        switch (item.getName()) {

        case AGED_BRIE:
            increaseQuality(item);
            break;

        case BACKSTAGE_PASSES:
            dropQuality(item);
            break;

        default:
            decreaseQuality(item);

        }

    }

    private void dropQuality(Item item) {
        item.setQuality(item.getQuality() - item.getQuality());
    }

    private void updateSellIn(Item item) {
        if (isNotName(item, SULFURAS)) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    private void updateQuality(Item item) {
        if (isName(item, AGED_BRIE) || isName(item, BACKSTAGE_PASSES)) {
            increaseQuality(item);
            applyBackstageRules(item);
            return;
        }
        decreaseQuality(item);

    }

    private boolean isExpired(Item item) {
        return item.getSellIn() < 0;
    }

    private void applyBackstageRules(Item item) {

        if (isNotName(item, BACKSTAGE_PASSES))
            return;

        if (item.getSellIn() < THRESHOLD_DOUBLE) {
            increaseQuality(item);
        }

        if (item.getSellIn() < THRESHOLD_TRIPLE) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.getQuality() < LIMIT_QUALITY) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private void decreaseQuality(Item item) {
        if (hasQuality(item) && isNotName(item, SULFURAS)) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private boolean hasQuality(Item item) {
        return item.getQuality() > 0;
    }

    private boolean isName(Item item, String name) {
        return item.getName().equals(name);
    }

    private boolean isNotName(Item item, String name) {
        return isName(item, name) == false;
    }
}
