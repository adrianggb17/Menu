package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteHelper helper;
    MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new SQLiteHelper(this);
        db= helper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("nombre", "Real Madrid");
        values.put("ciudad", "Madrid");
        values.put("puntos", 0);
        values.put("foto",R.drawable.realmadrid);
        db.insert("equipo",null, values);

        db.delete("equipo","_id>1", null);

        inserta("Alaves","Vitoria",0,R.drawable.alaves);
        inserta("Atletico de Madrid","Madrid",0,R.drawable.atletico);
        inserta("FC Barcelona","Barcelona",0,R.drawable.barsa);
        inserta("Cadiz CF","Cadiz",0,R.drawable.cadiz);
        inserta("Cordoba CF","Cordoba",0,R.drawable.cordoba);
        db.close();
    }

    private void inserta(String equipo, String ciudad, int puntos,int foto) {
        ContentValues values = new ContentValues();
        values.put("nombre", equipo);
        values.put("ciudad", ciudad);
        values.put("puntos", puntos);
        values.put("foto", foto);
        db.insert("equipo", null, values);
    }

    public void iraClasificacion(View view) {
        Intent i = new Intent(this,Clasificacion.class);
        startActivity(i);
    }

    public void play (View view){
        if(media==null) {
            media= MediaPlayer.create(this, R.raw.himno);
        }
        if(!media.isPlaying()){
            media.start();
        }
    }

    public void stop (View view){
        if(media.isPlaying()){
            media.stop();
            media.release();
            media=null;
        }
    }
}