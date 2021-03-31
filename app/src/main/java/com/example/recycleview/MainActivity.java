package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycleview.adapter.CatRcvAdapter;
import com.example.recycleview.adapter.ListImgAdapter;
import com.example.recycleview.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spiner;
    private List<Integer> rsImgs;
    private ListImgAdapter spinerAdapter;
    private RecyclerView rcv;
    private List<Cat> cats;
    private Button btnAdd;
    private TextView txtName, txtWeight;
    private CatRcvAdapter catAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        rsImgs.add(R.drawable.cat1);
        rsImgs.add(R.drawable.cat2);
        rsImgs.add(R.drawable.cat3);
        rsImgs.add(R.drawable.cat4);
        rsImgs.add(R.drawable.cat5);
        rsImgs.add(R.drawable.cat6);
        spinerAdapter = new ListImgAdapter(this,rsImgs);
        spiner.setAdapter(spinerAdapter);
    }
    public void initView(){
        txtName = findViewById(R.id.txtName);
        txtWeight = findViewById(R.id.txtWeight);
        spiner = findViewById(R.id.spinner);
        rcv = findViewById(R.id.rcv);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        rsImgs = new ArrayList<>();
        cats = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv.setLayoutManager(layoutManager);
        catAdapter = new CatRcvAdapter(this,cats);
        rcv.setAdapter(catAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v==btnAdd){
            //Toast.makeText(this,""+spiner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            cats.add(new Cat((int)spiner.getSelectedItem(),txtName.getText().toString(),Double.parseDouble(txtWeight.getText().toString())));
            catAdapter.notifyDataSetChanged();

        }
    }
}