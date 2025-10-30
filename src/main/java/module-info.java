module ch.iet_gibb.heatcalculatorfx.application {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires ch.iet_gibb.heatcalculatorfx.application;

    opens ch.iet_gibb.heatcalculatorfx.application to javafx.fxml;
    exports ch.iet_gibb.heatcalculatorfx.application;
}