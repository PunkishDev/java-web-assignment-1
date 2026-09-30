package dev.punkish.booking.models;

public class Ticket {
    private String id;
    private String title;
    private long price;
    private Boolean sold;

    //Constructors
    public Ticket() {}
    public Ticket(String id, String title, long price, Boolean sold) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.sold = sold;
    }

    //Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public long getPrice() { return price; }
    public Boolean isSold() { return sold; }

    //Setters
    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setPrice(long price) { this.price = price; }
    public void toggleSold() { sold = !sold; }
}
