package com.example.ishoppinglistdgp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.models.Product;
import com.example.ishoppinglistdgp.repository.ProductRepository;
import com.example.ishoppinglistdgp.adapters.PendingProductAdapter;

import java.util.List;
import java.util.stream.Collectors;

public class AddPendingProductActivity extends AppCompatActivity {

    private Spinner productSpinner;
    private Button saveButton;
    private Button cancelButton;

    private ListView pendingProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pending_product);

        pendingProductList = findViewById(R.id.pending_product_list);
        productSpinner = findViewById(R.id.product_spinner);
        saveButton = findViewById(R.id.add_pending_button);
        cancelButton = findViewById(R.id.cancel_button);

        List<Product> nonPendingProducts = ProductRepository.getProducts().stream()
                .filter(producto -> !producto.isPending())
                .collect(Collectors.toList());

        ArrayAdapter<Product> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nonPendingProducts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        productSpinner.setAdapter(adapter);

        List<Product> pendingProductos = ProductRepository.getProducts().stream()
                .filter(producto -> producto.isPending())
                .collect(Collectors.toList());
        PendingProductAdapter pendingProductAdapter = new PendingProductAdapter(this, pendingProductos);
        pendingProductList.setAdapter(pendingProductAdapter);

        saveButton.setOnClickListener(v -> {
            String productName = productSpinner.getSelectedItem().toString();
            Product product = new Product(ProductRepository.getPendingProductos().size() + 1, productName, "", true);
            ProductRepository.addPendingProducto(product);
            updatePendingProductList();
        });

        cancelButton.setOnClickListener(v -> finish());


    }

    private void updatePendingProductList() {
        ListView pendingProductList = findViewById(R.id.pending_product_list);
        PendingProductAdapter adapter = new PendingProductAdapter(this, ProductRepository.getPendingProductos());
        pendingProductList.setAdapter(adapter);
    }
}