package com.houarizegai.fxmaterialdesign.controllers;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML // Root Element
    private StackPane root;

    // Nodes
    private StackPane slideShowPane;
    private VBox recyclerViewPane, selectedViewPane, validAlertPane, invalidAlertPane, menuDrawerPane;
    private AnchorPane stepperTouchPane, animateButtonsPane;

    // Drawer (Left Menu)
    @FXML
    private JFXDrawer drawer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            slideShowPane = FXMLLoader.load(getClass().getResource("/views/SlideShow.fxml"));
            recyclerViewPane = FXMLLoader.load(getClass().getResource("/views/RecyclerView.fxml"));
            selectedViewPane = FXMLLoader.load(getClass().getResource("/views/Selectedview.fxml"));
            validAlertPane = FXMLLoader.load(getClass().getResource("/views/validAlert.fxml"));
            invalidAlertPane = FXMLLoader.load(getClass().getResource("/views/InvalidAlert.fxml"));
            // Init Menu
            menuDrawerPane = FXMLLoader.load(getClass().getResource("/views/MenuDrawer.fxml"));
            stepperTouchPane = FXMLLoader.load(getClass().getResource("/views/StepperTouch.fxml"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        drawer.setOnDrawerClosed(e -> {
            drawer.setSidePane();
        });
    }

    @FXML
    private void onSlideShow() {
        new JFXDialog(root, slideShowPane, JFXDialog.DialogTransition.CENTER).show();
    }

    @FXML
    private void onRecyclerView() {
        new JFXDialog(root, recyclerViewPane, JFXDialog.DialogTransition.CENTER).show();
    }

    @FXML
    private void onSelectedView() {
        new JFXDialog(root, selectedViewPane, JFXDialog.DialogTransition.CENTER).show();
    }

    @FXML
    private void onCustomAlert() {
        Stage stage = (Stage) (root.getScene().getWindow());
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/Alert.fxml"));
            stage.setScene(new Scene(root));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @FXML
    private void onMenuDrawer() {
        if(drawer.isShown()) {
            drawer.close();
        }
        else {
            drawer.setSidePane(menuDrawerPane);
            drawer.open();
        }
    }

    @FXML
    private void onStepperTouch() {
        new JFXDialog(root, stepperTouchPane, JFXDialog.DialogTransition.CENTER).show();
    }

    @FXML
    private void onAnimateButtons() {
        try {
            animateButtonsPane = FXMLLoader.load(getClass().getResource("/views/AnimateButtons.fxml"));
            new JFXDialog(root, animateButtonsPane, JFXDialog.DialogTransition.CENTER).show();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
