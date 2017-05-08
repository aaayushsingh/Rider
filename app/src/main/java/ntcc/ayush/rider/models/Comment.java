package ntcc.ayush.rider.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.text.DateFormat;
import java.util.Date;

// [START comment_class]
@IgnoreExtraProperties
public class Comment {

    public String uid;
    public String author;
    public String text;
    public String ts1;

    public Comment() {
        // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    }

    String ts = DateFormat.getDateTimeInstance().format(new Date());

    public Comment(String uid, String author, String text, String tst) {
        this.uid = uid;
        this.author = author;
        this.text = text;
        this.ts1=ts;
    }

}
// [END comment_class]
