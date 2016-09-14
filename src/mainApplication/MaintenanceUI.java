package mainApplication;

import fileObjects.SerializationClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Maintenance;
import model.MaintenanceList;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NavigableMap;
import java.util.ResourceBundle;

/**
 * Created by leslie on 17/04/2016.
 */
public class MaintenanceUI implements Initializable {

    Label amimalType, dogBreed,catBreed,birdBreed, location, status, breed;
    private Maintenance maintenance;
    // Fields
    TextField amimalT,dogB,catB,birdB,locate,stat,otherbreed;

    // Buttons
    private Button addType,delType,addDog,delDog,addCat,delCat,addBird,delBird,addLoct,delLoct,addStat,delStat,addOther,delOther;
    private Button saveType, saveDog, saveCat, saveBird, saveLocat, saveStat,saveOther;
    private Button disType, disDog, disCat, disBird, disLocat, disStat, disOther;
    private Button lost,found,adopt;
    private Stage stage;

    private ListView<String> animalList,dogList,catList,birdList,locateList,statusList,breedList;
    private File animalTypes, locations, animalBreeds, dogBreeds,catBreeds,birdBreeds,statusfile, othebreeds;



    private MaintenanceList maintenanceList = new MaintenanceList();

    // Date format
    String dateFormat;


    public MaintenanceUI(){

        animalTypes = new File("src\\files\\animaltypes.txt");
        locations = new File("src\\files\\location.txt");
        dogBreeds = new File("src\\files\\dogBreeds.txt");
        catBreeds = new File("src\\files\\catBreeds.txt");
        statusfile = new File("src\\files\\status.txt");
        birdBreeds = new File("src\\files\\birdBreeds.txt");
        othebreeds = new File("src\\files\\otherBreeds.txt");
        stage = new Stage();
        stage.setTitle("Maintenance");

        Scene scene = new Scene(borderPane(),1100,800);

        stage.setScene(scene);
        stage.show();
    }


    public ObservableList observableList(){

        ObservableList<String> theList = FXCollections.observableArrayList();
        theList.clear();
        for (int i = 0; i < maintenanceList.size(); i++){
            theList.add(maintenanceList.get(i));
        }
        //Clear the list before reading in the next file.
        maintenanceList.clearList();
        return theList;
    }

