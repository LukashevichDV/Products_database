package ru.mail.LukashevichDV;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ru.mail.LukashevichDV.entity.Product;
import ru.mail.LukashevichDV.view.Impl.ProductTableView;
import ru.mail.LukashevichDV.view.View;


public class App extends Application {



    private final ObservableList<Product> data = FXCollections.observableArrayList();

    public static void main( String[] args )
    {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Database products");
        stage.setWidth(600);
        stage.setHeight(600);
        scene.setFill(Color.CHOCOLATE);

        final Label label = new Label("Products");
        label.setFont(new Font("Arial", 20));

        ((Group) scene.getRoot()).getChildren().addAll(initLayout());

        stage.setScene(scene);
        stage.show();
    }

    private Pane initLayout(){
        View view = new ProductTableView();
        return view.buildPane(data);
    }
}
