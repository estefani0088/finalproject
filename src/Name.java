import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Name extends HBox {
    private static TextField nameTextField;

    public Name() {
        Label inputLabel = new Label("What's your name?");

        nameTextField = new TextField();
        nameTextField.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 14));
        nameTextField.setPrefWidth(200);
        nameTextField.setAlignment(Pos.BASELINE_LEFT);

        HBox nameBox = new HBox(inputLabel, nameTextField);
        nameBox.setPadding(new Insets(15, 15, 15, 25));
        nameBox.setSpacing(10);

        getChildren().addAll(nameBox);
    }

    public static void setFontLabels(Font font) {
        if (nameTextField != null) {
            nameTextField.setFont(font);
        }
    }

    public String getName() {
        return null;
    }
}

