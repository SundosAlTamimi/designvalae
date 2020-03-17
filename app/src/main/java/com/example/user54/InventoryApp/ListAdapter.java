package com.example.user54.InventoryApp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.user54.InventoryApp.Model.ItemCard;

import java.util.List;

import static com.example.user54.InventoryApp.Item.itemList;


public class ListAdapter extends BaseAdapter {
    CheckBox checkPriceed;
    private Context context;
    List<ItemCard> itemsList;

    public ListAdapter(Context context, List<ItemCard> itemsList) {
        this.context = context;
        this.itemsList = itemsList;

    }

    public ListAdapter() {

    }

    public void setItemsList(List<ItemCard> itemsList) {
        this.itemsList = itemsList;

    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        CheckBox checkPrice;
        TextView itemCode, itemName;//, price
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final ViewHolder holder = new ViewHolder();
        view = View.inflate(context, R.layout.item_row, null);

        holder.checkPrice = (CheckBox) view.findViewById(R.id.checkPrice);

        holder.itemCode = (TextView) view.findViewById(R.id.itemCode);
        holder.itemName = (TextView) view.findViewById(R.id.itemName);
//        holder.price = (TextView) view.findViewById(R.id.price);

        holder.itemCode.setText("" + itemsList.get(i).getItemCode());
        holder.itemName.setText("" + itemsList.get(i).getItemName());
//        holder.price.setText("" + itemsList.get(i).getSalePrc());
        holder.checkPrice.setChecked(itemsList.get(i).getCheck());


        holder.checkPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox=(CheckBox)v;
                if ( holder.checkPrice.isChecked()) {
//                    holder.checkPrice.setChecked(true);
                    itemList.get(i).setCheck(true);
                }
                else {
//                    holder.checkPrice.setChecked(false);
                    itemList.get(i).setCheck(false);
                }
            }
        });


        return view;
    }




}

