package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by leslie on 12/03/2016.
 */
public class Found extends Category implements Serializable {
    static int AnimalFoundId = 1;

    private String location;
    private Person owner;

    public Found(LocalDate date, Person owner, String location) {
        super(date, owner);
        setLocation(location);
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setLocation(String location) {
        this.location = location;

    }


    public Person getOwner() {
        return owner;
    }

    public String getLocation() {
        return location;
    }



    public String toString() {
        return  getLocation() + "\n" + getOwner() + "\n" + super.date;
    }

    public void print(){
        System.out.println(toString());
    }


}
