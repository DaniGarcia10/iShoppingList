package com.example.ishoppinglistdgp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.adapters.ProductAdapter;
import com.example.ishoppinglistdgp.repository.ProductRepository;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button addButton;
    private Button pendingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.product_list);
        addButton = findViewById(R.id.add_button);
        pendingButton = findViewById(R.id.pending_button);

        ProductAdapter adapter = new ProductAdapter(this, ProductRepository.getProducts());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
            intent.putExtra("productId", (int) id); // Asegúrate de que el id se está pasando correctamente
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