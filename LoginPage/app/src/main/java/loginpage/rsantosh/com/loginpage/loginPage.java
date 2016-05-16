package loginpage.rsantosh.com.loginpage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class loginPage extends AppCompatActivity implements View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //Creating object for the controls.
    EditText editTextId;
    EditText editTextPassword;
    Button buttonLogin;

    //Declaring variables.
    String strId;
    String strPassword;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //Initialising the objects.
        editTextId = (EditText) findViewById(R.id.EditText_Email);

        editTextPassword = (EditText) findViewById(R.id.editText_Password);

        buttonLogin = (Button) findViewById(R.id.button_Login);
        buttonLogin.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View view) {

        //Statement to check if the mail ID is empty.
        if (editTextId.getText().toString().trim().isEmpty()) {

            //Display the message when the mail ID is empty.
            Toast.makeText(this, "Enter the Mail Id.", Toast.LENGTH_LONG).show();

        } else {

            //Setting the pattern for comparing the mail ID.
            String strEmailPattern = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


            //If not empty the text or string is compared with the pattern.
            if (editTextId.getText().toString().trim().matches(strEmailPattern)) {

                //Assigining the value to string variable.
                strId = editTextId.getText().toString().trim();

                //Displaying the message that the ID entered is valid.
                //Toast.makeText(this,"Valid Mail id " + strId + ".",Toast.LENGTH_SHORT).show();

                //Setting the pattern to compare the string with the text enterde by the user.
                String strPassword = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%.]).{6,20})";

                //Comparing the string with the pattern.
                if(editTextPassword.getText().toString().trim().isEmpty()){

                    //Displaying the message if the password field is empty.
                    Toast.makeText(this, "Enter a valid password format with length between 6 - 20 and with one upper case alphabet, one lower case alphabet, one  number and on special character.", Toast.LENGTH_LONG).show();

                    //Comparing the password with the pattern.
                }else if(editTextPassword.getText().toString().trim().matches(strPassword)){

                    //Verifying user name.
                    if(strId.equals("abc@def.gh")){

                        //Passing the value of password.
                        String strPass = editTextPassword.getText().toString().trim();

                        //Verifying password.
                        if(strPass.equals("Aabc@01")){

                            //Intent to call welcome UI.
                            Intent welcome = new Intent(this,Welcome.class);

                            //Code to pass the ID to welcome UI.
                            welcome.putExtra("EXTRA",strId);
                            startActivity(welcome);
                            finish();

                        }else{

                            //This line is displaying the hardcoded value of password.
                            Toast.makeText(this,"Enter a valid password. The Password is Aabc@01",Toast.LENGTH_LONG).show();

                        }

                    }else{

                        //This line is displaying the hardcoded value of userId.
                        Toast.makeText(this,"E - Mail ID is in valid. Please enter E - Mail Id as abc@def.gh. ",Toast.LENGTH_LONG).show();

                    }

                }else{
                    //This message is displayed when the password does not match the pattern.
                    Toast.makeText(this, "Enter a valid password format with length between 6 - 20 and with one upper case alphabet, one lower case alphabet, one  number and on special character.", Toast.LENGTH_LONG).show();
                    editTextPassword.setText("");
                }

            }else{
                //This message is displayed when the mail Id does not match the mail pattern.
                strId = editTextId.getText().toString().trim();
                Toast.makeText(this,"Invalid Mail id " + strId + ".",Toast.LENGTH_SHORT).show();
                editTextId.setText("");
            }
        }


    }
}