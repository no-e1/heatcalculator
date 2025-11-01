package ch.iet_gibb.heatcalculatorfx.controller;

import ch.iet_gibb.heatcalculatorfx.model.HeatContainer;
import ch.iet_gibb.heatcalculatorfx.view.HeatView;
import ch.iet_gibb.heatcalculatorfx.view.AlternativeHeatView;
import javafx.event.ActionEvent;

import java.util.List;

public class HeatController implements javafx.event.EventHandler<ActionEvent> {


    protected List<HeatContainer> models;
    protected ControllerViewInterface view;
    protected int currentRoof=0;

    public HeatController(List<HeatContainer> models) {
        this.models = models;
    }

    public void setView(ControllerViewInterface view){
        this.view=view;
    }

    public void startView(){
        view.startView(models.get(currentRoof));
    }

    public void showNextRoof(){
        //erhöht die Zahl currentRoof um eins, sofern man nicht am Ende der Liste ist
        if(currentRoof < models.size()-1) {
            currentRoof ++;
        }else{
            currentRoof = 0;
        }
        view.startView(models.get(currentRoof));
    }

    public String getRoof(){
        //greift auf die Liste zu, spricht das Element currentRoof an und ruft auf diesem Objekt die toSTring Mehtode auf
        return models.get(currentRoof).toString();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        showNextRoof();
    }
}