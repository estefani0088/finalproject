import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GenerateProfileButton extends HBox {
    private Button submit, clear;
    VBox vBox2;
    static Label nameSet;
    ImageView profImg;
    ColorPicker colorPicker1;
    private Stage newWindow;
    Scene secondScene;
    HBox hBox1,hboxToggle,hBox2,hBox3,hbox4;
    Button darkmodeButton,lightModeButton,back;

    public GenerateProfileButton() {
        submit = new Button ("generate profile");
        submit.setOnAction(this::processSubmit);


    }

    private Name nameComponent;

    public void GenerateProfile(Name nameComponent) {
        this.nameComponent = nameComponent;

        submit = new Button("Generate Profile");
        submit.setOnAction(this::processSubmit);

        clear = new Button("Clear Form");
        clear.setOnAction(this::processClear);

        HBox subBox = new HBox(submit, clear);
        subBox.setPadding(new Insets(15, 15, 15, 25));
        subBox.setSpacing(10);

        getChildren().addAll(subBox);
    }

    private void processClear(ActionEvent event) {
        // Implement clear logic here
    }

    private void processSubmit(ActionEvent event) {
        String userName = nameComponent.getName();

        Label nameSet = new Label();
        nameSet.setText(userName);

        ImageView profImg = new ImageView(); // Assuming you have an image to display
        VBox vbox2 = new VBox(nameSet, profImg);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setStyle("-fx-background-color: Yellow");

        ScrollPane root2 = new ScrollPane(vbox2);
        Scene secondScene = new Scene(root2, 900, 600);

        Stage newWindow = new Stage();
        newWindow.setTitle("Profile Window for " + userName);
        newWindow.setScene(secondScene);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.show();
    }
}
