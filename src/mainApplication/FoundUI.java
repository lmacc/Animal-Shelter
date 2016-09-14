package mainApplication;

import fileObjects.SerializationClass;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by leslie on 23/04/2016.
 */
public class FoundUI implements Serializable, Initializable{
    private AnimalList animalList = new AnimalList();
    private PersonList personList = new PersonList();

    private DatePicker datePicker;
    private Scene scene;

    private TableView animalT;
    private TableView personT;
    private Stage stage;


    private Button disPerson,btnMain,disAnimal,lost,found,adopt,addAnimal,addImageBtn,delAnimal;
    private Button addImage = new Button("Add Image");
    private TextField tfAnimalName;
    private TextArea animalDescription;
    private TextField txtName, txtAddress, txtPhone, txtEmail;
    private ComboBox<String> cmbBreeds = new ComboBox<String>();
    private ComboBox<String> cmbTypes = new ComboBox<String>();
    private ComboBox<String> cmbLocations = new ComboBox<String>();
    private ComboBox<Integer> cmbAge = new ComboBox<>();
    private CheckBox chkmale, chkfemale;
    private ImageView imageView = new ImageView();

    private  SerializationClass serial,newSerial;
    private File animalTypes, locations, dogBreeds, catBreeds, birdBreeds, othebreeds;
    private String imageFile = ("dog.jpg");
    //person labels
    private Label pfName, pAddress, pEmail, pPhone;
    //animal labels
    Label aName, aAge, male, female, aType, aBreed, aDescription, aDate, aLocation;

    Label animalDetails = new Label("Animal Details");
    public FoundUI(){


        stage = new Stage();
        animalTypes = new File("src\\files\\animaltypes.txt");
        locations = new File("src\\files\\location.txt");

        dogBreeds = new File("src\\files\\dogBreeds.txt");
        catBreeds = new File("src\\files\\catBreeds.txt");
        birdBreeds = new File("src\\files\\birdBreeds.txt");
        othebreeds = new File("src\\files\\otherBreeds.txt");
        cmbTypes.getItems().addAll(fileReader(animalTypes));
        cmbLocations.getItems().addAll(fileReader(locations));

        selection();
        Scene scene = new Scene(borderPane(),1380,800);
        stage.setTitle("Found Section");
        stage.setScene(scene);
        stage.show();
    }

    public void selection() {

        cmbBreeds.setDisable(true);
        cmbTypes.setOnAction(event -> {

            if (cmbTypes.getSelectionModel().getSelectedItem().equalsIgnoreCase("dog")) {

                cmbBreeds.getItems().clear();
                cmbBreeds.setDisable(false);
                cmbBreeds.getItems().addAll(fileReader(dogBreeds));

            }
            if (cmbTypes.getSelectionModel().getSelectedItem().equalsIgnoreCase("cat")) {
                cmbBreeds.getItems().clear();
                cmbBreeds.setDisable(false);
                cmbBreeds.getItems().addAll(fileReader(catBreeds));
            }
            if (cmbTypes.getSelectionModel().getSelectedItem().equalsIgnoreCase("bird")) {
                cmbBreeds.getItems().clear();
                cmbBreeds.setDisable(false);
                cmbBreeds.getItems().addAll(fileReader(birdBreeds));
            }

            if (!(cmbTypes.getSelectionModel().getSelectedItem().equalsIgnoreCase("dog") || (cmbTypes.getSelectionModel().getSelectedItem().equalsIgnoreCase("cat")
                    || (cmbTypes.getSelectionModel().getSelectedItem().equalsIgnoreCase("cat"))))){
                cmbBreeds.getItems().clear();
                cmbBreeds.setDisable(false);
                cmbBreeds.getItems().addAll(fileReader(othebreeds));
            }

        });

    }

