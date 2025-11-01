package ch.iet_gibb.heatcalculatorfx.model;

import ch.iet_gibb.heatcalculatorfx.property.Property;

import java.util.List;

/**
 * Slope berechnung
 * @author Noel Kohn
 *
 * @version 1.0
 *
 * @since 21.08.2025
 */

public class SolarSystemOnSlope extends HeatContainer {

    /** Laenge des Hangs */
    private double slopeLength;
    /** Laenge des Panels */
    private double panelLength;
    /** Anzahl Reihen auf dem Hang */
    private int slopeRows;

    public SolarSystemOnSlope(double slopeLength, double sunHours, double panelPower, int slopeRows, double panelLength) {
        super(sunHours,panelPower);
        this.setSlopeLength(slopeLength);
        this.setSlopeRows(slopeRows);
        this.setPanelLength(panelLength);
    }

    public double getSlopeLength() {
        return slopeLength;
    }

    public void setSlopeLength(double slopeLength) {
        if(slopeLength>0){
            this.slopeLength = slopeLength;
        } else {
            throw new IllegalArgumentException("The slope length must be greater than 0.");
        }
    }

    public double getPanelLength() {
        return panelLength;
    }

    public void setPanelLength(double solarPanelLength) {
        if(solarPanelLength > 0){
            this.panelLength = solarPanelLength;
        } else {
            throw new IllegalArgumentException("The panel length must be greater than 0.");
        }
    }

    public int getSlopeRows() {
        return slopeRows;
    }

    public void setSlopeRows(int slopeRows) {
        if(slopeRows>0){
            this.slopeRows = slopeRows;
        }else{
            throw new IllegalArgumentException("The amout of slope rows must be more than 0.");
        }
    }

    public int getCount(){
        int panelsOnSlope = (int) (slopeLength / panelLength) * slopeRows;
        return panelsOnSlope;
    }

    @Override
    public String toString() {

        String superToString = super.toString();

        return "SolarSystemOnSlope{" +
                "\nslopeLength=" + slopeLength +
                "\npanelLength=" + panelLength +
                "\nslopeRows=" + slopeRows +
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
    public String getTitle() {
        return "OnSlope";
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        Property slopeRows = new Property("Anzahl Reihen:", Integer.toString(getSlopeRows()));
        properties.add(slopeRows);
        Property panelLength = new Property("Panellänge:", Double.toString(getPanelLength()));
        properties.add(panelLength);
        Property slopeLength = new Property("Abhanglänge:", Double.toString(getSlopeLength()));
        properties.add(slopeLength);
        return properties;
    }

}

