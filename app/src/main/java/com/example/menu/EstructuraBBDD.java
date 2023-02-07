package com.example.menu;

import android.provider.BaseColumns;

public final class EstructuraBBDD {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS "+ Equipo.TABLE_NAME_EQUIPO
            +"(" + Equipo._ID + " integer PRIMARY KEY, "
            + Equipo.COLUMN_NOMBRE_EQUIPO + " text, "
            + Equipo.COLUMN_CIUDAD + " text, "
            + Equipo.COLUMN_FOTO + " integer, "
            + Equipo.COLUMN_PUNTOS + " integer);";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EstructuraBBDD.Equipo.TABLE_NAME_EQUIPO;
    private EstructuraBBDD() {}
    /* Clase interna que define la estructura de la tabla de operas */
    public static class Equipo implements BaseColumns {
        public static final String TABLE_NAME_EQUIPO = "equipo";
        public static final String COLUMN_NOMBRE_EQUIPO= "nombre";
        public static final String COLUMN_CIUDAD = "ciudad";
        public static final String COLUMN_FOTO = "foto";
        public static final String COLUMN_PUNTOS = "puntos";
    }
}