    public ArrayList<String> fileReader(File file) {
        String readFile;
        ArrayList<String> mainList = new ArrayList<String>();
        try {
            FileReader filein = new FileReader(file);
            BufferedReader br = new BufferedReader(filein);

            while ((readFile = br.readLine()) != null) {
                mainList.add(readFile);
            }
            br.close();
            filein.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mainList;
    }

    public ObservableList loadSerializedAnimal(){
        serial = new SerializationClass();
        ObservableList<Animal> theAnimals = FXCollections.observableArrayList();

        animalList = serial.deSerializeAnimalFoundList();
        for (int i = 0; i < animalList.size(); i++) {
            theAnimals.add(animalList.get(i));
        }
        animalList.clearTheList();
        return theAnimals;
    }

    public ObservableList loadSerializedPerson(){
         newSerial = new SerializationClass();
        ObservableList<Person> persons = FXCollections.observableArrayList();

        personList = newSerial.deSerializePersonFoundList();
        for(int i = 0; i < personList.size(); i++){
            persons.add(personList.get(i));
        }
        personList.clearPersonList();
        return persons;
    }

    public TableView<Person> personTable() {
        TableColumn<Person, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(140);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Person, String> addressCol = new TableColumn<>("Address");
        addressCol.setMinWidth(140);
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Person, String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setMinWidth(140);
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(140);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Person, Number> idCol = new TableColumn<>("Person Id");
        idCol.setMinWidth(40);
        idCol.setCellValueFactory(new PropertyValueFactory<>("personId"));

        personT = new TableView<>();
        personT.getColumns().addAll(idCol,nameCol, addressCol, phoneCol, emailCol);

        personT.setMaxHeight(120);
        personT.setLayoutX(540);
        personT.setLayoutY(300);

        return personT;
    }

    public GridPane personGrid(){
        GridPane perGrid = new GridPane();
        perGrid.setPadding(new Insets(20, 0, 20, 20));
        perGrid.setHgap(8);
        perGrid.setVgap(15);
        Label personDetail = new Label("Person Details");

        txtName = new TextField();
        txtAddress = new TextField();
        txtPhone = new TextField();
        txtEmail = new TextField();
        pfName = new Label("Name: ");
        pAddress = new Label("Address: ");
        pPhone = new Label("Phone: ");
        pEmail = new Label("Email: ");
        perGrid.add(personDetail,1,1);
        perGrid.add(pfName,1,2);
        perGrid.add(pAddress,1,3);
        perGrid.add(pPhone,1,4);
        perGrid.add(pEmail,1,5);
        perGrid.add(txtName,3,2);
        perGrid.add(txtAddress,3,3);
        perGrid.add(txtPhone,3,4);
        perGrid.add(txtEmail,3,5);
        perGrid.setLayoutX(510);

        return perGrid;
    }

    public HBox personBtn(){
        HBox hBox = new HBox();
        disPerson = new Button("Display Person");
        disPerson.setPrefWidth(120);
        hBox.setPrefWidth(124);
        hBox.setPadding(new Insets(1));
        hBox.getChildren().add(disPerson);
        hBox.setLayoutX(540);
        hBox.setLayoutY(270);

        disPerson.setOnAction(event -> {
            personT.setItems(loadSerializedPerson());
        });
        return hBox;
    }



    public void addToList(){
        boolean checked = false;
        if (chkmale.isSelected()){
            checked = true;
        }
        else {
            checked = false;
        }


        Animal animal = new Animal(cmbAge.getValue(),cmbTypes.getValue(),checked,cmbBreeds.getValue(),animalDescription.getText(),tfAnimalName.getText());
        if (tfAnimalName.getText() == null){
            tfAnimalName.setText("No Name");
        }

        if (cmbAge.getValue() == null){
            cmbAge.setValue(0);
        }

        animalT.getItems().add(animal);

        Person person = new Person(txtName.getText(),txtAddress.getText(),txtPhone.getText(),txtEmail.getText());
        personT.getItems().add(person);

        Category foundAnimal = new Found(datePicker.getValue(),person,cmbLocations.getValue());
        animal.setAnimalCat(foundAnimal);
        personList.addPerson(person);
        animalList.addAnimal(animal);

    }

    public HBox hBoxImageButton(){
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(5, 1, 10, 1));
        hBox.setSpacing(5);
        hBox.getChildren().addAll(addImage);
        return hBox;
    }

    public VBox vBoxImage(){
        VBox vBox = new VBox();
        vBox.getChildren().addAll(imageView(),hBoxImageButton());
        vBox.setLayoutX(500);
        vBox.setLayoutY(30);

        return vBox;
    }





    public TableView<Animal> animalTable() {

        TableColumn<Animal, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setMinWidth(50);
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Animal, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(120);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Animal, Gender> animalGenderCol = new TableColumn<>("Gender");
        animalGenderCol.setMinWidth(100);
        animalGenderCol.setCellValueFactory(new PropertyValueFactory<>("animalGender"));

        TableColumn<Animal, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(120);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Animal, String> breedCol = new TableColumn<>("Breed");
        breedCol.setMinWidth(150);
        breedCol.setCellValueFactory(new PropertyValueFactory<>("breed"));

        TableColumn<Animal, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setMinWidth(200);
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Animal, Number> idCol = new TableColumn<>("Animal ID");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Animal, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(120);
        dateCol.setCellValueFactory(cellData -> {
            return	new ReadOnlyStringWrapper(( cellData.getValue().getAnimalCat()).getDate().toString());
        });

        TableColumn<Animal, String> locationCol = new TableColumn<>("Location");
        locationCol.setMinWidth(130);
        locationCol.setCellValueFactory(cellData -> {
            return	new ReadOnlyStringWrapper(((Found) cellData.getValue().getAnimalCat()).getLocation());
        });

        animalT = new TableView<Animal>();

        animalT.getColumns().addAll(idCol, nameCol, ageCol, typeCol, animalGenderCol, breedCol, descriptionCol,dateCol,locationCol);

        animalT.setLayoutY(460);
        animalT.setLayoutX(80);
        animalT.setMaxHeight(150);
        return animalT;
    }



