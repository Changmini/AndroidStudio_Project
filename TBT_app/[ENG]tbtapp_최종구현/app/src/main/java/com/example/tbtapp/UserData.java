package com.example.tbtapp;

import java.io.Serializable;

public class UserData implements Serializable {
    private String name;
    private String email;
    private int count;
    private double footSIze;
    private double ballSIze;
    private double angle;

    public UserData(){
        this.name = null;
        this.email = null;
        this.count =0;
        this.footSIze=0;
        this.ballSIze=0;
        this.angle=0;
    }

    public UserData(String name, String email, int count, int footSIze, int ballSIze, int angle) {
        this.name = name;
        this.email = email;
        this.count = count;
        this.footSIze = footSIze;
        this.ballSIze = ballSIze;
        this.angle = angle;
    }

    public UserData(String name, String email) {
        this.name = name;
        this.email = email;
        this.count =0;
        this.footSIze=0;
        this.ballSIze=0;
        this.angle=0;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public double getFootSIze() { return footSIze; }
    public void setFootSIze(double footSIze) { this.footSIze = footSIze; }

    public double getBallSIze() { return ballSIze; }
    public void setBallSIze(double ballSIze) { this.ballSIze = ballSIze; }

    public double getAngle() { return angle; }
    public void setAngle(double angle) { this.angle = angle; }
}
