package com.ziyata.mengenalpemimpinpemimpinindonesia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.myRecycleView)
    RecyclerView myRecycleView;

    String[] namaPresiden,isiPresiden;
    int[] imgPresiden;

    Adapter adapterPresiden;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        namaPresiden = getResources().getStringArray(R.array.nama_presiden);
        isiPresiden = getResources().getStringArray(R.array.isi_presiden);
        imgPresiden = new int[]{R.drawable.soekarno,R.drawable.soeharto,R.drawable.habibi,R.drawable.gusdur,R.drawable.megawati,R.drawable.sby,R.drawable.jokowi};

        adapterPresiden = new Adapter(RecycleActivity.this,namaPresiden,isiPresiden,imgPresiden);

        myRecycleView.setHasFixedSize(true);
        myRecycleView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecycleView.setAdapter(adapterPresiden);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    Intent pindah;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.About:
                pindah = new Intent(this, About.class);
                startActivity(pindah);
            case R.id.profile:
                pindah = new Intent(this, Profile.class);
                startActivity(pindah);

        }
        return super.onOptionsItemSelected(item);
    }
}
