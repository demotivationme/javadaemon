package main;

/**
 * Created by demo on 25.05.15.
 */
public class ConfigItem {
    public String title;
    public Double price;
    public String id;

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
