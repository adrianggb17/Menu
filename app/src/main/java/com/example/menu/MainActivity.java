package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

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

        inserta2("BarsaMadrid","03/03/2023","FC Barcelona","Real Madrid",0,5);
        inserta2("AlavesCadiz","10/03/2023","Alaves","Cadiz CF",1,0);

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

        private void inserta2(String nombrePartido, String fecha, String equipo1, String equipo2, int resultado1,int resultado2) {
        ContentValues values = new ContentValues();
        values.put("nombreEquipo1", equipo1);
        values.put("nombreEquipo2", equipo2);
        values.put("resultadoEquipo1", resultado1);
        values.put("resultadoEquipo2", resultado2);
        values.put("nombrePartido",nombrePartido);
        values.put("fechaPartido", fecha);
        db.insert("partido", null, values);
    }

    public void iraClasificacion(View view) {
        Intent i = new Intent(this,Clasificacion.class);
        startActivity(i);
    }
    public void iraModificarEquipo(View view) {
        Intent i = new Intent(this,ModificarEquipo.class);
        startActivity(i);
    }
    public void iraModificarPartido(View view) {
        Intent i = new Intent(this,ModificarPartido.class);
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