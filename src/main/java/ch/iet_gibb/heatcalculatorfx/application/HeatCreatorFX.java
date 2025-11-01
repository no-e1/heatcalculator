package ch.iet_gibb.heatcalculatorfx.application;


import ch.iet_gibb.heatcalculatorfx.controller.HeatController;
import ch.iet_gibb.heatcalculatorfx.model.HeatContainer;
import ch.iet_gibb.heatcalculatorfx.model.RoofSolarSystemByArea;
import ch.iet_gibb.heatcalculatorfx.model.RoofSolarSystemByCount;
import ch.iet_gibb.heatcalculatorfx.model.SolarSystemOnSlope;
import ch.iet_gibb.heatcalculatorfx.view.AlternativeHeatView;
import ch.iet_gibb.heatcalculatorfx.view.HeatView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class HeatCreatorFX extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        List<HeatContainer> models = createModels();
        HeatController controller = new HeatController(models);
        HeatView alternativeView = new HeatView(stage, controller); // hier ändern um view zu wechseln: AlternativeHeatView oder HeatView
        HeatView view = new HeatView(stage, controller);
        controller.setView(alternativeView);
        controller.startView();
    }

    protected List<HeatContainer> createModels(){
        ArrayList<HeatContainer> labels = new ArrayList<>();
        HeatContainer roof = new RoofSolarSystemByArea(3000, 10, 5, 0.7, 4, 3);
        labels.add(roof);
        roof = new RoofSolarSystemByCount(6,3333, 1.4, 2);
        labels.add(roof);
        roof = new SolarSystemOnSlope(20, 2349, 4, 8, 2);
        labels.add(roof);
        return labels;
    }

}
