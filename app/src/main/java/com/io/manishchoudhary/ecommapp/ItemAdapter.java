package com.io.manishchoudhary.ecommapp;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by manishchoudhary on 01/06/18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Item> itemList;
    AssetManager manager;

    public ItemAdapter(Activity activity, List<Item> feedItems) {
        this.activity = activity;
        this.itemList = feedItems;
        manager = activity.getAssets();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class TrackHolder extends ViewHolder {
        TextView itemName, description, price, category;
        CardView card;
        ImageView itemImage;

        public TrackHolder(View v) {
            super(v);
            this.card = (CardView) v.findViewById(R.id.cardview);
            this.itemName = (TextView) v.findViewById(R.id.itemName);
            //this.description = (TextView) v.findViewById(R.id.description);
            this.category = (TextView) v.findViewById(R.id.category);
            this.price = (TextView) v.findViewById(R.id.price);
            this.itemImage = (ImageView) v.findViewById(R.id.itemPic);
        }
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_grid, parent, false);
        return new TrackHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Bitmap bitmap = null;
        final TrackHolder holder = (TrackHolder) viewHolder;
        try{
            InputStream open = manager.open(itemList.get(position).getImageUrl());
            bitmap = BitmapFactory.decodeStream(open);
        }catch (IOException e){
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(itemList.get(position).getName())) {
            holder.itemName.setText(itemList.get(position).getName());
            holder.category.setText(itemList.get(position).getCategory());
            holder.itemImage.setImageBitmap(bitmap);
            //holder.description.setText(itemList.get(position).getDescription());
            holder.price.setText(itemList.get(position).getPrice());
            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDetails(itemList.get(position));
                }
            });
        }
    }

    public void showDetails(Item item){
        //Intent intent = new Intent(activity, DetailActivity.class);
        //intent.putExtra("item", item);
        //activity.startActivity(intent);
    }
}
