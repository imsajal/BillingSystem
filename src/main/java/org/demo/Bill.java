package org.demo;

import java.util.List;
import java.util.Set;

public class Bill {
    private String id;
    private Set<CartItem> items;
    private Long amount;
    private User user;

    public Bill(String id, Set<CartItem> items, Long amount, User user) {
        this.id = id;
        this.items = items;
        this.amount = amount;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
