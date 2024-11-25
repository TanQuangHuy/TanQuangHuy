package com.example.tanquanghuy_baitaplon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<Item> itemList;

    public ListAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
        }

        Item currentItem = itemList.get(position);

        // Liên kết dữ liệu với giao diện
        ImageView itemImage = convertView.findViewById(R.id.item_image);
        TextView itemTitle = convertView.findViewById(R.id.textview1);
        TextView itemDescription = convertView.findViewById(R.id.textview1);
        Button buyButton = convertView.findViewById(R.id.buy_button);

        itemImage.setImageResource(currentItem.imag());
        itemTitle.setText(currentItem.Title());
        itemDescription.setText(currentItem.Description());

        // Xử lý sự kiện nút bấm
        buyButton.setOnClickListener(v -> {
            // Thực hiện hành động mua
        });

        return convertView;
    }
}
