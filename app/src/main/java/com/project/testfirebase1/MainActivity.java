package com.project.testfirebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtPesan = (EditText)findViewById(R.id.edt_pesan);
        Button btnSend = (Button)findViewById(R.id.btn_pesan);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edtPesan.getText().toString();
                sendData(data);
                Toast.makeText(MainActivity.this, "terkirim", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void sendData(String pesan) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("pesan");

        myRef.setValue(pesan);
    }
}
