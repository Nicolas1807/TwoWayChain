/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doublelinkedlist;

public class Person
{
    public String Name;
    public String Surname;
    public Integer Age;
    public String Occupation;

    @Override
    public String toString()
    {
        return Name + " " + Surname + ", ma lat " + Age + " i pracuje jako " + Occupation;
    }
    
    public Person(String name, String surname, Integer age, String occupation)
    {
        this.Name = name;
        this.Surname = surname;
        this.Age = age;
        this.Occupation = occupation;
    }

}
