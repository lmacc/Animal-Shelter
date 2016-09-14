package mainApplication;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    private Label lost = new Label("Lost Section");
    private Label found = new Label("Found Section");
    private Label adoption = new Label("Adoption Section");
    private Label maintain = new Label("Maintenance Section");
    private Button btnLost, btnFound,btnAdopt,btnMain;



    public BorderPane borderPane() {
        BorderPane root = new BorderPane();


        MenuBar mainMenu = new MenuBar();  //Creates our main menu to hold  Sub-Menus.
        //Declare sub-menus and add to main menu.

        Menu about = new Menu("About");
        MenuItem aboutThis = new MenuItem("Application Menu Selection");
        about.getItems().add(aboutThis);
        mainMenu.getMenus().addAll( about);

        root.setTop(mainMenu);
        root.setCenter(menuAnchor());


        return root;
    }

    public AnchorPane menuAnchor(){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(gridSelection());

        return anchorPane;
    }

    public GridPane gridSelection(){
        Label menuInfo = new Label("Make a selection from the menu ");
        GridPane selection = new GridPane();
        selection.setPadding(new Insets(20, 20, 20, 20));
        selection.setHgap(8);
        selection.setVgap(15);
        btnLost = new Button("Select");
        btnLost.setPrefWidth(80);
        btnFound = new Button("Select");
        btnFound.setPrefWidth(80);
        btnAdopt = new Button("Select");
        btnAdopt.setPrefWidth(80);
        btnMain = new Button("Select");
        btnMain.setPrefWidth(80);
        selection.add(menuInfo,3,1,1,2);
        selection.add(lost,2,4); selection.add(btnLost,4,4);
        selection.add(found,2,6); selection.add(btnFound,4,6);
        selection.add(adoption,2,8); selection.add(btnAdopt,4,8);
        selection.add(maintain,2,10); selection.add(btnMain,4,10);
        selection.setLayoutX(70);
        selection.setLayoutY(30);

        btnLost.setOnAction(event -> {
            new LostUI();
        });

        btnFound.setOnAction(event -> {
            new FoundUI();
        });

        btnAdopt.setOnAction(event -> {
            new AdoptionUI();
        });

        btnMain.setOnAction(event -> {
            new MaintenanceUI();
        });


        return selection;
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle2D display = Screen.getPrimary().getVisualBounds();
        primaryStage.setTitle("Menu");


        Scene scene = new Scene(borderPane(),600,400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

}
