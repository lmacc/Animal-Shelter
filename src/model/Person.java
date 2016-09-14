package model;

import java.io.Serializable;

/**
 * Created by leslie on 12/03/2016.
 */
public class Person implements Serializable {


    private String name;
    private String address;
    private String phone;
    private String email;
    private static int id;
    private int personId;

    public Person(String name, String address, String phone, String email) {
        Animal theAnimal = new Animal();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        id++;
        this.personId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    public int getPersonId() {
        return personId;
    }





    @Override
    public String toString() {
        return  getPersonId() + "\n" + getName() + "\n" + getAddress() + "\n" + getPhone() + "\n" + getEmail() + "\n";

    }

    public void print() {
        System.out.println(toString());
    }
}
