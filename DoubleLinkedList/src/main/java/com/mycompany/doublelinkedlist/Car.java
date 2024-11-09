/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doublelinkedlist;


public class Car
{
    public String Brand;
    public Integer Price;
    public Integer HorsePower;


    @Override
    public String toString()
    {
        return "To jest samochód marki "+Brand + ", kosztuje " + Price + " i ma " + HorsePower + " mocy; ";
    }
    
    public Car(String brand, Integer price, Integer horsepower)
    {
        this.Brand = brand;
        this.Price = price;
        this.HorsePower = horsepower;
    }


}
