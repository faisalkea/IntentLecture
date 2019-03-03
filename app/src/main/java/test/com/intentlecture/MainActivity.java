package test.com.intentlecture;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";

    private Button b1, b2, b3;
    private EditText et1, et2, et3, et4, et5, et6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.activity_main);

        init();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b1:
                Log.d(TAG, "B1: onClick: called");
                Student stud = createStudFromView();
                Log.i(TAG, stud.toString());
                
                break;
            case R.id.b2:
                Log.d(TAG, "B2: onClick: called");
                clearEditTexts();
                break;
            case R.id.b3:
                Log.d(TAG, "B3: onClick: called");
                sendMail();
                break;
        }
    }

    private Student createStudFromView() {
        Student stud = new Student();
        stud.setFirstName(et1.getText().toString());
        stud.setLastName(et2.getText().toString());
        stud.setCpr(et3.getText().toString());
        stud.setEmail(et4.getText().toString());
        stud.setPassword(et5.getText().toString());

        return stud;
    }

    private void sendMail() {
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_EMAIL, "fafj@kea.dk");
        email.putExtra(Intent.EXTRA_SUBJECT, "The Subject");
        email.putExtra(Intent.EXTRA_TEXT,"Body of the mail");
        startActivity(Intent.createChooser(email, "Choose an email client from..."));
    }

    private void init() {
        Log.d(TAG, "init called");

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(this);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
    }

    private void clearEditTexts() {
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
    }

}
