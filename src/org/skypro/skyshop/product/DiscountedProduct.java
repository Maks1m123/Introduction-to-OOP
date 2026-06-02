package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        int i = (basePrice * discountPercent) / 100;
        return basePrice - i;
    }
    @Override
    public boolean isSpecial(){
        return true;
    }

    @Override
    public String toString() {
     return getName() + " : " + getPrice() + " скидка(" + discountPercent + " %)";
    }
}
