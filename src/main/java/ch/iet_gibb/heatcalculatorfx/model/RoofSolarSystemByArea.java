package ch.iet_gibb.heatcalculatorfx.model;

import ch.iet_gibb.heatcalculatorfx.property.Property;
import java.util.List;
/**
 * Roof By Area berechnung
 * @author Noel Kohn
 *
 * @version 1.0
 *
 * @since 21.08.2025
 */

public class RoofSolarSystemByArea extends HeatContainer {

    /**
     * Laenge des Dachs
     */
    private double roofLength;
    /**
     * Breite des Dachs
     */
    private double roofWidth;
    /**
     * Laenge eines Solarpanels
     */
    private double panelLength;
    /**
     * Breite eines Solarpanels
     */
    private double panelWidth;


    public RoofSolarSystemByArea(double sunHours, double panelPower, double roofWidth, double roofLength, double panelLength, double panelWidth) {
        super(sunHours, panelPower);
        this.setRoofWidth(roofWidth);
        this.setRoofLength(roofLength);
        this.setPanelLength(panelLength);
        this.setPanelWidth(panelWidth);
    }

    public double getPanelWidth() {
        return panelWidth;
    }

    public double getPanelLength() {
        return panelLength;
    }

    public double getRoofLength() {
        return roofLength;
    }

    public double getRoofWidth() {
        return roofWidth;
    }

    public void setPanelWidth(double panelWidth) {
        if (panelWidth > 0) {
            this.panelWidth = panelWidth;
        } else {
            throw new IllegalArgumentException("Panel width must be greater than 0.");
        }
    }

    public void setPanelLength(double panelLength) {
        if (panelLength > 0) {
            this.panelLength = panelLength;
        } else {
            throw new IllegalArgumentException("Panel lenght must be greater than 0.");
        }
    }

    public void setRoofWidth(double roofWidth) {
        if (roofWidth > 0) {
            this.roofWidth = roofWidth;
        } else {
            throw new IllegalArgumentException("Roof width must be greater than 0.");
        }
    }

    public void setRoofLength(double roofLength) {
        if (roofLength > 0) {
            this.roofLength = roofLength;
        } else {
            throw new IllegalArgumentException("Roof length must be greater than 0.");
        }
    }

    public int getCount() {
        int panelsInWidth = (int) (roofWidth / panelWidth);
        int panelsInLength = (int) (roofLength / panelLength);
        return panelsInWidth * panelsInLength;
    }


    @Override
    public String toString() {

        String superToString = super.toString();

        return "RoofSolarSystemByArea{" +
                "\nroofLength=" + roofLength +
                "\nroofWidth=" + roofWidth +
                "\npanelLength=" + panelLength +
                "\npanelWidth=" + panelWidth +
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
        Property roofWidth = new Property("Dachbreite:", Double.toString(getRoofWidth()));
        properties.add(roofWidth);
        Property roofLength = new Property("Dachlänge:", Double.toString(getRoofLength()));
        properties.add(roofLength);
        Property panelWidth = new Property("Panelbreite:", Double.toString(getPanelWidth()));
        properties.add(panelWidth);
        Property panelLength = new Property("Panellänge:", Double.toString(getPanelLength()));
        properties.add(panelLength);
        return properties;
    }

}
