package com.example.sixthtimesacharm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button addCity;
    Button deleteCity;
    EditText editText;
    Button enterButton;
    Integer selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addCity = findViewById(R.id.add_button);
        deleteCity = findViewById(R.id.delete_button);
        cityList = findViewById(R.id.city_list);
        editText = (EditText) findViewById(R.id.edit_text_id);
        enterButton = (Button) findViewById(R.id.enter_button);
        String[] cities = {"Edmonton", "Vancouver"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        addCity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "User tapped the add button");
                editText.setVisibility(View.VISIBLE);
                enterButton.setVisibility(View.VISIBLE);
            }
        });
        enterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "User tapped the enter button");
                String str = editText.getText().toString();
                cityAdapter.add(str);
                editText.setVisibility(View.GONE);
                enterButton.setVisibility(View.GONE);
                editText.setText("");
            }
        });
        deleteCity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "User tapped the delete button");
                if (selectedIndex > -1){
                    cityAdapter.remove(cityAdapter.getItem(selectedIndex));
                    selectedIndex=-1;
                }
            }
        });
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex = i;
            }
        });
    }
}