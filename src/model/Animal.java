package model;


import javafx.scene.control.DatePicker;
import mainApplication.AdoptionUI;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * Created by leslie on 12/03/2016.
 */
public class Animal implements Serializable {
    Category animalCat, adoption;
    private static int id;
    private int ID;
    private int age;
    private String aType;
    private String description;
    private String breed;
    private String location;
    private String name;
    private boolean gender;
    private LocalDate date;
    private Image image;
    private Gender animalGender;
    Adoption adopt = new Adoption(date);

    //Default constructor
    public Animal(){}

    // sample.model.Found animals
    public Animal(String type, boolean gender, String location, String desc) {
        setaType(type);
        setGender(gender);
        setLocation(location);
        setDescription(desc);
        id++;
        this.ID = id;

    }

    // sample.model.Adoption sample.model.Category
    public Animal(int age, String type, boolean gender, String breed, String desc) {
        this(type, gender, breed, desc);
        setAge(age);
        setBreed(breed);


    }

    // sample.model.Lost animals
    public Animal(int age, String type, boolean gender, String breed, String desc, String name) {
        this(age, type, gender, breed, desc);
        setName(name);
        id++;
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public Category getAnimalCat() {
        return animalCat;
    }

    public void setAnimalCat(Category animalCat) {
        this.animalCat = animalCat;
    }

    public Category getAdoption() {
        return adoption;
    }

    public void setAdoption(Category adoption) {
        this.adoption = adoption;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;

    }



    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGender() {

        return gender;

    }

    public void setGender(boolean gender) {
        this.gender = gender;

        //Call the method to set the enum gender value to male or female
        //by passing in the boolean value to the method
        theGender(gender);
    }



    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    //set Enum Gender
    public void theGender(boolean gender) {
        this.gender = gender;
        if (this.gender) {
            this.animalGender = Gender.male;
        } else
            this.animalGender = Gender.female;

    }

    //Get the enum animal gender, better than returning true or false.
    public Gender getAnimalGender(){
        return animalGender;
    }

    @Override
    public String toString() {
        return getID()+ "\n" + getAge() + "\n" + getType() + "\n" + getDescription()
                + "\n" + getBreed() + "\n" + getName() + "\n" + getGender() + "\n";

    }

    public void print() {
        System.out.println(toString());
    }
}