    public GridPane animalGrid() {
        GridPane gridPane = new GridPane();

        datePicker = new DatePicker();
        datePicker.setPrefWidth(150);
        gridPane.setPadding(new Insets(20, 0, 20, 20));
        gridPane.setHgap(8);
        gridPane.setVgap(8);
        aName = new Label("Name: ");
        aAge = new Label("Age: ");
        male = new Label("Male: ");
        female = new Label("Female: ");
        aType = new Label("Type: ");
        aBreed = new Label("Breed: ");
        aDate = new Label("Date: ");
        aLocation = new Label("Location");
        aDescription = new Label("Description");

        tfAnimalName = new TextField();
        tfAnimalName.setMaxWidth(150);
        cmbAge.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
        cmbAge.setPrefWidth(40);
        chkmale = new CheckBox();
        chkfemale = new CheckBox();
        cmbTypes.setPrefWidth(150);
        cmbBreeds.setPrefWidth(150);
        cmbLocations.setPrefWidth(150);
        animalDescription = new TextArea();
        animalDescription.setMaxWidth(300);
        animalDescription.setMaxHeight(80);
        gridPane.add(animalDetails, 1, 1);
        gridPane.add(aName, 1, 2);
        gridPane.add(tfAnimalName, 2, 2);
        gridPane.add(aAge, 1, 3);
        gridPane.add(cmbAge, 2, 3);
        gridPane.add(male, 1, 4);
        gridPane.add(female, 1, 5);
        gridPane.add(chkmale, 2, 4);
        gridPane.add(chkfemale, 2, 5);
        gridPane.add(aType, 1, 6);
        gridPane.add(cmbTypes, 2, 6);
        gridPane.add(aBreed, 1, 7);
        gridPane.add(cmbBreeds, 2, 7);
        gridPane.add(aDate, 1, 8);
        gridPane.add(datePicker, 2, 8);
        gridPane.add(aLocation, 1, 9);
        gridPane.add(cmbLocations, 2, 9);
        gridPane.add(aDescription, 1, 11);
        gridPane.add(animalDescription, 1, 12, 2, 2);

        gridPane.setLayoutX(50);


        return gridPane;
    }

    public VBox animalVBox(){
        VBox vBox = new VBox();
        disAnimal = new Button("Display Animals");
        addAnimal = new Button("Add to System");
        delAnimal = new Button("Delete Animal");
        delAnimal.setPrefWidth(100);
        disAnimal.setPrefWidth(100);
        addAnimal.setPrefWidth(100);
        disAnimal.setPadding(new Insets(5));
        addAnimal.setPadding(new Insets(5));
        vBox.getChildren().addAll(disAnimal,addAnimal,delAnimal);
        vBox.setPrefWidth(110);
        vBox.setSpacing(10);
        vBox.setLayoutX(400);
        vBox.setLayoutY(315);

        addAnimal.setOnAction(event -> {
            saveToList();
        });

        disAnimal.setOnAction(event -> {
            animalT.setItems(loadSerializedAnimal());
        });

        delAnimal.setOnAction(event -> {
            deleteAnimal();
        });

        return vBox;
    }

    public void deleteAnimal(){
        ObservableList<Animal> observableListAll, animalObservableListSome;
        observableListAll = animalT.getItems();
        animalObservableListSome = animalT.getSelectionModel().getSelectedItems();

        ArrayList<Animal> animal;

        animal = new ArrayList<>(animalObservableListSome);
        Animal a = new Animal();
        a = animal.get(0);
        animalObservableListSome.forEach(observableListAll::remove);
        animalList.removeAnimal(a);

    }


    public void saveToList(){
        if (isInputValid()){
            addToList();
        }

    }

