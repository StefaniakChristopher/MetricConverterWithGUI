module com.metricconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.metricconverter to javafx.fxml;
    exports com.metricconverter;
}
