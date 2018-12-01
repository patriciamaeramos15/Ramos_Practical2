package patricia.ramos.com.ramos_practical2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText eFname, eLname, eGrade, eGrade2;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eFname = findViewById(R.id.eFirst);
        eLname = findViewById(R.id.eLast);
        eGrade = findViewById(R.id.eGrade);
        eGrade2 = findViewById(R.id.eGrade2);
        display = findViewById(R.id.display);
    }



    public void addRecord(View v) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference("table");
        String fname = eFname.getText().toString().trim();
        String lname = eLname.getText().toString().trim();
        Long grade = Long.parseLong(eGrade.getText().toString().trim());
        Long grade2 = Long.parseLong(eGrade2.getText().toString().trim());

        Long average = (grade + grade2) /2;
        Student sgrade = new Student(fname,lname,average);
        String key = root.push().getKey();
        root.child(key).setValue(sgrade);
        Toast.makeText(this,"record added to db",Toast.LENGTH_LONG).show();
        display.setText("Your Average is:" +average);


    }










}