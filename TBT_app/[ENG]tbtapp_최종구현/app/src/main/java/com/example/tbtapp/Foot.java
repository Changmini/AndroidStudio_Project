package com.example.tbtapp;

public class Foot {
    private int id;
    private String kind;
    private String name;
    private String price;
    private String size;
    private String angle;
    private byte[] image;

    public Foot(String kind, String name, String price, String size, String angle, byte[] image, int id){
        this.kind = kind;
        this.name = name;
        this.price = price;
        this.size = size;
        this.angle = angle;
        this.image = image;
        this.id = id;
    }
    public void setKind(String name) {this.kind = kind;}
    public  void setName(String name){ this.name=name; }
    public  void setPrice(String price){ this.price=price; }
    public void setSize(String size){ this.size = size;}
    public void setAngle(String angle){ this.angle = angle;}
    public  void setImage(byte[] image){ this.image=image; }
    public  void setId(int id){ this.id=id; }

    public String getKind(String name) { return kind; }
    public  String getName(){ return name; }
    public  String getPrice(){ return price; }
    public String getSize(){ return size; }
    public String getAngle(){ return angle; }
    public  byte[] getImage(){ return image; }
    public  int getId(){ return id; }

}
