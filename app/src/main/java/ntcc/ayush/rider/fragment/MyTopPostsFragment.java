package ntcc.ayush.rider.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class MyTopPostsFragment extends PostListFragment {

    public MyTopPostsFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // [START my_top_posts_query]
        // My top posts by number of stars
        //String myUserId = getUid();
        //Query myTopPostsQuery = databaseReference.child("user-posts").child(myUserId)
        //        .orderByChild("starCount");
        // [END my_top_posts_query]
        Query myTopPostsQuery = databaseReference.child("posts")
                .limitToFirst(100).orderByChild("starCount");

        return myTopPostsQuery;
    }
}
