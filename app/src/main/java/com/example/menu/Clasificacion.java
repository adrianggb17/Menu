package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Clasificacion extends AppCompatActivity implements AdapterView.OnItemClickListener {
    SQLiteHelper helper;
    SQLiteDatabase db;
    ListView lv;
    TextView txtTexto1,txtTexto2,txtTexto3;
    ImageView imgViewFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion);
        lv = findViewById(R.id.lstListaModif);
        txtTexto1= findViewById(R.id.textView);
        txtTexto2= findViewById(R.id.textView2);
        txtTexto3= findViewById(R.id.textView0);
        imgViewFoto = findViewById(R.id.imageView);
        consultaOperas();
        lv.setOnItemClickListener(this);
    }

    private void consultaOperas(){
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();
        Cursor cursor =
                db.query(EstructuraBBDD.Equipo.TABLE_NAME_EQUIPO, null,
                        null, null, null, null, null);
        //adaptamos el cursor a nuestro ListView
        String[] from = {EstructuraBBDD.Equipo.COLUMN_NOMBRE_EQUIPO,
                EstructuraBBDD.Equipo.COLUMN_CIUDAD,
                EstructuraBBDD.Equipo.COLUMN_PUNTOS,
                EstructuraBBDD.Equipo.COLUMN_FOTO};
        int[] to = {R.id.textView3, R.id.textView4,R.id.textView5,R.id.imageViewItem};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this,
                R.layout.equipo, cursor, from, to,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adaptador);
        db.close();

    }

    public void onItemClick(AdapterView<?> listView, View view, int position, long id) {

        Cursor cursor=(Cursor) listView.getItemAtPosition(position);
        int _id=cursor.getInt(0);
        String equipo=cursor.getString(1) ;
        String ciudad=cursor.getString(2 ) ;
        int puntos=cursor.getInt(4);
        int foto= cursor.getInt(3);

        txtTexto1.setText(_id +", "+equipo);
        txtTexto2.setText(", ciudad: "+ciudad);
        txtTexto3.setText(", puntos: "+puntos);
        imgViewFoto.setBackgroundResource(foto);


    }

    public void iraMenu(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
