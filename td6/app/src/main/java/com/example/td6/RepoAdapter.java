package com.example.td6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {
    private final List<Repo> mRepo;

    public RepoAdapter(List<Repo> mRepo) {
        this.mRepo = mRepo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_repo, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repo repo = mRepo.get(position);
        TextView fullnameTextView = holder.fullnameTextView;
        fullnameTextView.setText(repo.getFull_name());
        TextView htmlUrlTextView = holder.htmlUrlTextView;
        htmlUrlTextView.setText(repo.getHtml_url());

    }

    @Override
    public int getItemCount() {
        return mRepo.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView fullnameTextView, htmlUrlTextView;
        public ViewHolder(View itemView){
            super(itemView);

            fullnameTextView = (TextView) itemView.findViewById(R.id.repo_fullname);
            htmlUrlTextView = (TextView) itemView.findViewById(R.id.repo_htmlurl);
        }
    }
}
