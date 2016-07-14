package edu.uchicago.umairmustafa;

import edu.uchicago.umairmustafa.airports.Airport;
import edu.uchicago.umairmustafa.airports.FileAirportFinder;
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
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    @FXML private DatePicker fromDate;
    @FXML private DatePicker toDate;

    private List<Flight> flightList;
    public final int NUMBER_OF_RESULTS = 5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final Service flightFinder = new Service<ObservableList<String>>() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected ObservableList<String> call() throws Exception {
                        String source = txtSource.getText();
                        String destination = txtDestination.getText();
                        String strDate = fromDate.getValue().toString();
                        String endDate = toDate.getValue().plusDays(1).toString();
                        String numOfAdults = "1";

                        FlightFinder finder = new FlightFinder(source, destination, strDate, endDate, numOfAdults);

                        flightList = finder.getFlightList()
                                .stream()
                                .sorted((f1, f2) -> (int)(f1.getFare() - f2.getFare()))
                                .limit(NUMBER_OF_RESULTS)
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

        lstView.setCellFactory(listView -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    int index = Integer.parseInt(item.substring(0, item.indexOf('.'))) - 1;
                    Image image = new Image(flightList.get(index).getCarrierImageURL());
                    imageView.setImage(image);
                    setText(item);
                    setGraphic(imageView);
                }
            }
        });

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
            if(FileAirportFinder.findAirports(txtField.getText()).size() > 0){
                List<CustomMenuItem> menuItems = new LinkedList<>();

                for (Airport airport : FileAirportFinder.findAirports(txtField.getText())) {
                    CustomMenuItem item = new CustomMenuItem(new Label(airport.getName() + "[" + airport.getIata() + "]"),true);
                    item.setOnAction(actionEvent -> {
                        contextMenu.hide();
                        txtField.setText(airport.getIata());
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
