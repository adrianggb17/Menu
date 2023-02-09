package com.example.menu;

import android.provider.BaseColumns;

public final class EstructuraBBDD {
    public static final String SQL_CREATE_EQUIPO =
            "CREATE TABLE IF NOT EXISTS "+ Equipo.TABLE_NAME_EQUIPO
            +"(" + Equipo._ID + " integer PRIMARY KEY, "
            + Equipo.COLUMN_NOMBRE_EQUIPO + " text, "
            + Equipo.COLUMN_CIUDAD + " text, "
            + Equipo.COLUMN_FOTO + " integer, "
            + Equipo.COLUMN_PUNTOS + " integer);";
    public static final String SQL_DELETE_EQUIPO =
            "DROP TABLE IF EXISTS " + EstructuraBBDD.Equipo.TABLE_NAME_EQUIPO;

    public static final String SQL_CREATE_PARTIDO =
            "CREATE TABLE IF NOT EXISTS "+ Partido.TABLE_NAME_PARTIDO
                    +"(" + Partido._ID + " integer PRIMARY KEY, "
                    + Partido.COLUMN_NOMBRE_PARTIDO + " text, "
                    + Partido.COLUMN_FECHA_PARTIDO + " text,"
                    + Partido.COLUMN_NOMBRE_EQUIPO_1 + " text, "
                    + Partido.COLUMN_NOMBRE_EQUIPO_2 + " text, "
                    + Partido.COLUMN_RESULTADO_1 + " integer,"
                    + Partido.COLUMN_RESULTADO_2 + " integer);";

    public static final String SQL_DELETE_PARTIDO =
            "DROP TABLE IF EXISTS " + EstructuraBBDD.Partido.TABLE_NAME_PARTIDO;

    private EstructuraBBDD() {}
    /* Clase interna que define la estructura de la tabla de operas */
    public static class Equipo implements BaseColumns {
        public static final String TABLE_NAME_EQUIPO = "equipo";
        public static final String COLUMN_NOMBRE_EQUIPO = "nombre";
        public static final String COLUMN_CIUDAD = "ciudad";
        public static final String COLUMN_FOTO = "foto";
        public static final String COLUMN_PUNTOS = "puntos";
    }

    public static class Partido implements BaseColumns {
        public static final String TABLE_NAME_PARTIDO = "partido";
        public static final String COLUMN_NOMBRE_PARTIDO = "nombrePartido";
        public static final String COLUMN_FECHA_PARTIDO = "fechaPartido";
        public static final String COLUMN_NOMBRE_EQUIPO_1 = "nombreEquipo1";
        public static final String COLUMN_NOMBRE_EQUIPO_2 = "nombreEquipo2";
        public static final String COLUMN_RESULTADO_1 = "resultadoEquipo1";
        public static final String COLUMN_RESULTADO_2 = "resultadoEquipo2";
    }
}