    public GridPane maintenanceGrid(){
        GridPane animalMain = new GridPane();
        //addType,delType,addDog,delDog,addCat,delCat,addBird,delBird,addLoct,delLoct,addStat,delStat;
        //create new instance of buttons
        addType = new Button("Add Type");
        addType.setMaxWidth(120);
        delType = new Button("Delete Type");
        delType.setMaxWidth(120);
        addDog = new Button("Add Dog");
        addDog.setMaxWidth(120);
        delDog = new Button("Delete Dog");
        delDog.setMaxWidth(120);
        addCat = new Button("Add Cat");
        addCat.setMaxWidth(120);
        delCat = new Button("Delete Cat");
        delCat.setMaxWidth(120);
        addBird = new Button("Add Bird");
        addBird.setMaxWidth(120);
        delBird = new Button("Delete Bird");
        delBird.setMaxWidth(120);
        addLoct = new Button("Add Location");
        addLoct.setMaxWidth(120);
        delLoct = new Button("Delete Location");
        delLoct.setMaxWidth(120);
        addStat = new Button("Add Status");
        addStat.setMaxWidth(120);
        delStat = new Button("Delete Status");
        delStat.setMaxWidth(120);

        addOther = new Button("Add Other");
        addOther.setMaxWidth(120);
        delOther = new Button("Delete Other");
        delOther.setMaxWidth(120);

        //saveType, saveDog, saveCat, saveBird, saveLocat, saveStat,saveOther;

        saveType = new Button("Save");
        saveType.setMaxWidth(120);
        saveDog = new Button("Save");
        saveDog.setMaxWidth(120);
        saveCat = new Button("Save");
        saveCat.setMaxWidth(120);
        saveBird = new Button("Save");
        saveBird.setMaxWidth(120);
        saveLocat = new Button("Save");
        saveLocat.setMaxWidth(120);
        saveStat = new Button("Save");
        saveStat.setMaxWidth(120);
        saveOther = new Button("Save");
        saveOther.setMaxWidth(120);
        //disType, disDog, disCat, disBird, disLocat, disStat, disOther;

        disType = new Button("Display");
        disType.setMaxWidth(120);
        disDog = new Button("Display");
        disDog.setMaxWidth(120);
        disCat = new Button("Display");
        disCat.setMaxWidth(120);
        disBird = new Button("Display");
        disBird.setMaxWidth(120);
        disLocat = new Button("Display");
        disLocat.setMaxWidth(120);
        disStat = new Button("Display");
        disStat.setMaxWidth(120);
        disOther = new Button("Display");
        disOther.setMaxWidth(120);

        //setting the width of the columns to 120 pixels
        for (int i = 0; i <= 7; i++) {
            ColumnConstraints column = new ColumnConstraints(120);
            animalMain.getColumnConstraints().add(column);
        }
        //Labels
        animalMain.setHgap(10);
        animalMain.setVgap(15);

        amimalType = new Label("Animal Type");
        dogBreed = new Label("Dog Breeds");
        catBreed = new Label("Cat Breeds");
        birdBreed = new Label("Bird Breeds");
        location = new Label("Locations");
        status = new Label("Adoption Status");
        breed = new Label("Other Breed");
        //Text fields

        amimalT = new TextField();
        amimalT.setPromptText("Type");
        amimalT.setPrefWidth(120);

        dogB = new TextField();
        dogB.setPromptText("Dog breed");
        dogB.setPrefWidth(120);

        catB = new TextField();
        catB.setPromptText("Cat breed");
        catB.setPrefWidth(120);

        birdB = new TextField();
        birdB.setPromptText("Bird breed");
        birdB.setPrefWidth(120);

        locate = new TextField();
        locate.setPromptText("Location");
        locate.setPrefWidth(120);

        stat = new TextField();
        stat.setPromptText("Status");
        stat.setPrefWidth(120);

        otherbreed = new TextField();
        otherbreed.setPromptText("Other breeds");
        otherbreed.setPrefWidth(120);

        animalMain.add(amimalType,1,1);
        animalMain.add(amimalT,1,2);
        animalMain.add(animalType(),1,3);
        animalMain.add(addType,1,4);
        animalMain.add(delType,1,5);
        animalMain.add(saveType,1,6);
        animalMain.add(disType,1,7);

        animalMain.add(dogBreed,2,1);
        animalMain.add(dogB,2,2);
        animalMain.add(dogType(),2,3);
        animalMain.add(addDog,2,4);
        animalMain.add(delDog,2,5);
        animalMain.add(saveDog,2,6);
        animalMain.add(disDog,2,7);

        animalMain.add(catBreed,3,1);
        animalMain.add(catB,3,2);
        animalMain.add(catType(),3,3);
        animalMain.add(addCat,3,4);
        animalMain.add(delCat,3,5);
        animalMain.add(saveCat,3,6);
        animalMain.add(disCat,3,7);


        animalMain.add(birdBreed,4,1);
        animalMain.add(birdB,4,2);
        animalMain.add(birdType(),4,3);
        animalMain.add(addBird,4,4);
        animalMain.add(delBird,4,5);
        animalMain.add(saveBird,4,6);
        animalMain.add(disBird,4,7);

        animalMain.add(location,5,1);
        animalMain.add(locate,5,2);
        animalMain.add(locationTable(),5,3);
        animalMain.add(addLoct,5,4);
        animalMain.add(delLoct,5,5);
        animalMain.add(saveLocat,5,6);
        animalMain.add(disLocat,5,7);


        animalMain.add(status,6,1);
        animalMain.add(stat,6,2);
        animalMain.add(statTable(),6,3);
        animalMain.add(addStat,6,4);
        animalMain.add(delStat,6,5);
        animalMain.add(saveStat,6,6);
        animalMain.add(disStat,6,7);

        animalMain.add(breed,7,1);
        animalMain.add(otherbreed,7,2);
        animalMain.add(otherAnimalBreeds(),7,3);
        animalMain.add(addOther,7,4);
        animalMain.add(delOther,7,5);
        animalMain.add(saveOther,7,6);
        animalMain.add(disOther,7,7);


        disType.setOnAction(event -> {
            diplayType();
        });

        addType.setOnAction(event -> {
            addToType();
        });

        addCat.setOnAction(event -> {
            addCat();
        });

        addDog.setOnAction(event -> {
            addDog();
        });

        addLoct.setOnAction(event -> {
            addLocation();
        });

        addBird.setOnAction(event -> {
            addBird();
        });

        addStat.setOnAction(event -> {
            addStat();
        });

        addOther.setOnAction(event -> {
            addToBreed();
        });

        saveType.setOnAction(event -> {
            saveToAnimalType();
        });

        saveDog.setOnAction(event -> {
            saveToDogType();
        });

        saveCat.setOnAction(event -> {
            saveToCatType();
        });

        saveBird.setOnAction(event -> {
            saveToBirdType();
        });


        saveLocat.setOnAction(event -> {
            saveToLocations();
        });

        saveStat.setOnAction(event -> {
            saveToStatus();
        });

        disDog.setOnAction(event -> {
            displayDog();
        });

        disCat.setOnAction(event -> {
            displayCat();
        });

        disBird.setOnAction(event -> {
            displayBirds();
        });

        disStat.setOnAction(event -> {
            displayStatus();
        });

        disLocat.setOnAction(event -> {
            displayLocations();
        });

        disOther.setOnAction(event -> {
            displayBreeds();
        });


        saveOther.setOnAction(event -> {
            saveToAllBreeds();
        });

        animalMain.setLayoutY(70);
        return animalMain;
    }