    private boolean isInputValid() {
        String errorMessage = "";

        //Validate the animal input for the animal lost constructor
        //before adding to the animal table and animal list.




        if (cmbTypes.getValue() == null || cmbTypes.getValue().length() == 0) {
            errorMessage += "Type of animal not entered!\n";
        }
        // if (cmbGender.getValue() == null || cmbGender.getValue().length() == 0) {
        //  errorMessage += "Enter gender!\n";
        //}



        if (cmbBreeds.getValue() == null || cmbBreeds.getValue().length() == 0) {
            errorMessage += "Please Select breed!\n";
        }

        if (animalDescription.getText() == null || animalDescription.getText().length() == 0) {
            errorMessage += "Enter description value!\n";
        }

        if (txtName.getText() == null || txtName.getText().length() == 0) {
            errorMessage += "Enter name for Person!\n";
        }

        if (txtAddress.getText() == null || txtAddress.getText().length() == 0) {
            errorMessage += "Enter the person's address!\n";
        }

        if (txtPhone.getText() == null || txtPhone.getText().length() == 0) {
            errorMessage += "Enter the person's phone number!\n";
        }

        if (cmbLocations.getValue() == null || cmbLocations.getValue().length() == 0) {
            errorMessage += "Select a location from the dropdown list!\n";
        } else
            try {
                Integer.parseInt(txtPhone.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid number entered for phone (must be an interger)";
            }

        if (txtEmail.getText() == null || txtEmail.getText().length() == 0) {
            errorMessage += "Enter the person's email address!\n";
        }

        if (datePicker.getValue() == null) {
            errorMessage += "Please select date for entry!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
        }
    }


    public ImageView imageView() {


// Scale the iamge to 200 X 100
        double requestedWidth = 200;
        double requestedHeight = 150;
        boolean preserveRatio = false;
        boolean smooth = true;
        Image image = new Image(imageFile,
                requestedWidth,
                requestedHeight,
                preserveRatio,
                smooth);
        imageView = new ImageView(image);



        return imageView;
    }

    public GridPane forImage(){
        GridPane imageGrid = new GridPane();
        imageGrid.setVgap(20);
        imageGrid.setHgap(20);
        Label imageHeader = new Label("Image View");
        imageGrid.add(imageHeader,1,1);
        imageGrid.add(imageView(),1,2,5,5);
        imageGrid.setLayoutX(850);
        imageGrid.setLayoutY(10);

        return imageGrid;
    }

    public VBox imageSetBtn(){
        VBox vBox = new VBox();
        addImageBtn = new Button("Add Image");
        addImageBtn.setPrefWidth(80);
        vBox.getChildren().add(addImageBtn);
        vBox.setLayoutX(1090);
        vBox.setLayoutY(190);
        return vBox;
    }

    public AnchorPane anchorPane() {

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(animalGrid(), animalTable(),personGrid(),forImage(),personTable(),animalVBox(),personBtn(),imageSetBtn());
        return anchorPane;
    }

    public BorderPane borderPane() {
        SerializationClass serial = new SerializationClass();
        BorderPane root = new BorderPane();
        // btnAdd.setText("Add");

        lost = new Button("Lost Section");
        found = new Button("Found Section");
        adopt = new Button("Adoption Section");
        btnMain = new Button("Maintenance");
        VBox topContainer = new VBox();  //Creates a container to hold all Menu Objects.
        MenuBar mainMenu = new MenuBar();  //Creates our main menu to hold our Sub-Menus.
        //Declare sub-menus and add to main menu.
        Menu file = new Menu("File");
        MenuItem saveToFile = new MenuItem("Save to File");
        MenuItem serialze = new MenuItem("Serialize");
        MenuItem loadFile = new MenuItem("Load from Files");

        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");
        file.getItems().addAll(saveToFile,loadFile,serialze);
        mainMenu.getMenus().addAll(file, edit, help);

        ToolBar toolBar = new ToolBar();  //Creates our tool-bar to hold the buttons.
        toolBar.getItems().addAll(lost, found, adopt, btnMain);
        topContainer.getChildren().addAll(mainMenu, toolBar);

        root.setTop(topContainer);
        root.setCenter(anchorPane());

        lost.setOnAction(event -> {
            new LostUI();
            stage.close();
        });

        found.setOnAction(event -> {

        });

        adopt.setOnAction(event -> {
            new AdoptionUI();
            stage.close();
        });

        btnMain.setOnAction(event -> {
            new MaintenanceUI();
            stage.close();
        });

        saveToFile.setOnAction(event -> {
            serial.serializeAnimalFoundList(animalList);
            serial.serializePersonFoundList(personList);

        });

        loadFile.setOnAction(event -> {
            animalT.setItems(loadSerializedAnimal());
        });

        return root;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
