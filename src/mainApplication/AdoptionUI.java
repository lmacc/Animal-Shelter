package mainApplication;

import fileObjects.SerializationClass;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by leslie on 23/04/2016.
 */
public class AdoptionUI implements Serializable, Initializable {
    private AnimalList animalList = new AnimalList();
    private PersonList personList = new PersonList();
    private Adoption adoption;
    private DatePicker datePicker;
    private Stage stage;

    private TableView animalT;
    private TableView personT;

    private Button addPerson, disAnimal, lost, found, adopt, addAnimal, addImageBtn, btnMain ,disPerson, savPerson;
    private Button addImage = new Button("Add Image");
    RadioButton neut, chip, vacc, reserv;
    private TextField tfAnimalName;
    private TextArea animalDescription;
    private TextField txtName, txtAddress, txtPhone, txtEmail;
    private ComboBox<String> cmbBreeds = new ComboBox<String>();
    private ComboBox<String> cmbTypes = new ComboBox<String>();
    private ComboBox<String> cmbLocations = new ComboBox<String>();
    private ComboBox<String> cmbStatus = new ComboBox<>();
    private ComboBox<Integer> cmbAge = new ComboBox<>();
    private CheckBox chkmale, chkfemale;
    private ImageView imageView = new ImageView();

    private SerializationClass serial,newSerial;
    private File animalTypes,  dogBreeds, catBreeds, birdBreeds, othebreeds, statusFile;
    private String imageFile = ("dog.jpg");
    //person labels
    private Label pfName, pAddress, pEmail, pPhone;
    //animal labels
    Label aName, aAge, male, female, aType, aBreed, aDescription, aDate, aLocation, aStatus;

    Label animalDetails = new Label("Animal Details");

    public AdoptionUI() {
        stage = new Stage();
        animalTypes = new File("src\\files\\animaltypes.txt");
        statusFile = new File("src\\files\\status.txt");
        dogBreeds = new File("src\\files\\dogBreeds.txt");
        catBreeds = new File("src\\files\\catBreeds.txt");
        birdBreeds = new File("src\\files\\birdBreeds.txt");
        othebreeds = new File("src\\files\\otherBreeds.txt");

        cmbStatus.getItems().addAll(fileReader(statusFile));
        cmbTypes.getItems().addAll(fileReader(animalTypes));
        selection();
        Scene scene = new Scene(borderPane(), 1380, 800);
        stage.setTitle("Adoption Section");
        stage.setScene(scene);
        stage.show();
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

    public ObservableList loadSerializedAnimal() {
        serial = new SerializationClass();
        ObservableList<Animal> theAnimals = FXCollections.observableArrayList();

        animalList = serial.deSerializeAnimalAdoptionList();
        for (int i = 0; i < animalList.size(); i++) {
            theAnimals.add(animalList.get(i));
        }
        animalList.clearTheList();
        return theAnimals;
    }

    public ObservableList loadSerializedPerson() {
        newSerial = new SerializationClass();
        ObservableList<Person> persons = FXCollections.observableArrayList();

        personList = newSerial.deSerializePersonAdoptionList();
        for (int i = 0; i < personList.size(); i++) {
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
        personT.getColumns().addAll(idCol, nameCol, addressCol, phoneCol, emailCol);

        personT.setMaxHeight(120);
        personT.setLayoutX(630);
        personT.setLayoutY(300);

        return personT;
    }

    public GridPane personGrid() {
        GridPane perGrid = new GridPane();
        addPerson = new Button("Add Person");
        addPerson.setPrefWidth(100);
        perGrid.setPadding(new Insets(20, 0, 20, 20));
        perGrid.setHgap(8);
        perGrid.setVgap(15);
        Label personDetail = new Label("Person Interested");

        txtName = new TextField();
        txtAddress = new TextField();
        txtPhone = new TextField();
        txtEmail = new TextField();
        pfName = new Label("Name: ");
        pAddress = new Label("Address: ");
        pPhone = new Label("Phone: ");
        pEmail = new Label("Email: ");
        perGrid.add(personDetail, 1, 1);
        perGrid.add(pfName, 1, 2);
        perGrid.add(pAddress, 1, 3);
        perGrid.add(pPhone, 1, 4);
        perGrid.add(pEmail, 1, 5);
        perGrid.add(txtName, 3, 2);
        perGrid.add(txtAddress, 3, 3);
        perGrid.add(txtPhone, 3, 4);
        perGrid.add(txtEmail, 3, 5);
        perGrid.add(addPerson,4,5);
        perGrid.setLayoutX(800);
        addPerson.setOnAction(event -> {
            addPerson();
        });
        return perGrid;
    }


    public void addToList() {

        boolean checked = false;
        boolean n,v,c,r;
        if (chkmale.isSelected()) {
            checked = true;
        } else
            checked = false;


        if (neut.isSelected()) {

           n = true;
        } else
            n = false;

        if (reserv.isSelected()) {
            r = true;
        } else
            r = false;

        if (chip.isSelected()){
            c = true;
        }else
            c = false;

        if (vacc.isSelected()){
            v = true;
        }else
            v = false;

        Animal animal = new Animal(cmbAge.getValue(), cmbTypes.getValue(), checked, cmbBreeds.getValue(), animalDescription.getText(), tfAnimalName.getText());
        adoption = new Adoption(datePicker.getValue(),c,n,v,r,cmbStatus.getValue());
        animal.setAdoption(adoption);

        animalT.getItems().add(animal);

        animalList.addAnimal(animal);
        animalDescription.clear();
        tfAnimalName.clear();


    }

    public void addToPersonInterested() {
        Person person = new Person(txtName.getText(), txtAddress.getText(), txtPhone.getText(), txtEmail.getText());

            personT.getItems().add(person);
            personList.addPerson(person);
            txtName.clear();
            txtAddress.clear();
            txtPhone.clear();
            txtEmail.clear();

    }

    public HBox hBoxImageButton() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(5, 1, 10, 1));
        hBox.setSpacing(5);
        hBox.getChildren().addAll(addImage);
        return hBox;
    }

