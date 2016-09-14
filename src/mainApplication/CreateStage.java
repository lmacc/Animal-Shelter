package mainApplication;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Person;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by leslie on 25/03/2016.
 */
public class CreateStage implements Initializable {
Main p;
    // Labels
    GridPane gridPane,gridPane2;
    Label personIdLbl = new Label("Person Id:");
    Label fNameLbl = new Label("First Name:");
    Label lNameLbl = new Label("Last Name:");
    Label bDateLbl = new Label("Birth Date:");
    Label ageCategoryLbl = new Label("Age Category:");
    // Fields
    TextField personIdFld = new TextField();
    TextField fNameFld = new TextField();
    TextField lNameFld = new TextField();
    TextField bDateFld = new TextField();
    TextField ageCategoryFld = new TextField();

    Label personIdLbl1 = new Label("Animal Id:");
    Label fNameLbl1 = new Label("Animla Name:");
    Label lNameLbl1 = new Label("LastAnimal Name:");
    Label bDateLbl1 = new Label("Birth AnimalDate:");
    Label ageCategoryLbl1 = new Label("AgeAnimal Category:");
    // Fields
    TextField personIdFld1 = new TextField();
    TextField fNameFld1 = new TextField();
    TextField lNameFld1 = new TextField();
    TextField bDateFld1 = new TextField();
    TextField ageCategoryFld1 = new TextField();
    // Buttons
    Button saveBtn = new Button("Save");
    Button closeBtn = new Button("Close");
    Button saveBtn1 = new Button("Save");
    Button closeBtn1 = new Button("Close");
    Scene scene;
    Controller cn = new Controller();
    Button openFileBtn = new Button();

    Button snapshotBtn = new Button();
    Button printBtn = new Button();

    public CreateStage(){

        Stage stage = new Stage();
        stage.setTitle("the second stage");

        BorderPane root = new BorderPane();
        VBox topContainer = new VBox();  //Creates a container to hold all Menu Objects.
        MenuBar mainMenu = new MenuBar();  //Creates our main menu to hold our Sub-Menus.
        //Declare sub-menus and add to main menu.
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");
        mainMenu.getMenus().addAll(file, edit, help);

        ToolBar toolBar = new ToolBar();  //Creates our tool-bar to hold the buttons.
        topContainer.getChildren().addAll(mainMenu,toolBar);
        AnchorPane anchorPane = new AnchorPane();
        gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(personIdLbl, 1, 1);
        gridPane.add(fNameLbl, 1, 2);
        gridPane.add(lNameLbl, 1, 3);
        gridPane.add(bDateLbl, 1, 4);
        gridPane.add(ageCategoryLbl, 1, 5);
        gridPane.add(personIdFld, 2, 1);
        gridPane.add(fNameFld, 2, 2);
        gridPane.add(lNameFld, 2, 3);
        gridPane.add(bDateFld, 2, 4);
        gridPane.add(ageCategoryFld, 2, 5);
// Add buttons and make them the same width
        VBox buttonBox = new VBox(saveBtn, closeBtn);
        saveBtn.setMaxWidth(Double.MAX_VALUE);
        closeBtn.setMaxWidth(Double.MAX_VALUE);
        gridPane.add(buttonBox, 3, 1, 1, 5);
// Disable the personId field
        personIdFld.setDisable(true);
        ageCategoryFld.setDisable(true);

        gridPane2 = new GridPane();
        gridPane2.setHgap(5);
        gridPane2.setVgap(5);
        gridPane2.add(personIdLbl1, 1, 1);
        gridPane2.add(fNameLbl1, 1, 2);
        gridPane2.add(lNameLbl1, 1, 3);
        gridPane2.add(bDateLbl1, 1, 4);
        gridPane2.add(ageCategoryLbl1, 1, 5);
        gridPane2.add(personIdFld1, 2, 1);
        gridPane2.add(fNameFld1, 2, 2);
        gridPane2.add(lNameFld1, 2, 3);
        gridPane2.add(bDateFld1, 2, 4);
        gridPane2.add(ageCategoryFld1, 2, 5);
// Add buttons and make them the same width
        VBox buttonBox1 = new VBox(saveBtn1, closeBtn1);
        saveBtn1.setMaxWidth(Double.MAX_VALUE);
        closeBtn1.setMaxWidth(Double.MAX_VALUE);
        gridPane2.add(buttonBox1, 3, 1, 1, 5);
// Disable the personId field
        personIdFld.setDisable(true);
        ageCategoryFld.setDisable(true);

        //
        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);

        anchorPane.getChildren().addAll(gridPane,gridPane2,hb);

      //  AnchorPane.setBottomAnchor(, 8.0);
        AnchorPane.setRightAnchor(gridPane2, 20.0);
        AnchorPane.setTopAnchor(gridPane, 0.0);
        root.setCenter(anchorPane);

        toolBar.getItems().addAll(openFileBtn, printBtn, snapshotBtn);
        openFileBtn.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

            public void handle(javafx.event.ActionEvent event) {
              //// TODO: 15/04/2016
            }
        });


        root.setTop(topContainer);
        Scene scene = new Scene(root, 800, 400);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
