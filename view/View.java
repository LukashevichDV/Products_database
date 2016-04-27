package ru.mail.LukashevichDV.view;


import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import ru.mail.LukashevichDV.entity.Product;

public interface View {

    Pane buildPane(final ObservableList<Product> data);
}
