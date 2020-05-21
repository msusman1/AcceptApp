package com.paymob.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.paymob.acceptsdk.IntentConstants;
import com.paymob.acceptsdk.PayActivity;
import com.paymob.acceptsdk.PayActivityIntentKeys;
import com.paymob.acceptsdk.PayResponseKeys;
import com.paymob.acceptsdk.SaveCardResponseKeys;
import com.paymob.acceptsdk.ToastMaker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;

    // Arbitrary number and used only in this activity. Change it as you wish.
    static final int ACCEPT_PAYMENT_REQUEST = 10;

    // Replace this with your actual payment key
//    final String paymentKey = "ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKSVV6VXhNaUo5LmV5SmhiVzkxYm5SZlkyVnVkSE1pT2pFd01EQXNJbU4xY25KbGJtTjVJam9pUlVkUUlpd2liM0prWlhKZmFXUWlPak01TXpFeUxDSjFjMlZ5WDJsa0lqb3pNU3dpWTJGeVpGOXBiblJsWjNKaGRHbHZibDlwWkNJNk16RXNJbUpwYkd4cGJtZGZaR0YwWVNJNmV5Sm1hWEp6ZEY5dVlXMWxJam9pUTJ4cFptWnZjbVFpTENKc1lYTjBYMjVoYldVaU9pSk9hV052YkdGeklpd2ljM1J5WldWMElqb2lSWFJvWVc0Z1RHRnVaQ0lzSW1KMWFXeGthVzVuSWpvaU9EQXlPQ0lzSW1ac2IyOXlJam9pTkRJaUxDSmhjR0Z5ZEcxbGJuUWlPaUk0TURNaUxDSmphWFI1SWpvaVNtRnphMjlzYzJ0cFluVnlaMmdpTENKemRHRjBaU0k2SWxWMFlXZ2lMQ0pqYjNWdWRISjVJam9pUTFJaUxDSmxiV0ZwYkNJNkltTnNZWFZrWlhSMFpUQTVRR1Y0WVM1amIyMGlMQ0p3YUc5dVpWOXVkVzFpWlhJaU9pSXJPRFlvT0NrNU1UTTFNakV3TkRnM0lpd2ljRzl6ZEdGc1gyTnZaR1VpT2lJd01UZzVPQ0o5ZlEuLTBtVFNZdzRiT0htSFpoRUlkd3p4d0tDUWtEY3d0OEgwMEVBQWEzX0VNS3ZJLXAwdjhYcm1FOGRXSThJQ2ZXdnZtUlduZ1owLU01WXU1XzVMbklqYXc=";
    //usmaan key
    String paymentKey = "ZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKSVV6VXhNaUo5LmV5SnZjbVJsY2w5cFpDSTZOVEE0TVRFMk1pd2ljRzFyWDJsd0lqb2lNemt1TlRJdU1UTTNMakl6TnlJc0luVnpaWEpmYVdRaU9qRXlPVFUwTENKaWFXeHNhVzVuWDJSaGRHRWlPbnNpWm1seWMzUmZibUZ0WlNJNklrTnNhV1ptYjNKa0lpd2liR0Z6ZEY5dVlXMWxJam9pVG1samIyeGhjeUlzSW5OMGNtVmxkQ0k2SWtWMGFHRnVJRXhoYm1RaUxDSmlkV2xzWkdsdVp5STZJamd3TWpnaUxDSm1iRzl2Y2lJNklqUXlJaXdpWVhCaGNuUnRaVzUwSWpvaU9EQXpJaXdpWTJsMGVTSTZJa3BoYzJ0dmJITnJhV0oxY21kb0lpd2ljM1JoZEdVaU9pSlZkR0ZvSWl3aVkyOTFiblJ5ZVNJNklrTlNJaXdpWlcxaGFXd2lPaUpqYkdGMVpHVjBkR1V3T1VCbGVHRXVZMjl0SWl3aWNHaHZibVZmYm5WdFltVnlJam9pS3pnMktEZ3BPVEV6TlRJeE1EUTROeUlzSW5CdmMzUmhiRjlqYjJSbElqb2lNREU0T1RnaUxDSmxlSFJ5WVY5a1pYTmpjbWx3ZEdsdmJpSTZJazVCSW4wc0ltTjFjbkpsYm1ONUlqb2lSVWRRSWl3aVlXMXZkVzUwWDJObGJuUnpJam8xTURBd0xDSnNiMk5yWDI5eVpHVnlYM2RvWlc1ZmNHRnBaQ0k2Wm1Gc2MyVXNJbU5oY21SZmFXNTBaV2R5WVhScGIyNWZhV1FpT2pFNE56SXhmUS5qZDR2bjRNczNzTUsxSGNvYjRyNlRYWVpDUXJRMmw5bTIzTUZsUk9xdl9PdWVXV3VaQ1VrM3BwMGltWk9xdmRlMzVTQTkwOXFWVlgzV01NZzU4MkxYdw==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.Button1);
        Button button4 = findViewById(R.id.Button4);
        button1.setOnClickListener(this);
        button4.setOnClickListener(this);
        button2 = findViewById(R.id.Button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.Button3);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button1:
                startPayActivityNoToken(true);
                break;
            case R.id.Button4:
