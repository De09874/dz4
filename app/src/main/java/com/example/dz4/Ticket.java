package com.example.dz4;

import java.io.Serializable;

public class Ticket implements Serializable {
    // поля
    private int ID; // идентификатор
    private String startPoint; // точка отправления
    private String endPoint; // точка прибытия
    private String startTime; // время отправления
    private String endTime; // время прибытия
    private int price; // цена билета

    // конструктор

    public Ticket(int ID, String startPoint, String endPoint, String startTime, String endTime, int price) {
        this.ID = ID;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }


    // геттеры

    public int getID() {
        return ID;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getPrice() {
        return price;
    }
}
