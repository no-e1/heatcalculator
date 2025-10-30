package ch.iet_gibb.heatcalculatorfx.model;

import ch.iet_gibb.heatcalculatorfx.property.Property;

import java.util.List;

/**
 * Roof By Count berechnung
 * @author Noel Kohn
 *
 * @version 1.0
 *
 * @since 21.08.2025
 */

public class RoofSolarSystemByCount extends HeatContainer {

    /** Anzahl der Panele per Reihe */
    private int panelsPerRow;
    /** Anzahl der Reihen */
    private int countedRows;
    /** Leistung eines Panels */

    public RoofSolarSystemByCount(int panelsPerRow, double sunHours, double panelPower, int countedRows) {
        super(sunHours,panelPower);
        this.setPanelsPerRow(panelsPerRow);
        this.setPanelPower(panelPower);
        this.setCountedRows(countedRows);
    }

    public int getCountedRows() {
        return countedRows;
    }

    public int getPanelsPerRow() {
        return panelsPerRow;
    }

    public void setPanelsPerRow(int panelsPerRow) {
        if(panelsPerRow>0){
            this.panelsPerRow = panelsPerRow;
        }else{
            throw new IllegalArgumentException("The amout of panels per row must be more than 0.");
        }
    }

    public void setCountedRows(int countedRows) {
        if(countedRows>0){
            this.countedRows = countedRows;
        }else{
            throw new IllegalArgumentException("The amout of counted rows must be more than 0.");
        }
    }


    public int getCount(){
        int panelsOnRoof = (int) (countedRows * panelsPerRow);
        return panelsOnRoof;
    }

    @Override
    public String toString() {

        String superToString = super.toString();

        return "RoofSolarSystemByCount{" +
                "\npanelsPerRow=" + panelsPerRow +
                "\ncountedRows=" + countedRows +
                "\ngetCount=" + getCount() +
                "\n" + superToString +
                '}';
    }

    @Override
    public String getEtiquette() {
        String roofresult = "----------------------------------" +
                "\n" + toString();
        return roofresult;
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        Property panelsPerRow = new Property("Panels pro Reihe:", Integer.toString(getPanelsPerRow()));
        properties.add(panelsPerRow);
        Property countedRows = new Property("Anzahl Reihen:", Integer.toString(getCountedRows()));
        properties.add(countedRows);
        Property getCount = new Property("Anzahl Panels:", Integer.toString(getCount()));
        properties.add(getCount);
        return properties;
    }
}
