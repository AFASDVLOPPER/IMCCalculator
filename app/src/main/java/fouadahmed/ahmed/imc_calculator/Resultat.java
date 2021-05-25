package fouadahmed.ahmed.imc_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.Math.round;

public class Resultat extends AppCompatActivity {

    private TextView txtIMC;
    private TextView txtPoidsmin;
    private TextView txtPoidsmax;
    private TextView txtPoidsideal;
    private TextView txtDiagnostic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        Intent thisIntent = getIntent();

        String nom = thisIntent.getExtras().getString("nom");
        String prenom = thisIntent.getExtras().getString("prenom");
        String sexe = thisIntent.getExtras().getString("spinnerGenre");
        int age = thisIntent.getExtras().getInt("age");
        double poids = thisIntent.getExtras().getDouble("poids");
        double taille = thisIntent.getExtras().getDouble("taille");
        String genre = thisIntent.getExtras().getString("spinnerGenre");

        txtIMC =  findViewById(R.id.IDtxtIMC);
        double imc = (double)round(poids/(0.01*taille*taille*0.01)*100)/100;
        String resultat = String.valueOf(imc);
        txtIMC.setText(resultat);
        //txtIMC.setBackgroundColor(#000000);

        double poidsmin = (double)round((19 * taille*0.01 * taille*0.01)*100)/100;
        String resPmin = String.valueOf(poidsmin);
        txtPoidsmin =  findViewById(R.id.IDtxtpmin);
        txtPoidsmin.setText(resPmin);

        double poidsmax = (double)round((25 * taille*0.01 * taille*0.01)*100)/100;
        String resPmax = String.valueOf(poidsmax);
        txtPoidsmax =  findViewById(R.id.IDtxtpmax);
        txtPoidsmax.setText(resPmax);

        double poidsideal;
        txtPoidsideal =  findViewById(R.id.IDtxtpideal);

        if(sexe.toString().toUpperCase() =="HOMME") {
            poidsideal =  (double)round((taille-100-((taille-150)/4))*100)/100;
            String resPideal = String.valueOf(poidsideal);
            txtPoidsideal.setText(resPideal);
        }
        else
        {
            poidsideal = (double)round((taille-100-((taille-150)/2.5))*100)/100;
            String resPideal = String.valueOf(poidsideal);
            txtPoidsideal.setText(resPideal);
        }

        String diagnostic;
        txtDiagnostic = findViewById(R.id.IDtxtdiag);
        if(imc<17)
        {
            diagnostic="Anorexique";
            txtDiagnostic.setText(diagnostic);
        }
        else if(imc<19)
        {
            diagnostic="Maigre";
            txtDiagnostic.setText(diagnostic);
        }
        else if(imc<25)
        {
            diagnostic="SuperForme";
            txtDiagnostic.setText(diagnostic);

        }
        else if(imc<30)
        {
            diagnostic="Kilos en +";
            txtDiagnostic.setText(diagnostic);

        }
        else if(imc<40)
        {
            diagnostic="Obese leger";
            txtDiagnostic.setText(diagnostic);

        }
        else
        {
            diagnostic="Obese Morbide";
            txtDiagnostic.setText(diagnostic);
        }
    }

    public void retour(View view)
    {
        finish();
    }

    public void conseil(View view)
    {

        Intent intent = new Intent(Resultat.this, Conseils.class);
        
        startActivity(intent);
    }
}