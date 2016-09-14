package fileObjects;

import javafx.scene.control.Alert;
import model.AnimalList;
import model.MaintenanceList;
import model.PersonList;

import java.io.*;

/**
 * Created by leslie on 20/04/2016.
 */
public class SerializationClass {

    public SerializationClass(){}

    private MaintenanceList mainList = new MaintenanceList();

    public void serializeAnimalLostList(AnimalList animalList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src//datafiles//animalListLost.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(animalList);
            outputStream.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Serialized Object");
        alert.setHeaderText("Serialization");
        alert.setContentText("AnimalList has been Serialized!");

        alert.showAndWait();

    }

    public void serializeAnimalFoundList(AnimalList animalList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src//datafiles//animalListFound.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(animalList);
            outputStream.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Serialized Object");
        alert.setHeaderText("Serialization");
        alert.setContentText("AnimalList has been Serialized!");

        alert.showAndWait();

    }

    public  AnimalList deSerializeAnimalFoundList(){
        AnimalList animalList = new AnimalList();
        animalList.clearTheList();
        try {
            FileInputStream fileInputStream = new FileInputStream("src//datafiles//animalListFound.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            animalList = (AnimalList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return animalList;

    }

    public  AnimalList deSerializeAnimalLostList(){
            AnimalList animalList = new AnimalList();
            animalList.clearTheList();
        try {
            FileInputStream fileInputStream = new FileInputStream("src//datafiles//animalListLost.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            animalList = (AnimalList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return animalList;

    }

    public void serializePersonLostList(PersonList personList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src//datafiles//personLost.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(personList);
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializePersonFoundList(PersonList personList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src//datafiles//personFound.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(personList);
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PersonList deSerializePersonLostList(){
        PersonList personList = new PersonList();
        personList.clearPersonList();
        try {
            FileInputStream fileInputStream = new FileInputStream("src//datafiles//personLost.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            personList = (PersonList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public PersonList deSerializePersonFoundList(){
        PersonList personList = new PersonList();
        personList.clearPersonList();
        try {
            FileInputStream fileInputStream = new FileInputStream("src//datafiles//personFound.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            personList = (PersonList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public void serializeAnimalAdoptionList(AnimalList animalList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src//datafiles//animalListAdoption.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(animalList);
            outputStream.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Serialized Object");
        alert.setHeaderText("Serialization");
        alert.setContentText("AnimalList has been Serialized!");

        alert.showAndWait();

    }

    public  AnimalList deSerializeAnimalAdoptionList(){
        AnimalList animalList = new AnimalList();
        animalList.clearTheList();
        try {
            FileInputStream fileInputStream = new FileInputStream("src//datafiles//animalListAdoption.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            animalList = (AnimalList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return animalList;

    }

    public void serializePersonAdoptionList(PersonList personList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src//datafiles//personAdoption.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(personList);
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Serialized Object");
        alert.setHeaderText("Serialization");
        alert.setContentText("Person interested has been Serialized!");

        alert.showAndWait();
    }

    public PersonList deSerializePersonAdoptionList(){
        PersonList personList = new PersonList();
        personList.clearPersonList();
        try {
            FileInputStream fileInputStream = new FileInputStream("src//datafiles//personAdoption.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            personList = (PersonList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personList;
    }




}
