package test.com.intentlecture;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String STUD = "stud";
    private static String TAG = "MainActivity";

    private Button b1, b2, b3, b4;
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
                Log.i(TAG, "Send: "  +stud);

                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra(STUD, stud);
                startActivity(intent);

                break;
            case R.id.b2:
                Log.d(TAG, "B2: onClick: called");
                clearEditTexts();
                break;
            case R.id.b3:
                Log.d(TAG, "B3: onClick: called");
                sendMail();
                break;
            case R.id.b4:
                Log.d(TAG, "B4: onClick called");
                Intent in = new Intent(Intent.ACTION_VIEW);
                //in.setData(Uri.parse("https://google.com"));
                in.setData(Uri.parse("https://docs.google.com/document/d/1HyenEbityao36ukUUtZGknBMTHIcUzYyPrvyXYozkSk/edit?usp=sharing"));
                startActivity(in);
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
        Log.i(TAG, "Send mail");
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("text/plain");
        //email.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"fafj@kea.dk", "test@test.dk"});
        email.putExtra(Intent.EXTRA_SUBJECT, "The Subject");

        String htmlContent = "<h2>Hi Android class</h2> " +
                                "<p>You see the body of the mail :-)</p>" +
                                "<p>Pretty nice...</p>" +
                                "<br>" +
                                "<h3>/Faisal</h3>";

        email.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(htmlContent,1));
        //startActivity(email);
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
        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(this);

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
