package com.example.manas.tnp.tpo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static java.lang.Float.parseFloat;


public class EditDetailsActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListner;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private FirebaseStorage mFirebaseStorage;
    private StorageReference mChatPhotoStorageReference;
    private Spinner branchSpinner;
    private Spinner genderSpinner;
    private EditText name;
    private EditText phone;
    private EditText enroll;
    private EditText grade_10;
    private EditText grade_12;
    private EditText grade_gra;
    private EditText email;
    private EditText address;
    private Button submit;
    private String gender_val;
    private String branch_val;
    private String usr_el;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        Intent mainActivity = getIntent();
        usr_el = mainActivity.getStringExtra("user_email");
        gender_val = null;
        branch_val = null;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference();
        branchSpinner = findViewById(R.id.spinner);
        genderSpinner = findViewById(R.id.spinner2);
        setUpSpinner();
        name = findViewById(R.id.name_edit);
        phone = findViewById(R.id.phone_edit);
        enroll = findViewById(R.id.enrollment_edit);
        grade_10 = findViewById(R.id.grade_10_edit);
        grade_12 = findViewById(R.id.grade_12_edit);
        grade_gra = findViewById(R.id.grade_grad_edit);
        email = findViewById(R.id.email_edit);
        address = findViewById(R.id.address_edit);
        submit = findViewById(R.id.submit);
        email.setText(usr_el);
        email.setEnabled(false);
        String temp = usr_el;

        mMessagesDatabaseReference.child("StudentData").child(temp.replace('.',',')).child("details").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{StudentDetails det = dataSnapshot.getValue(StudentDetails.class);
                name.setText(det.getName());
                phone.setText(det.getPhone_no());
                enroll.setText(det.getEnrollment());
                grade_10.setText(Float.toString(det.getGrades_10()));
                grade_12.setText(Float.toString(det.getGrades_12()));
                grade_gra.setText(Float.toString(det.getGrades_grad()));
                address.setText(det.getAddress());}catch(Exception e){
                    Toast.makeText(EditDetailsActivity.this, "You are not registered, Please enter details!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StudentDetails student_det = new StudentDetails(name.getText().toString(), phone.getText().toString(), enroll.getText().toString(), Float.parseFloat(grade_10.getText().toString()), Float.parseFloat(grade_12.getText().toString()), Float.parseFloat(grade_gra.getText().toString()), address.getText().toString(), usr_el, gender_val, branch_val);
                mMessagesDatabaseReference.child("StudentData").child(usr_el.replace('.', ',')).child("details").setValue(student_det);
                Toast.makeText(EditDetailsActivity.this, "Details Updated", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditDetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void setUpSpinner() {
        ArrayAdapter branchspinneradapter = ArrayAdapter.createFromResource(this, R.array.array_branch_options, android.R.layout.simple_spinner_item);
        branchspinneradapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        branchSpinner.setAdapter(branchspinneradapter);
        ArrayAdapter genderspinneradapter = ArrayAdapter.createFromResource(this, R.array.array_gender_options, android.R.layout.simple_spinner_item);
        genderspinneradapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        genderSpinner.setAdapter(genderspinneradapter);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                gender_val = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                gender_val = "Male";
            }
        });

        branchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                branch_val = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                branch_val = "Computer Engg.";
            }
        });
    }
}


