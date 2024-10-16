package com.example.ishoppinglistdgp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.models.Product;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> products;

    //Constructor
    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    //Metodo para obtener la cantidad de productos
    @Override
    public int getCount() {
        return products.size();
    }

    //Metodo para obtener un producto
    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    //Metodo para obtener el id de un producto
    @Override
    public long getItemId(int position) {
        return products.get(position).getId();
    }

    //Metodo para obtener la lactosa de un producto
    public boolean getLactosa(int position) {
        return products.get(position).isLactosa();
    }

    //Metodo para obtener el gluten de un producto
    public boolean getGluten(int position) {
        return products.get(position).isGluten();
    }

    //Metodo para obtener la vista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        }

        //Obtengo el producto
        Product product = products.get(position);
        TextView nameTextView = convertView.findViewById(R.id.product_name);
        nameTextView.setText(product.getName());

        // Cambiar el color de fondo
        if (product.isLactosa() && product.isGluten()) {
            convertView.setBackgroundColor(Color.parseColor("#B2EBF2"));
        } else if (product.isLactosa()) {
            convertView.setBackgroundColor(Color.parseColor("#F8BBD0"));
        } else if (product.isGluten()) {
            convertView.setBackgroundColor(Color.parseColor("#D7CCC8"));
        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }

        return convertView;
    }
}