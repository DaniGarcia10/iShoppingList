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

    // EditProductActivity.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        //Obtengo elementos
        nameEditText = findViewById(R.id.edit_product_name);
        noteEditText = findViewById(R.id.edit_product_note);
        statusSwitch = findViewById(R.id.switch_product_status);
        saveButton = findViewById(R.id.add_pending_button);
        cancelButton = findViewById(R.id.back_button);

        //Obtengo el producto
        int productId = getIntent().getIntExtra("productId", -1);
        Product product = ProductRepository.getProductById(productId);

        // Si el producto no es nulo, se establecen los valores en los campos
        if (product != null) {
            nameEditText.setText(product.getName());
            noteEditText.setText(product.getNote());
            statusSwitch.setChecked(product.isStatus());
        } else {
            //Si no se encuentra el producto, se cierra la actividad
            finish();
        }

        //Guardar los cambios
        saveButton.setOnClickListener(v -> {
            // Actualizo el producto
            if (product != null) {
                product.setName(nameEditText.getText().toString());
                product.setNote(noteEditText.getText().toString());
                product.setStatus(statusSwitch.isChecked());
            }
            //Intent para ir a la actividad de detalle del producto
            Intent intent = new Intent(EditProductActivity.this, ProductDetailActivity.class);
            startActivity(intent);
            finish();
        });

        //Cancelar cambios
        cancelButton.setOnClickListener(v -> {
            finish();
        });
    }
}