    public void diplayType(){
        readFile(animalTypes);
        animalList.setItems(observableList());
    }

    public void displayDog(){
        readFile(dogBreeds);
        dogList.setItems(observableList());
    }

    public void displayCat(){
        readFile(catBreeds);
        catList.setItems(observableList());
    }

    public void displayBirds(){
        readFile(birdBreeds);
        birdList.setItems(observableList());
    }

    public void displayStatus(){
        readFile(statusfile);
        statusList.setItems(observableList());
    }

    public void displayLocations(){
        readFile(locations);
        locateList.setItems(observableList());
    }

    public void displayBreeds(){
        readFile(othebreeds);
        breedList.setItems(observableList());
    }



    public void readFile(File file){
        ObservableList<String> theList = FXCollections.observableArrayList();
        try (FileReader reader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                maintenanceList.addType(line);

            }
            bufferedReader.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;

    }
    //animalList,dogList,catList,birdList,locateList,statusList,breedList;
    public void addToBreed(){
        String b;
        maintenance = new Maintenance();
        if (otherbreed.getText() != null) {
            b = otherbreed.getText();
            maintenanceList.addType(b);
            maintenance.setAnimalBreed(b);
            breedList.getItems().add(b);
            otherbreed.clear();
        }

    }

    public void addToType() {
        String s;
         maintenance = new Maintenance();
        if (amimalT.getText() != null) {
            s = amimalT.getText();
            maintenanceList.addType(s);
            maintenance.setAnimalType(s);
            animalList.getItems().add(s);

            amimalT.clear();
        }
    }

    public void addCat() {
        String c;
        maintenance = new Maintenance();

        if (catB.getText() != null) {
            c = catB.getText();
            maintenanceList.addType(c);
            maintenance.setCatBreed(c);
            catList.getItems().add(c);
            catB.clear();
        }
    }

    public void addDog() {
        String d;
        maintenance = new Maintenance();
        if (dogB.getText() != null) {
            d = dogB.getText();
            maintenanceList.addType(d);
            maintenance.setDogBreed(d);
            dogList.getItems().add(d);
            dogB.clear();
        }
    }

    public void addLocation() {
        String l;
        maintenance = new Maintenance();
        if (locate.getText() != null) {
            l = locate.getText();
            maintenanceList.addType(l);
            maintenance.setLocation(l);
            locateList.getItems().add(l);
            locate.clear();
        }
    }

