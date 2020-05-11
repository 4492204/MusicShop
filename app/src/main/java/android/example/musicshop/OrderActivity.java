package android.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent recivedorderIntent = getIntent();
        String userName = recivedorderIntent.getStringExtra("userName");
        String goodsName = recivedorderIntent.getStringExtra("goodsName");
        int quantity = recivedorderIntent.getIntExtra("quantity", 0);
        double orderPrice = recivedorderIntent.getDoubleExtra("orderPrice",0);

        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText(userName + "\n" + goodsName + "\n" + quantity + "\n" + orderPrice);



    }
}
