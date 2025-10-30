package ch.iet_gibb.heatcalculatorfx.view;

import ch.iet_gibb.heatcalculatorfx.model.InterfaceRoof;
import ch.iet_gibb.heatcalculatorfx.controller.HeatController;
import ch.iet_gibb.heatcalculatorfx.property.Property;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.TextAlignment;

import ch.iet_gibb.heatcalculatorfx.controller.HeatController;

public class HeatView {
    protected Stage stage;
    protected HeatController controller;


    public HeatView(Stage stage, HeatController controller) {
        this.stage=stage;
        this.controller = controller;
    }


    public void startView(InterfaceRoof data) {
        /* Layout erstellen (https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
            um mehr Informationen über die Layout typen in JavaFX zu erhalten) */
        VBox layout = new VBox();
        // Padding und Abstand zwischen den Elementen setzen
        layout.setPadding(new Insets(15, 15, 15, 15));
        layout.setSpacing(20);
        /* Titel erstellen und dem Layout anfügen */
        Text labelText = new Text();
        labelText.setText("Titel sollte hier stehen");
        labelText.setFont(Font.font ("Tahoma", FontWeight.EXTRA_BOLD, 20));
        labelText.setStyle("-fx-font-family: monospace;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);");
        layout.getChildren().add(labelText);
        /* Eingenschaften erstellen und in einem TilePane Layout anfügen */
        TilePane propertiesPane = new TilePane();
        // Einstellungen, damit nur zwei Spalten dargestellt werden
        propertiesPane.setPrefColumns(2);
        propertiesPane.setMaxWidth(Region.USE_PREF_SIZE);
        for(Property property :data.getProperties()){
            addPropertyToPane(property, propertiesPane);
        }
        layout.getChildren().add(propertiesPane);
        /* Button erstellen und dem Layout anfügen, um zwischen den Labels navigieren zu können */
        Button btnNext;
        btnNext =new Button("→");
        btnNext.setOnAction(controller);
        layout.getChildren().add(btnNext);
        /* Scene erstellen und die View darstellen */
        Scene scene = new Scene(layout, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Fügt Ektikettenangaben in das Pane
     * @param property
     * @param layout
     */
    protected void addPropertyToPane(Property property, Pane layout) {
        Font propertiesFont = Font.font("Tahoma", FontWeight.BOLD, 16);

        // Label mit der Beschriftung erstellen und dem Layout anfügen
        Text keyText = new Text();
        keyText.setText(property.getKey());
        keyText.setFont(propertiesFont);
        //Text wird linksbündig dargestellt
        keyText.setWrappingWidth(200);
        keyText.setTextAlignment(TextAlignment.LEFT);
        layout.getChildren().add(keyText);
        // Label mit dem Wert erstellen und dem Layout anfügen
        Text valueText = new Text();
        valueText.setText(property.getValue());
        valueText.setFont(propertiesFont);
        //Text wird rechtsbündig dargestellt
        valueText.setWrappingWidth(200);
        valueText.setTextAlignment(TextAlignment.RIGHT);
        layout.getChildren().add(valueText);

    }
}