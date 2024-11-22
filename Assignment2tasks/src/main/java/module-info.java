module com.example.assignment2tasks {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.net.http;
    requires java.desktop;
    requires kotlin.stdlib;

    requires jdk.javadoc;
    requires org.json;

    opens com.example.assignment2tasks to javafx.fxml;
    exports com.example.assignment2tasks;
}