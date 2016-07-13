package edu.uchicago.umairmustafa;

import edu.uchicago.umairmustafa.amadeus.AirportFinder;
import edu.uchicago.umairmustafa.amadeus.AirportResult;
import edu.uchicago.umairmustafa.skyscanner.Flight;
import edu.uchicago.umairmustafa.skyscanner.FlightFinder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FlightController implements Initializable
{

    @FXML private TextField txtSource;
    @FXML private TextField txtDestination;
    @FXML private Button btnGo;
    @FXML private ListView<String> lstView;
    @FXML private ContextMenu sourceContextMenu;
    @FXML private ContextMenu destinationContextMenu;

    private List<Flight> flightList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final Service flightFinder = new Service<ObservableList<String>>() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected ObservableList<String> call() throws Exception {
                        String source = "DCA";//txtSource.getText();
                        String destination = "ORD";//txtDestination.getText();

                        Date date = new Date();
                        Calendar c = Calendar.getInstance();
                        c.setTime(date);
                        c.add(Calendar.DATE, 1);
                        date = c.getTime();
                        String strDate = "2016-07-20";//new SimpleDateFormat("yyyy-MM-dd").format(date);
                        String endDate = "2016-07-21";
                        String numOfAdults = "1";

                        FlightFinder finder = new FlightFinder(source, destination, strDate, endDate, numOfAdults);

                        flightList = finder.getFlightList()
                                .stream()
                                .sorted((f1, f2) -> (int)(f1.getFare() - f2.getFare()))
                                .limit(10)
                                .collect(Collectors.toList());

                        final AtomicInteger count = new AtomicInteger();
                        count.getAndIncrement();

                        List<String> strFlightList = flightList
                                .stream()
                                .map(flight -> count.getAndIncrement() + ". " + flight.toString())
                                .collect(Collectors.toList());
                        return FXCollections.observableArrayList(strFlightList);
                    }
                };
            }
        };

        btnGo.disableProperty().bind(flightFinder.runningProperty());
        lstView.itemsProperty().bind(flightFinder.valueProperty());

        txtSource.textProperty().addListener((observableValue, oldValue, newValue) -> {populateMenuItems(txtSource, sourceContextMenu);});
        txtDestination.textProperty().addListener((observableValue, oldValue, newValue) -> {populateMenuItems(txtDestination, destinationContextMenu);});

        btnGo.setOnAction(e -> {
            if(!flightFinder.isRunning()){
                flightFinder.reset();
                flightFinder.start();
            };
        });

        lstView.setOnMouseClicked(e ->{
            try{
                if (!(e.getTarget() instanceof Text)) return;

                String strClicked = ((Text)e.getTarget()).getText().toString();
                int index = Integer.parseInt(strClicked.substring(0, strClicked.indexOf('.'))) - 1;
                openWebpage(new URI(flightList.get(index).getBookingURL()));

            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
    }

    public void populateMenuItems(TextField txtField, ContextMenu contextMenu){
        if(txtField.getText().length() == 0){
            contextMenu.hide();
        }else
        {
            if(AirportFinder.findAirports(txtField.getText()).length > 0){
                List<CustomMenuItem> menuItems = new LinkedList<>();
                for (AirportResult airportResult : AirportFinder.findAirports(txtField.getText())) {
                    CustomMenuItem item = new CustomMenuItem(new Label(airportResult.getLabel()),true);
                    item.setOnAction(actionEvent -> {
                        contextMenu.hide();
                        txtField.setText(airportResult.getValue());
                    });
                    menuItems.add(item);
                }
                contextMenu.getItems().clear();
                contextMenu.getItems().addAll(menuItems);
                if(!contextMenu.isShowing()){
                    contextMenu.show(txtField, Side.BOTTOM,0,0);
                }
            }else
                contextMenu.hide();
        }
    }

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
