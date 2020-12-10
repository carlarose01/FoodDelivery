package com.example.safecrowd.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.safecrowd.activity.MainActivity;
import com.example.safecrowd.activity.PostDetailsActivity;
import com.example.safecrowd.R;
import com.example.safecrowd.models.Post;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.SaveCallback;

import org.parceler.Parcels;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private static final String TAG = "PostsAdapter";
    Context context;
    List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvName;
        TextView tvDescription;
        ImageView ivImage;
        ImageView ivProfile;
        TextView tvTimestamp;
        ImageView ivComment;
        TextView tvLikeNum;
        ImageView ivLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvScreenName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivImage = itemView.findViewById(R.id.ivImage);
            ivProfile = itemView.findViewById(R.id.ivProfileImage);
            tvTimestamp = itemView.findViewById(R.id.tvCreatedAtD);
            ivComment = itemView.findViewById(R.id.ibReply);
            tvLikeNum = itemView.findViewById(R.id.tvLikes);
            ivLike = itemView.findViewById(R.id.ivLoveTweet);
            itemView.setOnClickListener(this);
        }

        public void bind(final Post post) {
            Log.i(TAG, "user: " + post.getUser().getUsername());
            String username = post.getUser().getUsername();
            tvDescription.setText(post.getCaption());
            tvName.setText(username);
            tvTimestamp.setText(post.getTimestamp());
            tvLikeNum.setText(post.getLikeNum() + " ");
            ParseFile image = post.getImage();
            if (image != null) {
                ivImage.setVisibility(View.VISIBLE);
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }

            ParseFile profile = post.getProfile();
            if (profile != null) {
                Glide.with(context).load(profile.getUrl()).circleCrop().into(ivProfile);
            } else {
                Glide.with(context).load(R.drawable.ic_profile_black).circleCrop().into(ivProfile);
            }
            if (post.isLiked()) {
                Glide.with(context).load(R.drawable.ic_heart_solid_red_svg).into(ivLike);
            } else {
                Glide.with(context).load(R.drawable.ic_heart_clear_light_blue_svg).into(ivLike);
            }
            ivProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.goUserProfile(post.getUser());
                }
            });
            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.goUserProfile(post.getUser());
                }
            });
            ivComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    // making sure the position is valid
                    if (position != RecyclerView.NO_POSITION) {
                        Post post = posts.get(position);

                        // creating a new intent to go to the new activity
                        Intent intent = new Intent(context, PostDetailsActivity.class);

                        // pass information to the intent with the parceler
                        intent.putExtra(Post.class.getSimpleName(), Parcels.wrap(post));
                        intent.putExtra("openCompose", true);

                        context.startActivity(intent);
                    }

                }
            });
            ivLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Integer likeImage;
                    if (post.addedLike()) {
                        likeImage = R.drawable.ic_heart_solid_red_svg;
                    } else {
                        likeImage = R.drawable.ic_heart_clear_light_blue_svg;
                    }
                    post.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e != null) {
                                Log.e(TAG, "Issue saving the post like" , e);
                                return;
                            }
                            Log.i(TAG, "Like was saved!!");
                            tvLikeNum.setText(post.getLikeNum() + " Likes");
                            Glide.with(context).load(likeImage).into(ivLike);
                        }
                    });

                }
            });
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            // making sure the position is valid
            if (position != RecyclerView.NO_POSITION) {
                Post post = posts.get(position);

                // creating a new intent to go to the new activity
                Intent intent = new Intent(context, PostDetailsActivity.class);

                // pass information to the intent with the parceler
                intent.putExtra(Post.class.getSimpleName(), Parcels.wrap(post));
                intent.putExtra("openCompose", false);


                context.startActivity(intent);
            }
        }
    }
}