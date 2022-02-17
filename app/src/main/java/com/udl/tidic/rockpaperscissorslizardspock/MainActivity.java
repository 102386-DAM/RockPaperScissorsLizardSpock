package com.udl.tidic.rockpaperscissorslizardspock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_start);
        EditText text_name = findViewById(R.id.name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = text_name.getText().toString();

                if (name.equals("") || name.equals("name")) {
                    Toast.makeText(getApplicationContext(), "Enter your name to continute", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });
    }
}