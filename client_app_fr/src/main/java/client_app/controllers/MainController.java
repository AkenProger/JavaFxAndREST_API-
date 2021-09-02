package client_app.controllers;
import java.io.IOException;
import java.util.List;
import java.util.Observable;

import client_app.models.Position;
import client_app.services.PositionService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private MenuItem mnItemAdd;

    @FXML
    private MenuItem mnItemEdit;

    @FXML
    private ListView<Position> listPositions;

    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if (event.getSource().equals(mnItemAdd)) {
            Stage primaryStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/layouts/position_edit.fxml"));
            try {
                fxmlLoader.load();
                Parent parent = fxmlLoader.getRoot();
                primaryStage.setScene(new Scene(parent));
                primaryStage.setTitle("Редактирования");
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void initialize() {
        List<Position> positionList = PositionService.POSITION_SERVICE.findAll();
        ObservableList<Position> observableList = FXCollections.observableList(positionList);
        listPositions.setItems(observableList);

    }
}