//                int number = GFG.findNumber();

                int number = new Tests().adslkfasdjflk();
                Toast.makeText(this, "Number is " + number, Toast.LENGTH_SHORT).show();


                break;
            case R.id.Button2:
                startPayActivityNoToken(false);
                break;
            case R.id.Button3:
                startPayActivityToken();
                break;
        }
    }


    private void startPayActivityNoToken(Boolean showSaveCard) {
        Intent pay_intent = new Intent(this, PayActivity.class);

        putNormalExtras(pay_intent);
        pay_intent.putExtra(PayActivityIntentKeys.SAVE_CARD_DEFAULT, true);
        pay_intent.putExtra(PayActivityIntentKeys.SHOW_ALERTS, showSaveCard);
        pay_intent.putExtra(PayActivityIntentKeys.SHOW_SAVE_CARD, showSaveCard);
        pay_intent.putExtra(PayActivityIntentKeys.BUTTON_COLOR, 0x8033B5E5);

        startActivityForResult(pay_intent, ACCEPT_PAYMENT_REQUEST);
    }

    private void startPayActivityToken() {
        Intent pay_intent = new Intent(this, PayActivity.class);

        putNormalExtras(pay_intent);
        // replace this with your actual card token
        pay_intent.putExtra(PayActivityIntentKeys.TOKEN, "token");
        pay_intent.putExtra(PayActivityIntentKeys.MASKED_PAN_NUMBER, "xxxx-xxxx-xxxx-1234");
        pay_intent.putExtra(PayActivityIntentKeys.SAVE_CARD_DEFAULT, false);
        pay_intent.putExtra(PayActivityIntentKeys.SHOW_ALERTS, true);
        pay_intent.putExtra(PayActivityIntentKeys.SHOW_SAVE_CARD, false);

        startActivityForResult(pay_intent, ACCEPT_PAYMENT_REQUEST);
    }

    private void putNormalExtras(Intent intent) {
        // Pass the correct values for the billing data keys
        intent.putExtra(PayActivityIntentKeys.FIRST_NAME, "firsy_name");
        intent.putExtra(PayActivityIntentKeys.LAST_NAME, "last_name");
        intent.putExtra(PayActivityIntentKeys.BUILDING, "1");
        intent.putExtra(PayActivityIntentKeys.FLOOR, "1");
        intent.putExtra(PayActivityIntentKeys.APARTMENT, "1");
        intent.putExtra(PayActivityIntentKeys.CITY, "cairo");
        intent.putExtra(PayActivityIntentKeys.STATE, "new_cairo");
        intent.putExtra(PayActivityIntentKeys.COUNTRY, "egypt");
        intent.putExtra(PayActivityIntentKeys.EMAIL, "email@gmail.com");
        intent.putExtra(PayActivityIntentKeys.PHONE_NUMBER, "2345678");
        intent.putExtra(PayActivityIntentKeys.POSTAL_CODE, "3456");

        intent.putExtra(PayActivityIntentKeys.PAYMENT_KEY, paymentKey);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle extras = data.getExtras();
        Log.d("mainextras:",new Tests().getStrings(extras));
        Log.d("mainextraw:",extras.toString());

        if (requestCode == ACCEPT_PAYMENT_REQUEST) {
            final int acceptResultCode = extras.getInt(IntentConstants.ACCEPT_RESULT_CODE, 0);

            if (acceptResultCode == 0) {
                ToastMaker.displayLongToast(this, "No ACCEPT_RESULT_CODE returned!!");
            } else if (acceptResultCode == IntentConstants.USER_CANCELED) {
                // User canceled and did no payment request was fired
                ToastMaker.displayLongToast(this, "User canceled!!");
            } else if (acceptResultCode == IntentConstants.MISSING_ARGUMENT) {
                // You forgot to pass an important key-value pair in the intent's extras
                ToastMaker.displayLongToast(this, "Missing Argument == " + extras.getString(IntentConstants.MISSING_ARGUMENT_VALUE));
            } else if (acceptResultCode == IntentConstants.TRANSACTION_ERROR) {
                // An error occurred while handling an API's response
                ToastMaker.displayLongToast(this, "Reason == " + extras.getString(IntentConstants.TRANSACTION_ERROR_REASON));
            } else if (acceptResultCode == IntentConstants.TRANSACTION_REJECTED) {
                // User attempted to pay but their transaction was rejected

                // Use the static keys declared in PayResponseKeys to extract the fields you want
                ToastMaker.displayLongToast(this, extras.getString(PayResponseKeys.DATA_MESSAGE));
            } else if (acceptResultCode == IntentConstants.TRANSACTION_REJECTED_PARSING_ISSUE) {
                // User attempted to pay but their transaction was rejected. An error occured while reading the returned JSON
                ToastMaker.displayLongToast(this, extras.getString(IntentConstants.RAW_PAY_RESPONSE));
            } else if (acceptResultCode == IntentConstants.TRANSACTION_SUCCESSFUL) {
                // User finished their payment successfully

                // Use the static keys declared in PayResponseKeys to extract the fields you want
                ToastMaker.displayLongToast(this, extras.getString(PayResponseKeys.DATA_MESSAGE));
            } else if (acceptResultCode == IntentConstants.TRANSACTION_SUCCESSFUL_PARSING_ISSUE) {
                // User finished their payment successfully. An error occured while reading the returned JSON.
                ToastMaker.displayLongToast(this, extras.getString(IntentConstants.RAW_PAY_RESPONSE));
            } else if (acceptResultCode == IntentConstants.TRANSACTION_SUCCESSFUL_CARD_SAVED) {
                // User finished their payment successfully and card was saved.

                // Use the static keys declared in PayResponseKeys to extract the fields you want
                // Use the static keys declared in SaveCardResponseKeys to extract the fields you want
                ToastMaker.displayLongToast(this, "Token == " + extras.getString(SaveCardResponseKeys.TOKEN));
            }
        }
    }
}
