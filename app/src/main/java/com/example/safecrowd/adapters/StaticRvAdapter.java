package com.example.safecrowd.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safecrowd.R;
import com.example.safecrowd.activity.PostDetailsActivity;
import com.example.safecrowd.fragments.ComposeDialogFragment;
import com.example.safecrowd.fragments.PostFragment;
import com.example.safecrowd.models.Post;
import com.example.safecrowd.models.StaticRv;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StaticRvViewHolder> {

    private static final String TAG = "StaticRvAdapter";
    ArrayList<StaticRv> items;
    Context context;
    protected List<Post> allPosts;
    protected PostsAdapter postsAdapter;
    public static FragmentManager fragmentManager;
    private RecyclerView rvPosts;
    private int rowIndex = -1;

    public StaticRvAdapter(ArrayList<StaticRv> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public StaticRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item, parent, false);
        StaticRvViewHolder staticRvViewHolder = new StaticRvViewHolder(view);
        context = parent.getContext();

        allPosts = new ArrayList<>();
        postsAdapter = new PostsAdapter(context, allPosts);

        rvPosts = view.findViewById(R.id.rvPosts);

        return staticRvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRvViewHolder holder, final int position) {
        StaticRv currentItems = items.get(position);
        holder.textView.setText(currentItems.getText());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowIndex = position;
                notifyDataSetChanged();
            }
        });

        if (rowIndex == position) {
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected);

            // query posts
            postsAdapter.clear();
            postsAdapter.addAll(allPosts);
            queryPosts();

        } else {
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
        }
    }

    protected void queryPosts() {
        // Specify which class to query
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.whereEqualTo(Post.KEY_TAG, "Protests");
        query.include(Post.KEY_USER);
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue getting posts", e);
                    return;
                }
                for(Post post : posts) {
                    Log.i(TAG, "Post: " + post.getCaption() + ", Username: " + post.getUser().getUsername());
                }
                allPosts.addAll(posts);
                postsAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class StaticRvViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        LinearLayout linearLayout;

        public StaticRvViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            itemView.setOnClickListener(this);
        }

        // Hashtag click show posts with that hashtag
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            // making sure the position is valid
            if (position != RecyclerView.NO_POSITION) {
                StaticRv filter = items.get(position);

                Toast.makeText(context, "Filter was clicked", Toast.LENGTH_SHORT).show();

                // creating a new intent to go to the new activity
                Intent intent = new Intent(context, ComposeDialogFragment.class);

                // pass information to the intent with the parceler
                intent.putExtra(Post.class.getSimpleName(), Parcels.wrap(filter));
                intent.putExtra("showFilter", false);


                context.startActivity(intent);
            }
        }
    }


}
