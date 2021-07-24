package com.example.retrofitflickrapi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitflickrapi.Model.Comment.Comment__1;
import com.example.retrofitflickrapi.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {
    ArrayList<Comment__1> listComment;

    public CommentAdapter(ArrayList<Comment__1> listComment) {
        this.listComment = listComment;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_comment,parent,false);
        return new CommentAdapter.CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentAdapter.CommentHolder holder, int position) {
        Comment__1 comment= listComment.get(position);
        holder.txtRealname.setText(comment.getAuthorname());
        holder.txtContent.setText(comment.getContent());

    }

    @Override
    public int getItemCount() {
        return listComment.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        TextView txtRealname,txtContent,txtdateCreate,txtsttComment;
        public CommentHolder(View itemView) {
            super(itemView);
            txtRealname= itemView.findViewById(R.id.txtRealname);
            txtContent= itemView.findViewById(R.id.txtContent);
            txtdateCreate= itemView.findViewById(R.id.txtdateCreate);
            txtsttComment= itemView.findViewById(R.id.sttComment);



        }
    }
}
