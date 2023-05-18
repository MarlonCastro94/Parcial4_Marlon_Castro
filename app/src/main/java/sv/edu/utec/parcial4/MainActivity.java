package sv.edu.utec.parcial4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteOpenHelper admin = new SQLiteOpenHelper(getApplicationContext(),"bd",null,1);
                SQLiteDatabase bd= admin.getWritableDatabase();



                String idCl=edtidcliente.getText().toString();
                String idVe=edtnombrecliente.getText().toString();
                String nom=edtapellidocliente.getText().toString();
                String ape=edtdireccioncliente.getText().toString();
                String dire=edtciudadcliente.getText().toString();
                String ciu=edtidvehiculo.getText().toString();
                String mar=edtmatricula.getText().toString();
                String mod=edtkilometros.getText().toString();
                String mat=edtmarcavehiculos.getText().toString();
                String kil=edtmodelo.getText().toString();

                ContentValues informacion =new ContentValues();

                informacion.put("ID_Cliente",idCl);
                informacion.put("ID_Vehiculos",idVe);
                informacion.put("sNombreCliente",nom);
                informacion.put("sApellidosClientes",ape);
                informacion.put("sDireccionClientes",dire);
                informacion.put("sCiudadCliente",ciu);
                informacion.put("sMarca",mar);
                informacion.put("sModelo",mod);
                informacion.put("sMatricula",mat);
                informacion.put("iKilometros",kil);

                try {
                    bd.insert("MD_Clientes", null, informacion);
                    bd.insert("MD_Vehiculos", null, informacion);
                    bd.insert("MD_ClienteVehiculo", null, informacion);

                    Toast.makeText(getApplicationContext(), "Se inserto ", Toast.LENGTH_LONG).show();
                    bd.close();

                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}