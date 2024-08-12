package com.example.axforasset;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

public class ProductDetailActivity extends AppCompatActivity {
    private EditText emailInput;
    private Button buyButton;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView imageView = findViewById(R.id.detail_image);
        TextView titleView = findViewById(R.id.detail_title);
        TextView descriptionView = findViewById(R.id.detail_description);
        Spinner paymentSpinner = findViewById(R.id.payment_spinner);
        ImageView backBtn = findViewById(R.id.back_button);
        backBtn.setOnClickListener(v -> onBackPressed());

        emailInput = findViewById(R.id.email_input);
        buyButton = findViewById(R.id.buy_button);

        buyButton.setOnClickListener(v -> {
            validateAndBuy();
        });

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("EXTRA_TITLE");
            String description = intent.getStringExtra("EXTRA_PREVIEW");
            int imageId = intent.getIntExtra("EXTRA_IMAGE_ID", 0);

            titleView.setText(title);
            descriptionView.setText(description);
            imageView.setImageResource(imageId);
        }
    }

    @Override
    protected void onDestroy() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        super.onDestroy();
    }

    private void validateAndBuy() {
        String email = emailInput.getText().toString();
        if (email.isEmpty()) {
            showDialog("Email must be filled                         ", false);
//            showSimpleDialog();
        } else if (!email.contains("@gmail.com")) {

            showDialog("Email must contain '@gmail.com'   ", false);
        } else {
            // Proceed with the purchase
            showDialog("Confirmation email has been sent to your email address", true);
        }
    }

//    private void showToast(String message) {
//        Toast.makeText(ProductDetailActivity.this, message, Toast.LENGTH_SHORT).show();
//    }
    private void showDialog(String message, boolean isSuccess) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialogTheme);
        // Inflate custom layout
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_custom, null);

        TextView title = dialogView.findViewById(R.id.dialog_title);
        TextView messageText = dialogView.findViewById(R.id.dialog_message);
        Button button = dialogView.findViewById(R.id.dialog_button);

        if (title == null || messageText == null || button == null) {
            Log.e("Dialog", "Failed to find one or more views in the custom layout");
            return;
        }

        if (isSuccess) {
            title.setText("Success!");
            button.setText("Back to item list");

        } else {
            title.setText("Error");
        }
        messageText.setText(message);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // Close the dialog when the button is clicked
                if (isSuccess) {
                    // Redirect to the item list activity
                    Intent intent = new Intent(ProductDetailActivity.this, ListItemActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish(); // Close the current activity
                }
            }

        });

        dialog.show();
    }
    private void showSimpleDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Simple Dialog")
                .setMessage("This is a simple dialog.")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }




}
