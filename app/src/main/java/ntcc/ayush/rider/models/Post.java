package ntcc.ayush.rider.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// [START post_class]
@IgnoreExtraProperties
public class Post {

    public String uid;
    public String author;
    public String title;
    public String body;
    public String type;
    public String dest;
    public String ts;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }



    public Post(String uid, String author, String title, String body, String dest, String type, String ts) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
        this.type=type;
        this.dest=dest;
        this.ts=ts;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("ts",ts);
        result.put("author", author);
        result.put("title", title);
        result.put("body", body);
        result.put("starCount", starCount);
        result.put("stars", stars);
        result.put("dest", dest);
        result.put("type", type);

        return result;
    }
    // [END post_to_map]

}
// [END post_class]