    public VBox vBoxImage() {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(imageView(), hBoxImageButton());
        vBox.setLayoutX(500);
        vBox.setLayoutY(30);

        return vBox;
    }


    public  TableView<Animal> animalTable() {


        TableColumn<Animal, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setMinWidth(50);
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Animal, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(120);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Animal, Gender> animalGenderCol = new TableColumn<>("Gender");
        animalGenderCol.setMinWidth(80);
        animalGenderCol.setCellValueFactory(new PropertyValueFactory<>("animalGender"));

        TableColumn<Animal, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Animal, String> breedCol = new TableColumn<>("Breed");
        breedCol.setMinWidth(120);
        breedCol.setCellValueFactory(new PropertyValueFactory<>("breed"));

        TableColumn<Animal, String> descriptionCol = new TableColumn<>("Additional Info");
        descriptionCol.setMinWidth(150);
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Animal, Number> idCol = new TableColumn<>("Animal ID");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Animal, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(120);
        dateCol.setCellValueFactory(cellData -> {
            return new ReadOnlyStringWrapper((cellData.getValue().getAdoption()).getDate().toString());
        });

        TableColumn<Animal, Gender> netuter = new TableColumn<>("Neutered");
        netuter.setMinWidth(50);
        netuter.setCellValueFactory(cellData -> {
            return new ReadOnlyObjectWrapper(((Adoption) cellData.getValue().getAdoption()).getnutered());
        });

        TableColumn<Animal, Gender> chi = new TableColumn<>("Chipped");
        chi.setMinWidth(50);
        chi.setCellValueFactory(cellData -> {
            return new ReadOnlyObjectWrapper(((Adoption) cellData.getValue().getAdoption()).getChip());
        });

        TableColumn<Animal, Gender> res = new TableColumn<>("Reserved");
        res.setMinWidth(50);
        res.setCellValueFactory(cellData -> {
            return new ReadOnlyObjectWrapper(((Adoption) cellData.getValue().getAdoption()).getRes());
        });

        TableColumn<Animal, Gender> vac = new TableColumn<>("Vaccinated");
        vac.setMinWidth(50);
        vac.setCellValueFactory(cellData -> {
            return new ReadOnlyObjectWrapper(((Adoption) cellData.getValue().getAdoption()).getVac());
        });

        TableColumn<Animal, String> stat = new TableColumn<>("Status");
        stat.setMinWidth(80);
        stat.setCellValueFactory(cellData -> {
            return new ReadOnlyStringWrapper(((Adoption) cellData.getValue().getAdoption()).getStatus());
        });

        animalT = new TableView<Animal>();

        animalT.getColumns().addAll(idCol, nameCol, ageCol, typeCol, animalGenderCol, breedCol, descriptionCol, stat,dateCol,netuter,chi,res,vac);

        animalT.setLayoutY(460);
        animalT.setLayoutX(20);
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
        aDescription = new Label("Additional Info");

        tfAnimalName = new TextField();
        tfAnimalName.setMaxWidth(150);
        cmbAge.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
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

        gridPane.add(aDescription, 1, 11);
        gridPane.add(animalDescription, 1, 12, 2, 2);

        gridPane.setLayoutX(50);


        return gridPane;
    }

