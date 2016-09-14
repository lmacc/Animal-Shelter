package model;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * Created by leslie on 12/03/2016.
 */
public  class Category implements Serializable{
    LocalDate date;
    Person contact;


    Category(LocalDate date) {
        setDate(date);
    }

    Category(LocalDate date, Person contact) {
        this.date = (date);
        setContact(contact);
    }




    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setContact(Person person) {
        this.contact = person;

    }

    public Person getPerson() {
        return contact;
    }


    @Override
    public String toString() {
        return getDate() +  "\n" + getPerson()+ "\n";

    }
}
