package com.example.ishoppinglistdgp.activities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.adapters.ProductAdapter;
import com.example.ishoppinglistdgp.models.Product;
import com.example.ishoppinglistdgp.repository.ProductRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button addButton;
    private Button pendingButton;
    private ArrayAdapter<Product> adapter;
    private List<Product> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.product_list);
        addButton = findViewById(R.id.add_button);
        pendingButton = findViewById(R.id.pending_button);

        //Adaptador para la lista de productos
        ProductAdapter adapter = new ProductAdapter(this, ProductRepository.getProducts());
        listView.setAdapter(adapter);

        //Evento para ver el detalle de un producto
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
            intent.putExtra("productId", (int) id);
            startActivity(intent);
        });

        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
            startActivity(intent);
        });

        pendingButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddPendingProductActivity.class);
            startActivity(intent);
        });
    }


}