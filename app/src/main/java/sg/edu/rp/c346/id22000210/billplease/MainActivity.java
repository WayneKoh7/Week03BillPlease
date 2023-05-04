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


        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (amountText.getText().toString().trim().length() != 0 &&
                        numOfPaxText.getText().toString().trim().length() != 0) {
                    double newAmt = 0.0;
                    double oldAmt = newAmt = Double.parseDouble(amountText.getText().toString());
                    if (!svs.isChecked() && !gst.isChecked()) {
                        newAmt = oldAmt;
                    } else if (svs.isChecked() && !gst.isChecked()) {
                        newAmt = oldAmt * 1.1;
                    } else if (!svs.isChecked() && gst.isChecked()) {
                        newAmt = oldAmt * 1.08;
                    } else {
                        newAmt = ((oldAmt * 1.1) * 1.08);
                    }

                    //Discount %
                    if (discountText.getText().toString().trim().length() != 0) {

                        newAmt = 1 - oldAmt / 100;
                    }

                    totalBill.setText("Total Bill: $" + String.format("%.2f", newAmt));
                    int people = Integer.parseInt(numOfPaxText.getText().toString());
                    if (people != 1) {
                        eachPays.setText("Each Pays: $" + String.format("%.2f", newAmt / people));
                    } else {
                        eachPays.setText("Each Pays: $" + newAmt);
                    }
                }
10
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountText.setText("");
                numOfPaxText.setText("");
                svs.setChecked(false);
                gst.setChecked(false);
                discountText.setText("");
            }
        });
    }
}