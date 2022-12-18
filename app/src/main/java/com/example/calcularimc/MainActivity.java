package com.example.calcularimc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ocultando a barra de ação
        getSupportActionBar().hide();

        // Colocando o aplicativo atrás das barras do sistema
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        // Recuperando os ids
        textResultado = findViewById(R.id.textResultado);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
    }
    public void calcularImc(View view) {

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = peso / (altura * altura);
        /*
        * Para mudar a cor da barra de navegação
        * getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.sua_cor));
        * */
        if (resultado < 19) {
            textResultado.setText("Abaixo do peso");
            textResultado.setTextColor(getResources().getColor(R.color.red));
        } else if (resultado <= 19 || resultado < 25) {
            textResultado.setText("Peso normal");
            textResultado.setTextColor(getResources().getColor(R.color.verde));
        } else if (resultado <= 25 || resultado < 30) {
            textResultado.setText("Sobrepeso");
            textResultado.setTextColor(getResources().getColor(R.color.yellow));
        } else if (resultado <= 30 || resultado < 40) {
            textResultado.setText("Obsidade tipo I");
            textResultado.setTextColor(getResources().getColor(R.color.orange));
        } else if (resultado >= 40) {
            textResultado.setText("Obsidade tipo II");
            textResultado.setTextColor(getResources().getColor(R.color.red));
        }
    }
}