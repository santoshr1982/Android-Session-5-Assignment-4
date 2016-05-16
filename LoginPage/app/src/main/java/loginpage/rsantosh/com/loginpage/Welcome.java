package loginpage.rsantosh.com.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    //Declaration of variables.
    private String mMailId;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        //Initialisation of variables.
        textView = (TextView) findViewById(R.id.welcome);

        //getting intent from login screen.
        Intent userID=getIntent();

        //Getting User Id from login screen.
        mMailId = userID.getStringExtra("EXTRA");

        //Concating the string.
        mMailId = "Welcome" + " " + mMailId + ".";

        //Displaying the message.
        textView.setText(mMailId);

    }
}
