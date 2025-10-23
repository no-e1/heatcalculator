package ch.iet_gibb.heatcalculatorfx.model;

/**
 * Superklasse HeatContainer
 * @author Noel Kohn
 *
 * @version 1.0
 *
 * @since 21.08.2025
 */
public abstract class HeatContainer {

    /** Leistung eines Panels */
    protected double panelPower;
    /** Anzahl Sonnenstunden im Jahr */
    protected double sunHours;

    public HeatContainer(double sunHours, double panelPower) {
        this.setSunHours(sunHours);
        this.setPanelPower(panelPower);
    }


    public double getSunHours() {
        return sunHours;
    }

    public double getPanelPower() {
        return panelPower;
    }

    public void setSunHours(double sunHours) {
        if(sunHours>0){
            this.sunHours = sunHours;
        }else{
            throw new IllegalArgumentException("The amout of sunhours per year must be greater than 0.");
        }
    }

    public void setPanelPower(double panelPower) {
        if(panelPower>0){
            this.panelPower = panelPower;
        }else{
            throw new IllegalArgumentException("The panel must generate more than 0 power.");
        }
    }

    /**
     * Berechnet die gesamte Energieproduktion der Anlage pro Jahr.
     *
     * @return Die jährliche Energieproduktion in kWh.
     */
    public double getPower(){
        double powerPerYear = panelPower * sunHours * getCount();
        return powerPerYear / 1000.0;
    }

    /**
     * Berechnet die durchschnittliche Energieproduktion der Anlage pro Tag.
     *
     * @return Die tägliche Energieproduktion in kWh.
     */
    public double getDailyPower(){
        return getPower() / 365;
    }

    public abstract int getCount();

    @Override
    public String toString() {
        return "panelPower=" + panelPower +
                "\nsunHours=" + sunHours +
                "\ngetPower=" + getPower() + " kWh" +
                "\ndailyPower=" + getDailyPower();
    }

    public abstract String getEtiquette();
}
