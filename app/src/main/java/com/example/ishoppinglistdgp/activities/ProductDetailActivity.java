package com.example.ishoppinglistdgp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.models.Product;
import com.example.ishoppinglistdgp.repository.ProductRepository;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView noteTextView;
    private TextView statusTextView;
    private Button editButton;
    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Interfaz de la actividad
        setContentView(R.layout.activity_product_detail);

        //Obtengo los elementos
        nameTextView = findViewById(R.id.product_name);
        noteTextView = findViewById(R.id.product_note);
        statusTextView = findViewById(R.id.product_status);
        editButton = findViewById(R.id.edit_button);
        backButton = findViewById(R.id.back_button);

        //Obtengo el producto
        int productId = getIntent().getIntExtra("productId", -1);
        Product product = ProductRepository.getProductById(productId);

        // Si el producto no es nulo, se rellenan los campos
        if (product != null) {
            nameTextView.setText(product.getName());
            noteTextView.setText(product.getNote());
            statusTextView.setText(product.isStatus() ? "Pendiente" : "No Pendiente");
        } else {
            //Cierro la actividad si el producto no existe
            finish();
        }

        // Abre la actividad EditProductActivity con el id del producto
        editButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetailActivity.this, EditProductActivity.class);
            intent.putExtra("productId", productId);
            startActivity(intent);
        });

        // Boton para regresar a la actividad MainActivity
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetailActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}