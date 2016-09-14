package mainApplication;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by leslie on 17/04/2016.
 */
public class PersonUI  implements Initializable {

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
    // Buttons
    Button saveBtn = new Button("Save");
    Button closeBtn = new Button("Close");
    // Date format
    String dateFormat;

    public PersonUI(){
        Stage stage = new Stage();
        stage.setTitle("Person Details");

        Scene scene = new Scene(personGrid(), 800, 400);
        stage.setScene(scene);
        stage.show();


    }

    public GridPane personGrid(){
        GridPane personDetail = new GridPane();

        personDetail.setHgap(5);
        personDetail.setVgap(5);
        personDetail.add(personIdLbl, 1, 1);
        personDetail.add(fNameLbl, 1, 2);
        personDetail.add(lNameLbl, 1, 3);
        personDetail.add(bDateLbl, 1, 4);
        personDetail.add(ageCategoryLbl, 1, 5);

        personDetail.add(personIdFld, 2, 1);
        personDetail.add(fNameFld, 2, 2);
        personDetail.add(lNameFld, 2, 3);
        personDetail.add(bDateFld, 2, 4);
        personDetail.add(ageCategoryFld, 2, 5);
// Add buttons and make them the same width
        VBox buttonBox = new VBox(saveBtn, closeBtn);
        saveBtn.setMaxWidth(Double.MAX_VALUE);
        closeBtn.setMaxWidth(Double.MAX_VALUE);
        personDetail.add(buttonBox, 3, 1, 1, 5);


        return personDetail;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
