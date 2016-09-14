package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by leslie on 07/05/2016.
 */
public class Maintenance implements Icat,Ibird,Idog,Ilocation,Istatus,IanimalType, Ibreeds{
    private String dogBreed, catBreed,birdBreed,animalType,location,status,animalBreed;

    public Maintenance() {

    }


    @Override
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    @Override
    public String getAnimalType() {
        return animalType;
    }

    @Override
    public String getBirdBreed() {
        return birdBreed;
    }

    @Override
    public void setBirdBreed(String birdBreed) {
    this.birdBreed = birdBreed;
    }

    @Override
    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    @Override
    public String getAnimalBreed() {
        return animalBreed;
    }

    @Override
    public void setCatBreed(String catBreed) {
        this.catBreed = catBreed;
    }

    @Override
    public String getCatBreed() {
        return catBreed;
    }

    @Override
    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    @Override
    public String getDogBreed() {
        return dogBreed;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

}
