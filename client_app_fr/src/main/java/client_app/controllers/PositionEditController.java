package client_app.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import client_app.models.Position;
import client_app.services.PositionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class PositionEditController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox checkActive;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    void onBtnClick(ActionEvent event) {
            if (event.getSource().equals(btnSave)) {
                Position position = new Position();
                position.setName(txtName.getText());
                position.setActive(checkActive.isSelected());
                PositionService.POSITION_SERVICE.save(position);
            }
    }

    @FXML
    void initialize() {


    }
}
