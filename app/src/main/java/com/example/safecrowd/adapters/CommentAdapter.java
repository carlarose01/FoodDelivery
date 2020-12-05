package com.example.safecrowd.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.safecrowd.MainActivity;
import com.example.safecrowd.R;
import com.example.safecrowd.models.Comment;
import com.parse.ParseFile;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private static final String TAG = "CommentsAdapter";
    Context context;
    List<Comment> comments;

    public CommentAdapter(Context context, List<Comment> comments){
        this.context = context;
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.bind(comment);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        comments.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Comment> list) {
        comments.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvUsername;
        TextView tvMessage;
        ImageView ivProfile;
        TextView tvTimestamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvMessage = itemView.findViewById(R.id.tvMessage);
            ivProfile = itemView.findViewById(R.id.ivProfile);
            tvTimestamp = itemView.findViewById(R.id.tvTimestamp);
            itemView.setOnClickListener(this);
        }

        public void bind(final Comment comment) {
            tvMessage.setText(comment.getMessage());
            tvUsername.setText(comment.getUser().getUsername());
            tvTimestamp.setText(comment.getTimestamp());
            ParseFile profile = comment.getUser().getParseFile(Comment.KEY_PROFILEPIC);
            if (profile != null) {
                Glide.with(context).load(profile.getUrl()).circleCrop().into(ivProfile);
            } else {
                Glide.with(context).load(R.drawable.ic_profile_black).circleCrop().into(ivProfile);
            }
            ivProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.goUserProfile(comment.getUser());
                }
            });
            tvUsername.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.goUserProfile(comment.getUser());
                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }
}

