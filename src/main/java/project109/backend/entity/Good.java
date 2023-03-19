package project109.backend.entity;

import org.springframework.stereotype.Component;

import project109.backend.util.Common;

@Component
public class Good {
    private String id = Common.CreateRandomId(8);
    private String name;
    private int price;
    private boolean availible = false; //預設不顯示，避免誤上架
    
    public Good() {
    }

    public Good(String id, String name, int price, boolean availible) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availible = availible;
    }

    public Good(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Good(String name, int price, boolean availible) {
        this.name = name;
        this.price = price;
        this.availible = availible;
    }

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailible() {
        return this.availible;
    }

    public boolean getAvailible() {
        return this.availible;
    }

    public void setAvailible(boolean availible) {
        this.availible = availible;
    }

    public Good id(String id) {
        setId(id);
        return this;
    }

    public Good name(String name) {
        setName(name);
        return this;
    }

    public Good price(int price) {
        setPrice(price);
        return this;
    }

    public Good availible(boolean availible) {
        setAvailible(availible);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", availible='" + isAvailible() + "'" +
            "}";
    }

}


