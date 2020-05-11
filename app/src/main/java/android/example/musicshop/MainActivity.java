package android.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

//имплементируем интерфейс слушателя селектов

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
        createMap();
    }

    void createSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("piano");
        spinnerArrayList.add("drums");

        //передаем в ArrayAdapter контекст с SpinnerArrayList

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(spinnerAdapter);

    }

    void createMap(){
        //передаем в HashMap товары и цены
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("piano", 1000.0);
        goodsMap.put("drums", 1400.0);
    }


    public void increaseQuantity(View view) {
        quantity = quantity +1 ;
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);

    }

    public void decreaseQuantity(View view) {
        quantity = quantity -1 ;
        if(quantity < 0){
            quantity = 0;
        }
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = ( double ) goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);

        ImageView goodsImageView = findViewById(R.id.goodsImageView);

        switch (goodsName) {
            case "guitar":
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
            case "piano":
                goodsImageView.setImageResource(R.drawable.piano);
                break;
            case "drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
