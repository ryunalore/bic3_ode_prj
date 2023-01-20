package fhtw.trafficmonitor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.IOException;

public class TrafficMonitorApplication extends Application {
    static Logging trafficMonitorLog = trafficMonitorLog = new Logging();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("trafficmonitor.fxml"));
        stage.setTitle("TrafficMonitor HauptMenü");
        stage.setScene(new Scene(root));

        // 2023-01-19: line added. Unfortunately this throws an IllegalArgumentException,
        // but it's used to close all remaining windows besides main window
        stage.setOnHidden(e -> Platform.exit());

        stage.show();
        trafficMonitorLog.logTrafficMonitor("TrafficHauptmenü geöffnet");
    }

    public static void main(String[] args) {
        trafficMonitorLog.logTrafficMonitor("Willkommen! Das Logging beginnt nun für den TrafficMonitor.");


        // modify value to enable/disable debugMode
        int debugMode = 0; // 0=off, 1=on

        if (debugMode == 1) {
            /**
             * demo purpose regarding:
             * 1. send URL request on basis of known 'diva'
             * 2. receive json data
             * 3. parse received json data
             *
             * Note: in class JsonParse you can set debugMode to ON/OFF either to display more information
             */

            /*
            JsonParse jsonSource1 = new JsonParse("60201198", "Schwedenplatz", "U1", "ptMetro");
            System.out.println(jsonSource1.getUrl_source());
            System.out.println(jsonSource1.getJsonInput());
            jsonSource1.getKeyStage1(new JSONObject(jsonSource1.getJsonInput()), "U1", "ptMetro");

             */

            //System.out.println("Retrieve only selected transportType");
            //jsonSource1.getListLines().forEach(System.out::println);
            //System.out.println("Retrieve records: ");
            //jsonSource1.getKeyStage2();
            //System.out.println(jsonSource1.getListLinesLineRecords().get(0).getLineName());
            //jsonSource1.createController(jsonSource1.getListLinesLineRecords());

            /*
            CsvReader ottakring = new CsvReader("Ottakring");
            ottakring.retrieveDiva();
            System.out.println("Haltestelle: " + ottakring.getHaltestellenName() + " hat die diva: " + ottakring.getDiva());
             */

            //CreatePublicTransportLine u4 = new CreatePublicTransportLine("u4");

        } else {
            // launch the GUI
            launch(args);
        }
    }
}