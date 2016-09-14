package model;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * Created by leslie on 12/03/2016.
 */
public class Lost extends Category implements Serializable {
    private String location;




    public Lost(LocalDate date, Person contact, String location) {
        super(date, contact);
        this.location = location;
        setLocation(location);

    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }



    @Override
    public String toString() {
        return getLocation() +"\n"+ super.date + "\n" + super.contact;
    }

    public void print() {
        System.out.println(toString());
    }
}
