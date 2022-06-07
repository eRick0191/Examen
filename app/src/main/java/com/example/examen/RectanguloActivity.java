package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RectanguloActivity extends AppCompatActivity {
    private TextView textNombre;
    private TextView textAltura;
    private TextView textBase;
    private TextView textResultado;
    private RadioButton area;
    private RadioButton perimetro;
    private Button btnCalcular;
    private Button btnRegresar;
    Rectangulo rectangulo = new Rectangulo();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        Iniciar();
        Intent i = getIntent();
        String txtNombre = i.getStringExtra("Textnombre");
        String txtAltura = i.getStringExtra("Textaltura");
        String txtBase = i.getStringExtra("Textbase");
        textNombre.setText(txtNombre);
        textAltura.setText("Altura: "+txtAltura);
        textBase.setText("Base: "+txtBase);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean estado = perimetro.isChecked();
                boolean estado2 = area.isChecked();
                float altura = Float.parseFloat(txtAltura);
                float base = Float.parseFloat(txtBase);
                rectangulo.setAltura(altura);
                rectangulo.setBase(base);
                if(estado){
                    textResultado.setText("Perimetro: "+String.valueOf(rectangulo.calculoPerimetro()));

                }
                if(estado2){
                    textResultado.setText("Area: " +String.valueOf(rectangulo.calculoArea()));

                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void Iniciar(){
        textNombre = (TextView) findViewById(R.id.textNombre);
        textBase = (TextView) findViewById(R.id.textBase);
        textAltura = (TextView) findViewById(R.id.textAltura);
        textResultado = (TextView) findViewById(R.id.textResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        perimetro = (RadioButton) findViewById(R.id.perimetro);
        area = (RadioButton) findViewById(R.id.area);
    }

}