    public GridPane animalGrid2() {

        GridPane gridPane = new GridPane();
        aStatus = new Label("Status");
        cmbStatus.setPrefWidth(120);
        gridPane.setPadding(new Insets(20, 0, 20, 20));
        gridPane.setHgap(8);
        gridPane.setVgap(25);
        reserv = new RadioButton("Reserved");
        chip = new RadioButton("Chipped");
        vacc = new RadioButton("Vaccinated");
        neut = new RadioButton("Neutered");
        gridPane.add(reserv, 1, 1);
        gridPane.add(chip, 1, 2);
        gridPane.add(vacc, 1, 3);
        gridPane.add(neut, 1, 4);
        gridPane.add(aStatus,1,5);
        gridPane.add(cmbStatus,2,5);
        gridPane.setLayoutX(480);
        gridPane.setLayoutY(20);
        return gridPane;
    }

    public VBox animalVBox() {
        VBox vBox = new VBox();
        disAnimal = new Button("Display Animals");
        addAnimal = new Button("Add to System");
        disAnimal.setPrefWidth(100);
        addAnimal.setPrefWidth(100);
        disAnimal.setPadding(new Insets(5));
        addAnimal.setPadding(new Insets(5));
        vBox.getChildren().addAll(disAnimal, addAnimal);
        vBox.setPrefWidth(110);
        vBox.setSpacing(10);
        vBox.setLayoutX(400);
        vBox.setLayoutY(320);

        addAnimal.setOnAction(event -> {
            saveToList();
        });

        disAnimal.setOnAction(event -> {
            animalT.setItems(loadSerializedAnimal());
        });

        return vBox;
    }

    public HBox personHbox(){
        SerializationClass serial = new SerializationClass();
        HBox hBox = new HBox();
        hBox.setSpacing(5);
        disPerson = new Button("Display Person");
        savPerson = new Button("Save Person");
        disPerson.setPrefWidth(100);
        savPerson.setPrefWidth(100);
        hBox.getChildren().addAll(disPerson, savPerson);
        hBox.setLayoutX(1060);
        hBox.setLayoutY(260);

        disPerson.setOnAction(event -> {
            personT.setItems(loadSerializedPerson());
        });

        savPerson.setOnAction(event -> {
            serial.serializePersonAdoptionList(personList);
        });

        return hBox;
    }

    public void saveToList() {
        if (isInputValid()) {
            addToList();
        }

    }

    public void addPerson(){
        if (isPersonValid()){
            addToPersonInterested();
        }

    }

    public boolean isPersonValid() {
        String errorMessage = "";
        if (txtName.getText() == null || txtName.getText().length() == 0) {
            errorMessage += "Enter name for Person!\n";
        }

        if (txtAddress.getText() == null || txtAddress.getText().length() == 0) {
            errorMessage += "Enter the person's address!\n";
        }

        if (txtPhone.getText() == null || txtPhone.getText().length() == 0) {
            errorMessage += "Enter the person's phone number!\n";
        }


         else
            try {
                Integer.parseInt(txtPhone.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid number entered for phone (must be an interger)";
            }

        if (txtEmail.getText() == null || txtEmail.getText().length() == 0) {
            errorMessage += "Enter the person's email address!\n";
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

    private boolean isInputValid() {
        String errorMessage = "";

        //Validate the animal input for the animal lost constructor
        //before adding to the animal table and animal list.

        if (cmbAge.getValue() == null || cmbAge.getValue() == 0) {
            errorMessage += "Age not entered\n";
        }

        if (cmbTypes.getValue() == null || cmbTypes.getValue().length() == 0) {
            errorMessage += "Type of animal not entered!\n";
        }
        // if (cmbGender.getValue() == null || cmbGender.getValue().length() == 0) {
        //  errorMessage += "Enter gender!\n";
        //}

        if (aName.getText() == null || aName.getText().length() == 0) {
            errorMessage += "Enter name for animal!\n";
        }

        if (cmbBreeds.getValue() == null || cmbBreeds.getValue().length() == 0) {
            errorMessage += "Please Select breed!\n";
        }

        if (animalDescription.getText() == null || animalDescription.getText().length() == 0) {
            errorMessage += "Enter description value!\n";
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

    public GridPane forImage() {
        GridPane imageGrid = new GridPane();
        imageGrid.setVgap(20);
        imageGrid.setHgap(20);
        Label imageHeader = new Label("Image View");
        imageGrid.add(imageHeader, 1, 1);
        imageGrid.add(imageView(), 1, 2, 5, 5);
        imageGrid.setLayoutX(850);
        imageGrid.setLayoutY(10);

        return imageGrid;
    }

    public VBox imageSetBtn() {
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
        anchorPane.getChildren().addAll(animalGrid(), animalGrid2(), animalTable(), personGrid(), animalVBox(), personTable(), personHbox());
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
        file.getItems().addAll(saveToFile, loadFile, serialze);
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
            new FoundUI();
            stage.close();
        });

        adopt.setOnAction(event -> {

        });
        btnMain.setOnAction(event -> {
            new MaintenanceUI();
            stage.close();
        });

        saveToFile.setOnAction(event -> {
            serial.serializeAnimalAdoptionList(animalList);


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
