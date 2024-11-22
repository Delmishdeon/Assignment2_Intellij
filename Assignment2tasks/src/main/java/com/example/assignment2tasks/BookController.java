package com.example.assignment2tasks;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BookController {
    @FXML
    private Label bestSellerLabel;

    private BookService bookService = new BookService();

    @FXML
    public void initialize() {
        try {
            String bestSellers = bookService.getBestSellers();
            bestSellerLabel.setText(bestSellers);  // Displaying raw JSON for now
        } catch (Exception e) {
            e.printStackTrace();
            bestSellerLabel.setText("Failed to load data.");
        }
    }
}
