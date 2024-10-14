package com.example.ishoppinglistdgp.activities;

import static com.example.ishoppinglistdgp.repository.ProductRepository.fillNotPendingProducts;
import static com.example.ishoppinglistdgp.repository.ProductRepository.fillPendingProducts;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.models.Product;
import com.example.ishoppinglistdgp.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AddPendingProductActivity extends AppCompatActivity {
    private Spinner productSpinner;
    private Button saveButton;
    private Button cancelButton;
    private ListView pendingProductList;

    private List<Product> notPendingProducts;

    @Override
    //
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pending_product);

        //Llamo a los elementos
        pendingProductList = findViewById(R.id.pending_product_list);
        notPendingProducts = ProductRepository.getNotPendingProducts();
        productSpinner = findViewById(R.id.product_spinner);
        saveButton = findViewById(R.id.add_pending_button);
        cancelButton = findViewById(R.id.back_button);

        //Obtengo la lista de productos pendientes de ProductRepository
        List<Product> pendingProducts = ProductRepository.getPendingProductos();

        //Obtengo la lista de productos no pendientes de ProductRepository
        List<Product> notPendingProducts = ProductRepository.getNotPendingProducts();

        //Creo el adaptador para el spinner
        ArrayAdapter<Product> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, notPendingProducts);
        fillNotPendingProducts();
        productSpinner.setAdapter(adapter);


        //Boton de agregar
        saveButton.setOnClickListener(v -> {
            Product product = (Product) productSpinner.getSelectedItem();
            product.setStatus(true);
            finish();
        });

        //Boton de cancelar
        cancelButton.setOnClickListener(v -> finish());

    }
}