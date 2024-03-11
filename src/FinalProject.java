import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinalProject<Education> extends Application {

    public static Font selectedFont;

    private ComboBox<String> fontComboBox;

    @Override
    public void start(Stage primaryStage) {

        Name name0 = new Name();
        name0.setAlignment(Pos.CENTER);

        Picture picture0 = new Picture();
        picture0.setAlignment(Pos.CENTER);

        Birthday birthday0 = new Birthday();
        birthday0.setAlignment(Pos.CENTER);
        
        Bio bio = new Bio();
        bio.setAlignment(Pos.CENTER);

        ColorPick accent = new ColorPick();
        accent.setAlignment(Pos.CENTER);

        // Creating font selection box
        ObservableList<String>font;
        ComboBox<String>fontComboBox = new ComboBox<>();
        fontComboBox.setTranslateX(300);
        String fontFamilies = null;
        fontComboBox.getItems().addAll(fontFamilies);
        fontComboBox.getSelectionModel().selectFirst();
        fontComboBox.setOnAction(event -> {

            // Set the selected font
            selectedFont = Font.font(fontComboBox.getValue(), 14);
            setFontForLabels(selectedFont);
        });

        VBox root = new VBox(name0, picture0, birthday0, bio, accent, fontComboBox);

        Scene scene = new Scene(root, 800, 700);

        primaryStage.setTitle("Final Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public ComboBox<String> getFontComboBox() {
        return fontComboBox;
    }

    public static void setFontForLabels(Font font) {
        Name.setFontLabels(font);
        Birthday.setFontLabels(font);
        Bio.setFontLabels(font);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