    public void addBird() {
        String b;
        maintenance = new Maintenance();
        if (birdB.getText() != null) {
            b = birdB.getText();
            maintenanceList.addType(b);
            maintenance.setBirdBreed(b);
            birdList.getItems().add(b);
            birdB.clear();
        }
    }

    public void addStat(){
        String st;
        maintenance = new Maintenance();
        if (stat.getText() != null){

            st = stat.getText();
            maintenanceList.addType(st);
            maintenance.setStatus(st);
            statusList.getItems().add(st);
            stat.clear();
        }
    }




    public ListView<String> animalType(){
        animalList = new ListView<String>();
        animalList.setPrefWidth(120);
        animalList.setMaxHeight(150);

        return animalList;
    }

    public ListView<String> otherAnimalBreeds(){
        breedList = new ListView<String>();
        breedList.setPrefWidth(120);
        breedList.setMaxHeight(150);

        return breedList;
    }


    public ListView<String> dogType(){
        dogList = new ListView<String>();
        dogList.setPrefWidth(120);
        dogList.setMaxHeight(150);

        return dogList;
    }

    public ListView<String> catType(){
        catList = new ListView<String>();
        catList.setPrefWidth(120);
        catList.setMaxHeight(150);

        return catList;
    }
    public ListView<String> birdType(){
        birdList = new ListView<String>();
        birdList.setPrefWidth(120);
        birdList.setMaxHeight(150);

        return birdList;
    }

    public ListView<String> locationTable(){
        locateList = new ListView<String>();
        locateList.setPrefWidth(120);
        locateList.setMaxHeight(150);

        return locateList;
    }

    public ListView<String> statTable(){
        statusList = new ListView<String>();
        statusList.setPrefWidth(120);
        statusList.setMaxHeight(150);

        return statusList;
    }

    public void saveToAllBreeds(){
        maintenanceList.writetoFile(othebreeds);
        maintenanceList.clearList();
    }

    public void saveToAnimalType(){
        maintenanceList.writetoFile(animalTypes);
        maintenanceList.clearList();
    }

    public void saveToDogType(){
        maintenanceList.writetoFile(dogBreeds);
        maintenanceList.clearList();
    }

    public void saveToCatType(){
        maintenanceList.writetoFile(catBreeds);
        maintenanceList.clearList();
    }

    public void saveToBirdType(){
        maintenanceList.writetoFile(birdBreeds);
        maintenanceList.clearList();
    }

    public void saveToLocations(){
        maintenanceList.writetoFile(locations);
        maintenanceList.clearList();
    }

    public void saveToStatus(){
        maintenanceList.writetoFile(statusfile);
        maintenanceList.clearList();
    }

    public AnchorPane anchorPane() {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(maintenanceGrid());
        return anchorPane;
    }

    public BorderPane borderPane() {
        SerializationClass serial = new SerializationClass();
        BorderPane root = new BorderPane();
        // btnAdd.setText("Add");

        lost = new Button("Lost Section");
        found = new Button("Found Section");
        adopt = new Button("Adoption Section");
        VBox topContainer = new VBox();  //Creates a container to hold all Menu Objects.
        MenuBar mainMenu = new MenuBar();  //Creates our main menu to hold our Sub-Menus.
        //Declare sub-menus and add to main menu.
        Menu about = new Menu("About");
        MenuItem aboutThis = new MenuItem("Maintenance for adding and removing animals");
        about.getItems().add(aboutThis);
        mainMenu.getMenus().addAll(about);

        ToolBar toolBar = new ToolBar();  //Creates our tool-bar to hold the buttons.
        toolBar.getItems().addAll(lost, found, adopt);
        topContainer.getChildren().addAll(mainMenu, toolBar);

        root.setTop(topContainer);
        root.setCenter(anchorPane());

        lost.setOnAction(event -> {

        });

        found.setOnAction(event -> {
            new FoundUI();
            stage.close();
        });

        adopt.setOnAction(event -> {
            new AdoptionUI();
            stage.close();
        });
        return root;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
