package cn.solohand.item.pojo;

public class Item {
    private int id;
    private String name;
    private String type;
    private String brand;
    private int count;
    private double price;
    private String sort;
    private String picture;

    public Item() {
    }

    public Item(int id, String name, String type, String brand, int count, double price, String sort, String picture) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.count = count;
        this.price = price;
        this.sort = sort;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
