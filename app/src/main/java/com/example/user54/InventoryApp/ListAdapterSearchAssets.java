package com.example.user54.InventoryApp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.user54.InventoryApp.Model.AssestItem;
import com.example.user54.InventoryApp.Model.ItemCard;

import java.util.List;


public class ListAdapterSearchAssets extends BaseAdapter {
    CheckBox checkPriceed;
    private Context context;
    List<AssestItem> itemsList;

    public ListAdapterSearchAssets(Context context, List<AssestItem> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    public ListAdapterSearchAssets() {

    }

    public void setItemsList(List<AssestItem> itemsList) {
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
        TextView itemCode, itemName;//, price
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final ViewHolder holder = new ViewHolder();
        view = View.inflate(context, R.layout.item_row_search, null);

        holder.itemCode = (TextView) view.findViewById(R.id.itemCode);
        holder.itemName = (TextView) view.findViewById(R.id.itemName);
//        holder.price = (TextView) view.findViewById(R.id.price);

        holder.itemCode.setText("" + itemsList.get(i).getAssesstCode());
        holder.itemName.setText("" + itemsList.get(i).getAssesstName());
//        holder.price.setText("" + itemsList.get(i).getSalePrc());


        return view;
    }




}

