package ntcc.ayush.rider;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.CardView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

import ntcc.ayush.rider.LoginSignup;

public class NavDrawer extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //onClickLIsteners
        findViewById(R.id.c1).setOnClickListener(this);
        findViewById(R.id.c3).setOnClickListener(this);
        findViewById(R.id.c2).setOnClickListener(this);

        //CardView cardView=(CardView)findViewById(R.id.cv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Wow! you Pressed a button, congrats!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(getApplicationContext(), NewPostActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Toast.makeText(this,"there is no going back",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_logout) {
            try{
                LoginManager.getInstance().logOut();
                FirebaseAuth.getInstance().signOut();

            }catch(Exception e){}
            startActivity(new Intent(this,LoginSignup.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void detailHandler(int a){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, a);
        startActivity(intent);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this,NewPostActivity.class));
        } else if (id == R.id.nav_slideshow) {

            startActivity(new Intent(this,MainActivity.class));
        } else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "I'm Using *Rider*, open this link to share a ride with me!\nhttp://link_to_app.com");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_send) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "I'm Using *Rider*, open this link to share a ride with me!\nhttp://link_to_app.com");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_logout) {
            try{
                LoginManager.getInstance().logOut();
                FirebaseAuth.getInstance().signOut();

            }catch(Exception e){}
            startActivity(new Intent(this,LoginSignup.class));

        } else if (id == R.id.contact_us||id == R.id.help){
            Intent mail = new Intent(Intent.ACTION_SEND);
            //mail.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
            mail.putExtra(Intent.EXTRA_EMAIL, new String[] { "ayushsinghiii.94@gmail.com" });
            mail.setData(Uri.parse("ayushsinghiii.94@gmail.com"));
            mail.putExtra(Intent.EXTRA_SUBJECT, "Issue With Rider App");
            mail.setType("plain/text");
            mail.putExtra(Intent.EXTRA_TEXT, "Please Write you issue here\n");
            startActivity(mail);
        } else if(id==R.id.about_us){
            String url = "http://www.aaayushsingh.in";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.action_button3:
                startActivity(new Intent(this, NewPostActivity.class));
                break;
            case R.id.action_button:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.action_button2:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.favorite_button:
                startActivity(new Intent(this,NewPostActivity.class));
                break;
            case R.id.favorite_button2:
                startActivity(new Intent(this,NewPostActivity.class));
                break;
            case R.id.favorite_button3:
                startActivity(new Intent(this,NewPostActivity.class));
                break;
            case R.id.share_button:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "I'm Using *Rider*, to create an auto ride, come join me,\nBe my co *Rider*");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            case R.id.share_button2:
                Intent sendIntent2 = new Intent();
                sendIntent2.setAction(Intent.ACTION_SEND);
                sendIntent2.putExtra(Intent.EXTRA_TEXT, "I'm Using *Rider*, to create a cab ride, come join me,\nBe my co *Rider*");
                sendIntent2.setType("text/plain");
                startActivity(sendIntent2);
                break;
            case R.id.share_button3:
                Intent sendIntent3 = new Intent();
                sendIntent3.setAction(Intent.ACTION_SEND);
                sendIntent3.putExtra(Intent.EXTRA_TEXT, "I'm Using *Rider*, to create a ride, come join me,\nBe my co *Rider*");
                sendIntent3.setType("text/plain");
                startActivity(sendIntent3);
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.c1:
                detailHandler(0);
                break;
            case R.id.c2:
                detailHandler(1);
                break;
            case R.id.c3:
                detailHandler(2);
                break;
        }
    }
}


