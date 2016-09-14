package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.*;

/**
 * Created by leslie on 16/03/2016.
 */
public class DropDownList implements Serializable {


    FileChooser filechooser = new FileChooser();

    private ObservableList<String> locates;
    private ObservableList<String> locationList;
    private ObservableList<String> forTypes;


    public DropDownList() {
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


    //Method is called when the tables in the lost section are populated
    // Object lost is passed to the method parameter and written to the binary file LostList.bin


    public void writetoFile(File file) {

        locates.clear();
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


}
