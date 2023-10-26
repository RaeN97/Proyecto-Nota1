package com.example.proyecto_nota1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*public class Crud extends AppCompatActivity {
    EditText edtNom, edtCor, edtContra;
    ListView List;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        edtNom = (EditText) findViewById(R.id.edtNom);
        edtCor = (EditText) findViewById(R.id.edtCor);
        edtContra = (EditText) findViewById(R.id.edtContra);
        List = (ListView) findViewById(R.id.lstList);
    }

    public void onClickAgregar(View view){
        DataHelper dh = new DataHelper(this, "usuarios.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        String email = edtCor.getText().toString();
        String nombre = edtNom.getText().toString();

        if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            // Verificar si el correo electrónico ya existe
            Cursor cursorEmail = bd.query("usuarios", null, "cor=?", new String[]{email}, null, null, null);
            if(cursorEmail.getCount() > 0){
                Toast.makeText(this,"El correo electrónico ya está registrado. Por favor, usa otro.",Toast.LENGTH_LONG).show();
            } else {
                // Verificar si el nombre de usuario ya existe
                Cursor cursorNombre = bd.query("usuarios", null, "nom=?", new String[]{nombre}, null, null, null);
                if(cursorNombre.getCount() > 0){
                    Toast.makeText(this,"El nombre de usuario ya está registrado. Por favor, elige otro.",Toast.LENGTH_LONG).show();
                } else {
                    reg.put("contra", edtContra.getText().toString());
                    reg.put("nom", nombre);
                    reg.put("cor", email);
                    long resp = bd.insert("usuarios", null, reg);
                    if (resp == -1){
                        Toast.makeText(this,"No se pudo Ingresar",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this,"Dato Ingresado Correctamente",Toast.LENGTH_LONG).show();
                    }
                }
                cursorNombre.close();
            }
            cursorEmail.close();
        } else {
            Toast.makeText(this,"Correo electrónico no válido",Toast.LENGTH_LONG).show();
        }
        CargarLista();
        Limpiar();
    }

    public void onClickModificar(View view){
        DataHelper dh = new DataHelper(this, "usuarios.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        String email = edtCor.getText().toString();
        String nombre = edtNom.getText().toString();

        if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            // Verificar si el correo electrónico ya existe
            Cursor cursorEmail = bd.query("usuarios", null, "cor=? AND cor!=?", new String[]{email, email}, null, null, null);
            if(cursorEmail.getCount() > 0){
                Toast.makeText(this,"El correo electrónico ya está registrado. Por favor, usa otro.",Toast.LENGTH_LONG).show();
            } else {
                // Verificar si el nombre de usuario ya existe
                Cursor cursorNombre = bd.query("usuarios", null, "nom=? AND cor!=?", new String[]{nombre, email}, null, null, null);
                if(cursorNombre.getCount() > 0){
                    Toast.makeText(this,"El nombre de usuario ya está registrado. Por favor, elige otro.",Toast.LENGTH_LONG).show();
                } else {
                    reg.put("nom", nombre);
                    reg.put("cor", email);
                    reg.put("contra", edtContra.getText().toString());
                    long resp  = bd.update("usuarios", reg, "cor=?", new String[]{email});
                    if(resp == -1){
                        Toast.makeText(this, "No se pudo Modificar",
                                Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(this, "Dato Modificado",
                                Toast.LENGTH_LONG).show();
                    }
                }
                cursorNombre.close();
            }
            cursorEmail.close();
        } else {
            Toast.makeText(this,"Correo electrónico no válido",Toast.LENGTH_LONG).show();
        }
        CargarLista();
        Limpiar();
    }



    public void onClickEliminar(View view){
        DataHelper dh = new DataHelper(this, "usuarios.db",  null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        String bNom = edtNom.getText().toString();
        long resp = bd.delete("usuarios", "nom="+ bNom, null);
        bd.close();
        if(resp ==-1){
            Toast.makeText(this, "No se pudo Eliminar",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Dato Eliminado",
                    Toast.LENGTH_LONG).show();
        }
        Limpiar();
        CargarLista();
    }*/

    public class Crud extends AppCompatActivity {
        EditText edtNom, edtCor, edtContra;
        ListView List;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_crud);

            edtNom = (EditText) findViewById(R.id.edtNom);
            edtCor = (EditText) findViewById(R.id.edtCor);
            edtContra = (EditText) findViewById(R.id.edtContra);
            List = (ListView) findViewById(R.id.lstList);
        }

        public void onClickAgregar(View view){
            DataHelper dh = new DataHelper(this, "usuario.db", null, 1);
            SQLiteDatabase bd = dh.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("nom", edtNom.getText().toString());
            reg.put("cor", edtCor.getText().toString());
            reg.put("contra", edtContra.getText().toString());
            long resp = bd.insert("usuarios", null, reg);
            bd.close();
            if (resp == -1){
                Toast.makeText(this,"No se pudo Ingresar",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Dato Ingresado Correctamente",Toast.LENGTH_LONG).show();
            }
            Limpiar();
            CargarLista();
        }

        public void onClickModificar(View view){
            DataHelper dh = new DataHelper(this, "usuario.db", null, 1);
            SQLiteDatabase bd = dh.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("nom", edtNom.getText().toString());
            reg.put("cor", edtCor.getText().toString());
            reg.put("contra", edtContra.getText().toString());
            long resp  = bd.update("usuarios", reg, "nom=?", new String[]
                    {edtNom.getText().toString()});
            bd.close();
            if(resp == -1){
                Toast.makeText(this, "No se pudo Modificar",
                        Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Dato Modificado",
                        Toast.LENGTH_LONG).show();
            }
            Limpiar();
            CargarLista();
        }

        public void onClickEliminar(View view){
            DataHelper dh = new DataHelper(this, "usuario.db",  null, 1);
            SQLiteDatabase bd = dh.getWritableDatabase();
            String bNom = edtNom.getText().toString();
            long resp = bd.delete("usuarios", "nom="+ bNom, null);
            bd.close();
            if(resp ==-1){
                Toast.makeText(this, "No se pudo Eliminar",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Dato Eliminado",
                        Toast.LENGTH_LONG).show();
            }
            Limpiar();
            CargarLista();
        }



        public void Limpiar(){
            edtNom.setText("");
            edtCor.setText("");
            edtContra.setText("");
        }


    public void CargarLista(){
        DataHelper dh = new DataHelper(this, "usuario.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        Cursor c = bd.rawQuery("SELECT id, nom, cor, contra FROM usuarios", null);
        String[] arr = new String[c.getCount()];

        if(c.moveToFirst() == true){
            int i = 0;
            do{
                String linea = "||" + c.getString(0) + "||" + c.getString(1)+
                        "||" + c.getString(2) + "||";
                arr[i] = linea;
                i++;
            }while (c.moveToNext() == true);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_expandable_list_item_1, arr);
            List.setAdapter(adapter);
            bd.close();
        }
    }
}
