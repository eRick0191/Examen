package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtBase;
    private EditText txtAltura;
    private Button btnLimpiar;
    private Button btnSiguiente;
    private Button btnSalir;
    private void salir(){
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("¿Desea cerrar la aplicacion?");
        confirmar.setMessage("Esta accion eliminara toda la informacion");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                aceptar();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        confirmar.show();
    }
    private void aceptar(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Iniciar();

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAltura.setText("");
                txtBase.setText("");
                txtNombre.setText("");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().matches("")||txtAltura.getText().toString().matches("")||
                    txtBase.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,
                            "Falta Capturar Informacion",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,RectanguloActivity.class);
                    intent.putExtra ( "Textbase", txtBase.getText().toString() );
                    intent.putExtra ( "Textnombre", txtNombre.getText().toString() );
                    intent.putExtra ( "Textaltura", txtAltura.getText().toString() );
                    startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });
    }



    public void Iniciar(){
         txtNombre = (EditText) findViewById(R.id.txtNombre);
         txtBase = (EditText) findViewById(R.id.txtBase);
         txtAltura = (EditText) findViewById(R.id.txtAltura);
         btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
         btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
         btnSalir = (Button) findViewById(R.id.btnSalir);
    }
}