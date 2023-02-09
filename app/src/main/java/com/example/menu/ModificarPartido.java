package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ModificarPartido extends AppCompatActivity {
    EditText txtTexto,txtTexto2,txtTexto3,txtTexto4,txtTexto5,txtTexto6,txtTexto7,txtTexto8,txtTexto9;
    SQLiteDatabase db;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_partido);
        helper = new SQLiteHelper(this);
        db= helper.getWritableDatabase();
        txtTexto=findViewById(R.id.editTextTextPersonName7);
        txtTexto2=findViewById(R.id.editTextTextPersonName8);
        txtTexto3=findViewById(R.id.editTextTextPersonName9);
        txtTexto4=findViewById(R.id.editTextTextPersonName10);
        txtTexto5=findViewById(R.id.editTextTextPersonName11);
        txtTexto6=findViewById(R.id.editTextTextPersonName12);
        txtTexto7=findViewById(R.id.editTextTextPersonName13);
        txtTexto8=findViewById(R.id.editTextTextPersonName14);
        txtTexto9=findViewById(R.id.editTextTextPersonName15);
    }

    public void iraClasificacion(View view) {
        Intent i = new Intent(this,Clasificacion.class);
        startActivity(i);
    }

    public void eliminar(View view) {
        String nombre = String.valueOf(txtTexto.getText());
        db.delete("partido","nombrePartido=?",new String[]{nombre});
        Toast.makeText(getApplicationContext(), "Has eliminado el partido", Toast.LENGTH_SHORT).show();
    }

    public void añadir(View view) {
        String partido= String.valueOf(txtTexto4.getText());
        String fecha= String.valueOf(txtTexto5.getText());
        String equipo1= String.valueOf(txtTexto6.getText());
        String equipo2 = String.valueOf(txtTexto7.getText());
        int resultado1 = Integer.parseInt(String.valueOf(txtTexto8.getText()));
        int resultado2 = Integer.parseInt(String.valueOf(txtTexto9.getText()));
        Toast.makeText(getApplicationContext(), "Has añadido un nuevo partido", Toast.LENGTH_SHORT).show();
        inserta2(partido,fecha,equipo1,equipo2,resultado1,resultado2);
        if(resultado1>resultado2){
            String sql = "UPDATE  equipo SET puntos='3' WHERE nombre='" + equipo1 + "'";
            db.execSQL(sql);
        }else if(resultado1<resultado2){
            String sql = "UPDATE  equipo SET puntos='3' WHERE nombre='" + equipo2 + "'";
            db.execSQL(sql);
        }else{
            String sql = "UPDATE  equipo SET puntos='1' WHERE nombre='" + equipo1 + "'";
            db.execSQL(sql);
            String sql2 = "UPDATE  equipo SET puntos='1' WHERE nombre='" + equipo2 + "'";
            db.execSQL(sql2);
        }
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

    public void modificar(View view) {
        ContentValues cv = new ContentValues();
        cv.put("resultadoEquipo1", String.valueOf(txtTexto3.getText()));
        String resultado1 = String.valueOf(txtTexto3.getText());
        String nombre = String.valueOf(txtTexto2.getText());
        db.update("partido",cv,"nombreEquipo1=?",new String[]{nombre});
        Toast.makeText(getApplicationContext(), "Has modificado el partido", Toast.LENGTH_SHORT).show();
        /*ContentValues cv2 = new ContentValues();
        cv2.put("puntos", puntos+3);
        db.update("equipo",cv2,"partido.nombreEquipo1=?",new String[]{nombre});*/

        String sql = "UPDATE  equipo SET puntos='3' WHERE nombre='" + nombre + "'";
        db.execSQL(sql);

    }
}