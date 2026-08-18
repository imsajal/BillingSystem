package org.demo;

public class CartItem {
    private String id;
    private Long Price;
    private ItemCategory category;
    private Long quantity;

    public CartItem(Long quantity, ItemCategory category, Long price, String id) {
        this.quantity = quantity;
        this.category = category;
        Price = price;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
