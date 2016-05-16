package edittexttest.rsantosh.com.edittexttest;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class edittexttest extends AppCompatActivity implements View.OnClickListener {

    Button click;
    EditText edittext;
    TextView displayText;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittexttest);

        click = (Button) findViewById(R.id.buttondisplay);
        click.setOnClickListener(this);

        edittext = (EditText) findViewById(R.id.edittext);
        displayText=(TextView) findViewById(R.id.textdisplay);

    }

    @Override
    public void onClick(View v) {

        String word = edittext.getText().toString();
        displayText.setText(word);

    }
}
