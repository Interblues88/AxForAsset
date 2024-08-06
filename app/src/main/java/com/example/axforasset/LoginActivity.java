package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button registerBtn;
    EditText usernameInput, passwordInput;
    TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView imageView = findViewById(R.id.logo);
        // Set new layout parameters
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = 600;
        imageView.setLayoutParams(params);

        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        registerBtn = findViewById(R.id.registerBtn);
        errorMessage = findViewById(R.id.error_message);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (validateInputs(username, password)) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("USERNAME", username); // Pass the username
                    startActivity(intent);
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private boolean validateInputs(String username, String password) {
        if (username.isEmpty()) {
            errorMessage.setText("Username must not be empty!");
            return false;
        }
        if (password.isEmpty()) {
            errorMessage.setText("Password must not be empty!");
            return false;
        }
        if (password.length() < 8) {
            errorMessage.setText("Password must be at least 8 characters!");
            return false;
        }
        errorMessage.setText(""); // Clear error message if validation passes
        return true;
    }
}
