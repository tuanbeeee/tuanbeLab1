package DTO;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuanb
 */
public class Food  {
    private String ID;
    private String name;
    private double grams;
    private String type;
    private String place;
    private Date expiredDate;
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    
     public Food(String ID, String name, double grams, String type, String place, Date expiredDate) {
        this.ID = ID;
        this.name = name;
        this.grams = grams;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
     }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getexpiredDate() {
        return expiredDate;
    }

    public void setexpiredDate(Date expiredDate) {
        this.expiredDate = (expiredDate);
    }
    @Override
    public String toString(){
        return ID + "/t" + this.name + "/t" + this.grams + "/t" + this.type + "/t" + this.place + "/t" + this.expiredDate;
    }
}

