import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ColorPick extends HBox {
    // Variables
    public static ColorPicker accentColor;
    Paint newColor;

    public ColorPick() {
        Label accentLabel = new Label("Choose an accent Color");

        accentColor = new ColorPicker(Color.PINK);

        // Action method to change accent color.
        accentColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Color newColor = accentColor.getValue();
                accentLabel.setTextFill(newColor);
                String rgbCode = toRGBCode(newColor);
                setStyle("-fx-background-color: #" + rgbCode + ";");
            }

            private String toRGBCode(Color newColor) {
                return String.format("%02X%02X%02X",
                        (int) (newColor.getRed() * 255),
                        (int) (newColor.getGreen() * 255),
                        (int) (newColor.getBlue() * 255));
            }
        });

        HBox box = new HBox(accentLabel, accentColor);
        box.setPadding(new Insets(15, 15, 15, 25));
        box.setSpacing(10);

        getChildren().addAll(box);
    }

    // Creating method to get the selected accent color
    public Color getAccentColor() {
        return accentColor.getValue();
    }
}
