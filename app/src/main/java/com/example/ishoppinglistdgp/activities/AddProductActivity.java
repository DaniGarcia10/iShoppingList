package com.example.ishoppinglistdgp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.models.Product;
import com.example.ishoppinglistdgp.repository.ProductRepository;

public class AddProductActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText noteEditText;
    private Switch switch_product_status;
    private Button saveButton;
    private Button cancelButton;
    private Switch lactosaSwitch;
    private Switch glutenSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        //Llamo a los elementos
        nameEditText = findViewById(R.id.edit_product_name);
        noteEditText = findViewById(R.id.edit_product_note);
        switch_product_status = findViewById(R.id.switch_product_status);
        lactosaSwitch = findViewById(R.id.switch_product_lactosa);
        glutenSwitch = findViewById(R.id.switch_product_gluten);
        saveButton = findViewById(R.id.add_pending_button);
        cancelButton = findViewById(R.id.back_button);

        //Boton de guardar
        saveButton.setOnClickListener(v -> {
            //Extraigo los datos de los campos
            String name = nameEditText.getText().toString();
            String note = noteEditText.getText().toString();
            boolean status = switch_product_status.isChecked();
            boolean lactosa = lactosaSwitch.isChecked();
            boolean gluten = glutenSwitch.isChecked();

            //Creo el producto
            Product product = new Product(ProductRepository.getProducts().size() + 1, name, note, status, lactosa, gluten);
            //
            ProductRepository.addProduct(product);
            //Recargo la lista de productos no pendientes
            ProductRepository.fillNotPendingProducts();
            //Recargo la lista de productos pendiente
            ProductRepository.fillPendingProducts();
            finish();
        });

        cancelButton.setOnClickListener(v -> finish());
    }
}