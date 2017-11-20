package csc214.project3;

/**
 * Created by leew15 on 4/23/2017.
 */

public class Clothing {
    public String type;
    public String color;
    public String brand;

    public Clothing(String t, String c, String b){
        type = t;
        color = c;
        brand = b;
    }
    public String toString(){
        return "" + type + ", " + color + ", " + brand;
    }
    public String getType(){
        return type;
    }
    public void setType(String t){
        this.type = t;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String c){
        this.color = c;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String b){
        this.brand = b;
    }
}
