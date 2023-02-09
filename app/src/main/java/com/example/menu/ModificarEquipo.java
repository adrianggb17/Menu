package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ModificarEquipo extends AppCompatActivity {
    EditText txtTexto,txtTexto2,txtTexto3,txtTexto4,txtTexto5,txtTexto6;
    SQLiteDatabase db;
    SQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_equipo);
        txtTexto=findViewById(R.id.editTextTextPersonName);
        txtTexto2=findViewById(R.id.editTextTextPersonName4);
        txtTexto3=findViewById(R.id.editTextTextPersonName5);
        txtTexto4=findViewById(R.id.editTextTextPersonName6);
        txtTexto5=findViewById(R.id.editTextTextPersonName2);
        txtTexto6=findViewById(R.id.editTextTextPersonName3);
        helper = new SQLiteHelper(this);
        db= helper.getWritableDatabase();
    }

    public void iraMenu(View view) {
        Intent i = new Intent(this,Clasificacion.class);
        startActivity(i);
    }

    public void eliminar(View view) {
        String resultado= String.valueOf(txtTexto.getText());
        db.delete("equipo","nombre=?",new String[]{resultado});
        Toast.makeText(getApplicationContext(), "Has eliminado el equipo", Toast.LENGTH_SHORT).show();
    }

    public void añadir(View view) {
        String equipo= String.valueOf(txtTexto2.getText());
        String ciudad= String.valueOf(txtTexto3.getText());
        int puntos = Integer.parseInt(String.valueOf(txtTexto4.getText()));
        inserta(equipo,ciudad,puntos,R.drawable.rayo);
        Toast.makeText(getApplicationContext(), "Has añadido un nuevo equipo", Toast.LENGTH_SHORT).show();
    }

    private void inserta(String equipo, String ciudad, int puntos,int foto) {
        ContentValues values = new ContentValues();
        values.put("nombre", equipo);
        values.put("ciudad", ciudad);
        values.put("puntos", puntos);
        values.put("foto", foto);
        db.insert("equipo", null, values);
    }

    public void modificar(View view) {
        ContentValues cv = new ContentValues();
        cv.put("ciudad", String.valueOf(txtTexto6.getText()));
        String ciudad = String.valueOf(txtTexto6.getText());
        String nombre = String.valueOf(txtTexto5.getText());
        String sql = "UPDATE FROM equipo SET ciudad='" + ciudad + "' WHERE nombre='" + nombre + "'";
        db.update("equipo",cv,"nombre=?",new String[]{nombre});
        Toast.makeText(getApplicationContext(), "Has modificado el equipo", Toast.LENGTH_SHORT).show();

    }
}