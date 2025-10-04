package br.ulbra.app3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtPeso, txtIdade, txtAgua;
    Button btnCalcular;
    TextView txtResp, txtResp2;
    RadioGroup radioGroup;
    RadioButton radioIntenso, radioModerado, radioSedentario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtPeso = findViewById((R.id.txtPeso));
        txtIdade = findViewById((R.id.txtIdade));
        txtAgua = findViewById((R.id.txtAgua));
        btnCalcular = findViewById((R.id.btnCalcular));
        txtResp = findViewById((R.id.txtResp));
        txtResp2 = findViewById((R.id.txtResp2));
        radioGroup = findViewById((R.id.radioGroup));
        radioSedentario = findViewById((R.id.radioSedentario));
        radioModerado = findViewById((R.id.radioModerado));
        radioIntenso = findViewById((R.id.radioIntenso));




        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double consumoBase, consumoTotal, peso, idade, agua, restante, extra = 0;

                peso = Double.parseDouble(txtPeso.getText().toString());
                idade = Double.parseDouble(txtIdade.getText().toString());
                agua = Double.parseDouble(txtAgua.getText().toString());


                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == R.id.radioSedentario) {
                    extra = 0;
                } else if (selectedId == R.id.radioModerado) {
                    extra = 300;
                } else if (selectedId == R.id.radioIntenso) {
                    extra = 600;
                }


                consumoBase = peso * 35;

                consumoTotal = consumoBase + extra;

                restante = consumoTotal - agua;


                txtResp.setText("O consumo total são de: " + consumoTotal + "ml");
                txtResp2.setText("O restante será de: " + restante + "ml");


            }
        });
    }
}