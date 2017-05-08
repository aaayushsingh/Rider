package ntcc.ayush.rider.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ntcc.ayush.rider.R;
import ntcc.ayush.rider.models.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView titleView;
    public TextView authorView;
    public ImageView starView;
    public TextView numStarsView;
    public TextView bodyView;
    public TextView destn;
    public TextView timeStamp;
    public TextView type;
    public TextView tview4;

    public PostViewHolder(View itemView) {
        super(itemView);

        titleView = (TextView) itemView.findViewById(R.id.post_title);
        authorView = (TextView) itemView.findViewById(R.id.post_author);
        starView = (ImageView) itemView.findViewById(R.id.star);
        numStarsView = (TextView) itemView.findViewById(R.id.post_num_stars);
        bodyView = (TextView) itemView.findViewById(R.id.post_body);
        destn = (TextView) itemView.findViewById(R.id.destn);
        timeStamp = (TextView) itemView.findViewById(R.id.times);
        type = (TextView) itemView.findViewById(R.id.type);
        tview4 = (TextView) itemView.findViewById(R.id.tview4);

    }

    public void bindToPost(Post post, View.OnClickListener starClickListener) {
        titleView.setText(post.title);
        authorView.setText(post.author);
        numStarsView.setText(String.valueOf(post.starCount));
        bodyView.setText(post.body);
        destn.setText(post.dest);
        timeStamp.setText(post.ts);
        type.setText(post.type);
        tview4.setText("Type");

        starView.setOnClickListener(starClickListener);
    }
}
