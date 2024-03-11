import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bio extends HBox {
    private static Text content;

    public Bio() {
        Label bioLabel = new Label("Biography");
        Label noBio = new Label();

        content = new Text("");
        content.getStyleClass().add("text-style");
        content.setWrappingWidth(850);
        content.setTextAlignment(TextAlignment.CENTER);
        content.setTranslateX(50);
        content.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 14));

        Button uploadBio = new Button("Upload Biography");
        uploadBio.setAlignment(Pos.BASELINE_LEFT);

        uploadBio.setOnAction(event -> {
            FileChooser bioChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilterTXT = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.TXT");
            bioChooser.getExtensionFilters().addAll(extFilterTXT);
            File selectedBio = bioChooser.showOpenDialog(null);

            if (selectedBio != null) {
                try {
                    Scanner scan = new Scanner(selectedBio);
                    StringBuilder info = new StringBuilder();
                    while (scan.hasNextLine()) {
                        info.append(scan.nextLine()).append("\n");
                    }
                    content.setText(info.toString());
                    noBio.setText(selectedBio.getAbsolutePath());
                } catch (FileNotFoundException e) {
                    e.printStackTrace(); // Handle exception gracefully
                }
            }
        });

        HBox bioBox = new HBox(bioLabel, uploadBio, noBio);
        bioBox.setPadding(new Insets(15, 15, 15, 25));
        bioBox.setSpacing(10);

        getChildren().addAll(bioBox);
    }

    public static void setFontLabels(Font font) {
        if (content != null) {
            content.setFont(font);
        }
    }
}