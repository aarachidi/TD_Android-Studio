package com.example.recyclerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private final List<Contact> mContacts;

    public ContactsAdapter(List<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);
        TextView firstNameTextView = holder.firstNameTextView;
        firstNameTextView.setText(contact.getPrenom());
        TextView lastNameTextView = holder.lastNameTextView;
        lastNameTextView.setText(contact.getNom());
        ImageView imageView = holder.imageView;
        Picasso.get().load("https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg").resize(100, 100).placeholder(R.drawable.ic_launcher_foreground).into(imageView);

        //Glide.with(holder.itemView.getContext()).load(contact.getImgUrl()).centerCrop().placeholder(R.drawable.ic_launcher_background).dontAnimate().into(imageView);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView firstNameTextView, lastNameTextView;
        public ImageView imageView;
        public ViewHolder(View itemView){
            super(itemView);

            firstNameTextView = (TextView) itemView.findViewById(R.id.contact_firstname);
            lastNameTextView = (TextView) itemView.findViewById(R.id.contact_lastname);
            imageView = (ImageView) itemView.findViewById(R.id.contact_img);
        }
    }
}
