package ch.iet_gibb.heatcalculatorfx.model;


import ch.iet_gibb.heatcalculatorfx.property.Property;

import java.util.List;

public interface InterfaceRoof {
    /**
     * Gibt den Titel der Etikette zurück
     * @return
     */
    String getTitle();

    /**
     * Gibt die Angaben der Etikette zurück
     * @return
     */
    List<Property> getProperties();
}
