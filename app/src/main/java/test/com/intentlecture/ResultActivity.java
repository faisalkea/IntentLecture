package test.com.intentlecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private static String TAG = "ResultActivity";

    private TextView t1, t2, t3, t4, t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Student stud = getIntent().getParcelableExtra(MainActivity.STUD);
        Log.i(TAG, "Received" + stud);

        init();

        setStudDataInView(stud);

    }

    private void setStudDataInView(Student stud) {
        Log.i(TAG, "setStudDataInView called");
        t1.setText(stud.getFirstName());
        t2.setText(stud.getLastName());
        t3.setText(stud.getCpr());
        t4.setText(stud.getEmail());
        t5.setText(stud.getPassword());
    }

    private void init() {
        Log.i(TAG, "Init called");
        t1 = findViewById(R.id.tv1);
        t2 = findViewById(R.id.tv2);
        t3 = findViewById(R.id.tv3);
        t4 = findViewById(R.id.tv4);
        t5 = findViewById(R.id.tv5);
    }


}
