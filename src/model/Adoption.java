package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by leslie on 13/03/2016.
 */
public class Adoption extends Category implements Serializable {
    private boolean neutered, chipped, vaccinated, reserved, animalStat;
    private String status;
    private static ArrayList<Person> interested;
    private Gender res,chip,vac,neut;
    static int adoptionId;

    public Adoption(LocalDate date) {
        super(date);
    }

    public Adoption(LocalDate date, boolean chipped, boolean neutered, boolean vaccinated, boolean reserved, String status) {
        super(date);
        setStatus(status);
        setChipped(chipped);
        setNeutered(neutered);
        setReserved(reserved);
        setVaccinated(vaccinated);
        interested = new ArrayList<Person>();
        adoptionId++;
    }

    public boolean getNeutered() {
        return neutered;

    }

    public void setNeutered(boolean neutered) {
        this.neutered = neutered;
        if (this.neutered) {
            this.neut = Gender.Yes;
        } else
            this.neut = Gender.No;

    }


    public boolean getChipped() {
        return chipped;
    }

    public void setChipped(boolean chipped) {
        this.chipped = chipped;
        if (this.chipped) {
            this.chip = Gender.Yes;
        } else
            this.chip = Gender.No;

    }


    public boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
        if (this.vaccinated) {
            this.vac = Gender.Yes;
        } else
            this.vac = Gender.No;

    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
        if (this.reserved) {
            this.res = Gender.Yes;
        } else
            this.res = Gender.No;

    }



    public void setGender(Gender gen){
        this.res = gen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addInterestedPerson(Person person) {
        interested.add(person);

    }

    public void removeInterestedPerson(Person person) {
        interested.remove(person);

    }

    public String getListOfPersons() {
        String persons = "";

        if (interested.size() != 0) {
            for (int i = 0; i < interested.size(); i++) {
                persons += interested.get(i).toString() + "\n";
            }
        }

        return persons;
    }

    public static int getAdoptionId() {
        return adoptionId;
    }

    public static void setAdoptionId(int adoptionId) {
        Adoption.adoptionId = adoptionId;
    }

    //Get the enum animal gender, better than returning true or false.
    public Gender getnutered() {
        return neut ;
    }

    public Gender getVac() {
        return vac ;
    }

    public Gender getRes() {
        return res ;
    }

    public Gender getChip(){
        return chip;
    }


    public String toString() {
        return getAdoptionId() + "\n" + getReserved() + "\n" + getNeutered() + "\n" + getChipped() + "\n" + getVaccinated()
                + "\n" + getStatus() + "\n" + getListOfPersons() + "\n" + getnutered() + "\n" + getVac() + "\n" + getRes()+ "\n"+ getChip();
    }

    public void print() {
        System.out.println(toString());
    }
}
