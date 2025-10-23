module ch.iet_gibb.heatcalculatorfx.application {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens ch.iet_gibb.heatcalculatorfx.application to javafx.fxml;
    exports ch.iet_gibb.heatcalculatorfx.application;
}