package com.example.ishoppinglistdgp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.ishoppinglistdgp.R;
import com.example.ishoppinglistdgp.models.Product;
import java.util.List;

public class PendingProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> products;

    public PendingProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return products.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        }

        Product producto = products.get(position);

        TextView nameTextView = convertView.findViewById(R.id.product_name);
        nameTextView.setText(producto.getNombre());

        return convertView;
    }
}