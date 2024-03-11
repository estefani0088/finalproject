import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Birthday extends HBox {
    static Text message;
    DatePicker datePicker;
     static Image image1;
    LocalDate birthDate, current;
    private Map<Integer, String> monthImg = new HashMap<>();

    public Birthday() {
        Label bdayLabel = new Label("Choose your birthday");

        message = new Text();
        message.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 14));

        datePicker = new DatePicker(LocalDate.now());
        datePicker.setOnAction(this::processDateChoice);

        initializeMonthImg();

        HBox bdayBox = new HBox(bdayLabel, datePicker);
        bdayBox.setPadding(new Insets(15, 15, 15, 25));
        bdayBox.setSpacing(10);

        getChildren().addAll(bdayBox);
    }

    public static void setFontLabels(Font font) {
    }

    private void initializeMonthImg() {
        monthImg.put(1, "Aquarius");
        monthImg.put(2, "Pisces");
        monthImg.put(3, "Aries");
        monthImg.put(4, "Taurus");
        monthImg.put(5, "Gemini");
        monthImg.put(6, "Cancer");
        monthImg.put(7, "Leo");
        monthImg.put(8, "Virgo");
        monthImg.put(9, "Libra");
        monthImg.put(10, "Scorpio");
        monthImg.put(11, "Sagittarius");
        monthImg.put(12, "Capricorn");
    }

    private void generatePortfolio (int birthMonth){
        VBox portfolioLayout = new VBox(10);
        portfolioLayout.setPadding(new Insets(20));

        //create imageview.
        ImageView imageView = new ImageView(image1);
        imageView.setSmooth(true);
        imageView.setCache(true);

        portfolioLayout.getChildren().addAll(message,new
                Label ("Sign: "+ monthImg.get(birthMonth)), imageView);
    }

    private void processDateChoice(ActionEvent event) {
        birthDate = datePicker.getValue();
        current = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthDate, current);
        int month = birthDate.getMonthValue();
        int day = birthDate.getDayOfMonth();
        message.setText("Age: " + age + " years");

        if (month == 12) {
            if (day < 21) {
                image1 = new Image("images/Sagittarius.png");
            } else {
                image1 = new Image("images/Capricorn.png");
            }
        } else if (month == 1) {
            if (day < 20) {
                image1 = new Image("images/Capricorn.png");
            } else {
                image1 = new Image("images/Aquarius.png");
            }
        } else if (month == 2) {
            if (day < 22) {
                image1 = new Image("images/Aquarius.png");
            } else {
                image1 = new Image("images/Pisces.png");
            }
        } else if (month == 3) {
            if (day < 20) {
                image1 = new Image("images/Pisces.png");
            } else {
                image1 = new Image("images/Aries.png");
            }
        } else if (month == 4) {
            if (day < 19) {
                image1 = new Image("images/Aries.png");
            } else {
                image1 = new Image("images/Taurus.png");
            }
        } else if (month == 5) {
            if (day < 18) {
                image1 = new Image("images/Taurus.png");
            } else {
                image1 = new Image("images/Gemini.png");
            }
        } else if (month == 6) {
            if (day < 17) {
                image1 = new Image("images/Gemini.png");
            } else {
                image1 = new Image("images/Cancer.png");
            }
        } else if (month == 7) {
            if (day < 17) {
                image1 = new Image("images/Cancer.png");
            } else {
                image1 = new Image("images/Leo.png");
            }
        } else if (month == 8) {
            if (day < 16) {
                image1 = new Image("images/Leo.png");
            } else {
                image1 = new Image("images/Virgo.png");
            }
        } else if (month == 9) {
            if (day < 16) {
                image1 = new Image("images/Virgo.png");
            } else {
                image1 = new Image("images/Libra.png");
            }
        } else if (month == 10) {
            if (day < 15) {
                image1 = new Image("images/Libra.png");
            } else {
                image1 = new Image("images/Scorpio.png");
            }
        } else if (month == 11) {
            if (day < 17) {
                image1 = new Image("images/Scorpio.png");
            } else {
                image1 = new Image("images/Sagittarius.png");
            }
        }


        ImageView imageView = new ImageView(image1);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        VBox portfolioLayout = new VBox(10);
        portfolioLayout.setPadding(new Insets(20));
        portfolioLayout.getChildren().addAll(message, new Label("Sign: " + monthImg.get(month)), imageView);

        // Replace current content with new content
        getChildren().clear();
        getChildren().add(portfolioLayout);
    }
}





