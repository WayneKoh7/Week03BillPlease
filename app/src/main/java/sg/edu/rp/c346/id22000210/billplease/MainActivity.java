package sg.edu.rp.c346.id22000210.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    //Declaring the Variable Fields
    EditText amountText;
    EditText numOfPaxText;
    ToggleButton svs;
    ToggleButton gst;
    EditText discountText;
    Button split;
    Button reset;
    RadioGroup payment;
    TextView totalBill;
    TextView eachPays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountText = findViewById(R.id.enterAmount);
        numOfPaxText = findViewById(R.id.enterNumOfPax);
        svs = findViewById(R.id.toggleButtonSVS);
        gst = findViewById(R.id.toggleButtonGST);
        discountText = findViewById(R.id.enterDiscount);
        split = findViewById(R.id.split);
        reset = findViewById(R.id.reset);
        payment = findViewById(R.id.rgPayment);
        totalBill = findViewById(R.id.textTotalBill);
        eachPays = findViewById(R.id.textEachPays);

    }


      split.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(amountText.getText().toString().trim().length() != 0 &&
                    numOfPaxText.getText().toString().trim().length() != 0) {
                double newAmt = 0.0;
                if (!svs.isChecked() && !gst.isChecked()) {
                    newAmt = Double.parseDouble(amountText.getText().toString());
                }
            }
        }

    });


}