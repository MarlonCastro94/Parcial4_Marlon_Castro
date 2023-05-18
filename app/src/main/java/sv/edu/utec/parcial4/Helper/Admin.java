package sv.edu.utec.parcial4.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Admin extends SQLiteOpenHelper {
    final String tblMD_Clientes = "CREATE TABLE MD_Clientes (ID_Cliente INTEGER PRIMARY KEY, sNombreCliente TEXT, sApellidosClientes TEXT, sDireccionClientes TEXT, sCiudadCliente TEXT)";
    final String tblMD_ClienteVehiculo = "CREATE TABLE MD_ClienteVehiculo (ID_Cliente INTEGER, ID_Vehiculo INTEGER, sMatricula TEXT, iKilometros INTEGER, " +
            "PRIMARY KEY (ID_Cliente, ID_Vehiculo), " +
            "FOREIGN KEY (ID_Cliente) REFERENCES MD_Clientes(ID_Cliente), " +
            "FOREIGN KEY (ID_Vehiculo) REFERENCES MD_Vehiculo(ID_Vehiculo))";
    final String tblMD_Vehiculos= "CREATE TABLE MD_Vehiculo (ID_Vehiculo INTEGER PRIMARY KEY, sMarca TEXT, sModelo TEXT)";

    public Admin(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tblMD_Clientes);
        db.execSQL(tblMD_ClienteVehiculo);
        db.execSQL(tblMD_Vehiculos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
// Aquí puedes realizar la migración de datos si es necesario
    }
}
