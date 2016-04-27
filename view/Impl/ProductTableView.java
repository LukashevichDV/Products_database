package ru.mail.LukashevichDV.view.Impl;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ru.mail.LukashevichDV.entity.Product;
import ru.mail.LukashevichDV.service.Impl.ProductServiceImpl;
import ru.mail.LukashevichDV.service.ProductService;
import ru.mail.LukashevichDV.view.View;


public class ProductTableView implements View {

    private ProductService service = new ProductServiceImpl();

    private TableView table = new TableView();

    public Pane buildPane(final ObservableList<Product> data) {
        table.setEditable(true);


        final TableColumn nameProductCol = new TableColumn("Name product");
        nameProductCol.setPrefWidth(100);
        final TableColumn descriptionProductCol = new TableColumn("Description product");
        descriptionProductCol.setPrefWidth(130);
        final TableColumn dateProductCol = new TableColumn("Date of produce");
        dateProductCol.setPrefWidth(110);


        final TextField addNameProduct = new TextField();
        addNameProduct.setPromptText("Name product");
        addNameProduct.setMaxWidth(100);

        final TextField addDescriptionProduct = new TextField();
        addDescriptionProduct.setPromptText("Description product");
        addDescriptionProduct.setMaxWidth(130);

        final TextField addDateProduct = new TextField();
        addDateProduct.setPromptText("Date of produce");
        addDateProduct.setMaxWidth(110);

        nameProductCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        nameProductCol.setCellFactory(TextFieldTableCell.forTableColumn());

        nameProductCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
                                           public void handle(TableColumn.CellEditEvent<Product, String> t) {
                                               ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())
                                               ).setName(t.getNewValue());
                                           }
                                       }
        );

        descriptionProductCol.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));

        descriptionProductCol.setCellFactory(TextFieldTableCell.forTableColumn());

        descriptionProductCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
                                                  public void handle(TableColumn.CellEditEvent<Product, String> t) {
                                                      ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())
                                                      ).setDescription(t.getNewValue());
                                                  }
                                              }
        );
        dateProductCol.setCellValueFactory(new PropertyValueFactory<Product, String>("date"));


        table.getColumns().addAll(nameProductCol, descriptionProductCol, dateProductCol);
        table.setItems(data);


        final Button button = new Button("Add");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String nameProduct = addNameProduct.getText();
                String descriptionProduct = addDescriptionProduct.getText();
                String dateOfProduce = addDateProduct.getText();
                if (nameProduct != null && !nameProduct.isEmpty()) {
                    data.add(new Product(nameProduct, descriptionProduct, dateOfProduce));
                }
                addNameProduct.clear();
                addDescriptionProduct.clear();
                addDateProduct.clear();
            }
        });

        final Button save = new Button("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                service.save(data);
            }
        });

        final Button refresh = new Button("Refresh");
        refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.clear();
                data.addAll(service.getAll());
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(addNameProduct, addDescriptionProduct, addDateProduct, button, save, refresh);


        final TextField query = new TextField();
        query.setPrefWidth(420);
        query.setPromptText("Query");

        final Button s = new Button("Refresh");
        s.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.clear();
                data.addAll(service.getByParametr("nameProduct", query.getText()));
            }
        });

        HBox search = new HBox();
        search.getChildren().addAll(query, s);

        final VBox vbox = new VBox();
        vbox.setFillWidth(true);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(table, hBox, search);

        return vbox;
    }
}
