package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Arrays;

/**
 * Created by leslie on 16/03/2016.
 */
public class DataBase implements Serializable {
    FileChooser filechooser = new FileChooser();
    private ObservableList<Person> people;
    private ObservableList<Animal> animalData;
    private ObservableList<String> locates;
    private ObservableList<String> locationList;
    private ObservableList<String> forTypes;

    public DataBase() {
        people = FXCollections.observableArrayList();
        animalData = FXCollections.observableArrayList();
        locates = FXCollections.observableArrayList();
        forTypes = FXCollections.observableArrayList();
        locationList = FXCollections.observableArrayList();
    }

    public ObservableList<String> getForTypes() {
        return forTypes;
    }

    public void addTypes(String types) {
        this.forTypes.add(types);
    }

    public ObservableList<String> getLocte() {
        return locates;
    }

    public void addLocate(String locat) {
        this.locates.add(locat);
    }

    public void addLocations(String place) {
        this.locationList.add(place);
    }

    public ObservableList<String> getLocations() {
        return locationList;
    }

    public void clearLocationList() {
        locationList.clear();
    }

    public void writetoFile(File file) {
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(file), true));

            for (String str : locates) {
                bw.write(str + "\n");
            }
            bw.close();
            clearListLocates();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filePicker() {
        filechooser.setInitialDirectory(new File("src\\files"));
        File selectedFile = filechooser.showOpenDialog(null);
        if (selectedFile != null) {
            writetoFile(selectedFile);

        } else {
            System.out.println("Cannot use selected file");
        }

    }

    public void clearListLocates() {
        locates.clear();

    }

    public void clearForTypes() {
        forTypes.clear();
    }

    public ObservableList<Person> getPeople() {
        return people;
    }

    public void addPeople(Person people) {
        this.people.add(people);

    }

    public void writeToPersonFile() {
        try {

            ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(("src\\LostSectionFiles\\Person.bin"), true));

            for (Person list : people) {
                bw.writeObject(list + "\n");
            }
            bw.close();
            people.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public ObservableList<Animal> getAnimalData() {
        return animalData;
    }

    public void addAnimalData(Animal animalData) {
        this.animalData.add(animalData);
    }

    public void savePeopleToFile(File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

        Person[] persons = people.toArray(new Person[people.size()]);
        objOut.writeObject(persons);

        objOut.close();
    }

    public void loadFromPeopleFile(File file) throws IOException {
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream obIn = new ObjectInputStream(fileIn);

        try {
            Person[] persons = (Person[]) obIn.readObject();
            people.clear();
            people.addAll(Arrays.asList(persons));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public AnimalList readAnimalListSerial() {
        AnimalList animalList = null;
        try {
            FileInputStream fileIn = new FileInputStream("src//data//AnimalLost.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            animalList = (AnimalList) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();

        }


        return animalList;
    }


    public void saveToAnimalFile(AnimalList list)  {
        try {
            FileOutputStream fileOut = new FileOutputStream("src//data//AnimalLost.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(list);
            objOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
