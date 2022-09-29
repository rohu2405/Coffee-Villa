package com.jr.restrau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void orderNow(View view) {
            CheckBox whipped = findViewById(R.id.checkBox);
            boolean hasWhipped = whipped.isChecked();

            CheckBox chocolate = findViewById(R.id.checkBox2);
            boolean hasChocolate = chocolate.isChecked();
            EditText text = findViewById(R.id.editTextTextPersonName);
            String value = text.getText().toString();
        String orderSummary = " Order Summary :-  " + " \n Hey! " + value + " \n Cost of 1 Coffee is : $" + 10 + " \n Quantity is : " + quantity + " \n Cost is : $" + calculatePrice(hasWhipped , hasChocolate);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, " Coffee order for : " + value);
            intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
            startActivity(Intent.createChooser(intent, "Send Email"));


            displayMessage(orderSummary);

            displayQuantity(quantity);

    }

    private int calculatePrice(boolean whipped , boolean chocolate) {
        int basePrice = 10;
        if(whipped) {
            basePrice = basePrice + 5;
        }

        if(chocolate) {
            basePrice = basePrice + 10;
        }
        return quantity*basePrice;
    }

    private void displayMessage(String orderSummary) {
            TextView priceText = findViewById(R.id.textView4);
            priceText.setText(orderSummary);
    }
    private void displayQuantity(int quantity) {
        TextView quantityText  = findViewById(R.id.textView2);
        quantityText.setText("" + quantity);
    }

    public void increment(View view) {
        if (quantity == 10) {
            Toast.makeText(this , "You Cannont Order more than 10 Coffee", Toast.LENGTH_SHORT).show();
            return;
        }
            quantity = quantity + 1;
            displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity==1) {
            Toast.makeText(this , "You have to Order atleast  1 Coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
}
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("geo:47.6, -123.3"));
//            if(intent.resolveActivity(getPackageManager()) != null) {
//                startActivity(intent);
//            }

// int price = calculatePrice(hasWhipped , hasChocolate);
//    public void orderNow(View view) {
//        String orderSummary = " Order Summary :-  " + " \n Cost of 1 Coffee is : $" + 10 + " \n Quantity is : " + quantity + " \n Cost is : $" + 10*quantity;
//        displayMessage(orderSummary);
//        //displayRate(10);
//        displayQuantity(quantity);
//    }
//
//    private void displayQuantity(int quantity) {
//        TextView quantityText  = findViewById(R.id.textView3);
//        quantityText.setText("" + quantity);
//
//    }
//
//    private void displayRate(int price) {
//        TextView priceText = findViewById(R.id.textView4);
//        priceText.setText(NumberFormat.getCurrencyInstance().format(price));
//    }
//
//    private void displayMessage(String priceMessage) {
//        TextView priceText = findViewById(R.id.textView4);
//        priceText.setText(priceMessage);
//    }
//
//    public void increment(View view) {
//        quantity = quantity + 1;
//        displayQuantity(quantity);
//    }
//
//    public void decrement(View view) {
//        quantity = quantity - 1;
//        displayQuantity(quantity);
//    }