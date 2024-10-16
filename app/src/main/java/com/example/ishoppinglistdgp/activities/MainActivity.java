package com.example.ishoppinglistdgp.activities;
import static com.example.ishoppinglistdgp.repository.ProductRepository.fillNotPendingProducts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.adapters.ProductAdapter;
import com.example.ishoppinglistdgp.repository.ProductRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declaro las variables
    private ListView listView;
    private Button addButton;
    private Button pendingButton;
    private ProductAdapter adapter;

//Metodo para crear la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.product_list);
        addButton = findViewById(R.id.add_button);
        pendingButton = findViewById(R.id.pending_button);

        //Adaptador para la lista de productos
        adapter = new ProductAdapter(this, ProductRepository.getProducts());
        listView.setAdapter(adapter);

        //Evento para ver el detalle de un producto
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
            intent.putExtra("productId", (int) id);
            startActivity(intent);
        });

        //Evento para agregar un producto
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
            startActivity(intent);
        });

        //Evento para ver los productos pendientes
        pendingButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddPendingProductActivity.class);
            startActivity(intent);
        });
    }


}