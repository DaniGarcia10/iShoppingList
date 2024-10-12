package com.example.ishoppinglistdgp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.models.Product;
import com.example.ishoppinglistdgp.repository.ProductRepository;

public class AddProductActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText noteEditText;
    private EditText statusEditText;
    private Button saveButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        nameEditText = findViewById(R.id.add_product_name);
        noteEditText = findViewById(R.id.add_product_note);
        statusEditText = findViewById(R.id.add_product_status);
        saveButton = findViewById(R.id.add_pending_button);
        cancelButton = findViewById(R.id.cancel_button);

        saveButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String note = noteEditText.getText().toString();
            boolean status = statusEditText.getText().toString().equalsIgnoreCase("Comprado");

            Product product = new Product(ProductRepository.getProducts().size() + 1, name, note, status);
            ProductRepository.addProduct(product);
            finish();
        });

        cancelButton.setOnClickListener(v -> finish());
    }
}