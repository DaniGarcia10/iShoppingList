package com.example.ishoppinglistdgp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.models.Product;
import com.example.ishoppinglistdgp.repository.ProductRepository;

public class EditProductActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText noteEditText;
    private Switch statusSwitch;
    private Button saveButton;
    private Button cancelButton;
    private int productId;

    // EditProductActivity.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        nameEditText = findViewById(R.id.edit_product_name);
        noteEditText = findViewById(R.id.edit_product_note);
        statusSwitch = findViewById(R.id.edit_product_status);
        saveButton = findViewById(R.id.add_pending_button);
        cancelButton = findViewById(R.id.cancel_button);

        int productId = getIntent().getIntExtra("productId", -1);
        Product product = ProductRepository.getProductById(productId);

        if (product != null) {
            nameEditText.setText(product.getNombre());
            noteEditText.setText(product.getNotaInformativa());
            statusSwitch.setChecked(product.isPending());
        } else {
            finish(); // Cierra la actividad si el producto no se encuentra
        }

        saveButton.setOnClickListener(v -> {
            if (product != null) {
                product.setNombre(nameEditText.getText().toString());
                product.setNotaInformativa(noteEditText.getText().toString());
                product.setPending(statusSwitch.isChecked());
                ProductRepository.updateProducto(product);
            }
            Intent intent = new Intent(EditProductActivity.this, ProductDetailActivity.class);
            startActivity(intent);
            finish();
        });

        cancelButton.setOnClickListener(v -> {
            finish();
        });
    }
}