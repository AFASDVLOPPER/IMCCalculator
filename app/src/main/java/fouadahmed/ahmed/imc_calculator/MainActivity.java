package fouadahmed.ahmed.imc_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerGenre = findViewById(R.id.IDspinnergenre);
        String [] itemGenre = {"HOMME","FEMME"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,itemGenre);
        spinnerGenre.setAdapter(adapter);
    }

    public void calculer(View view) {
        Intent intent = new Intent(MainActivity.this,Resultat.class);

        EditText txtnom = findViewById(R.id.IDtxtnom);
        EditText txtprenom = findViewById(R.id.IDtxtprenom);
        EditText txtage = findViewById(R.id.IDtxtage);
        EditText txtpoids = findViewById(R.id.IDtxtpoids);
        EditText txttaille = findViewById(R.id.IDtxttaille);
        Spinner spinnerGenre = findViewById(R.id.IDspinnergenre);

        boolean oknom = true;
        boolean okprenom = true;
        boolean okage = true;
        boolean okpoids = true;
        boolean oktaille = true;

        if ((txtnom.getText() == null) || txtnom.getText().toString().equals(""))
        {
            Toast.makeText(getBaseContext(), R.string.MessErrNom, Toast.LENGTH_LONG).show();
            oknom=false;
        }
        if ((txtprenom.getText() == null) || txtprenom.getText().toString().equals(""))
        {
            Toast.makeText(getBaseContext(), R.string.MessErrPrenom, Toast.LENGTH_LONG).show();
            okprenom=false;
        }
        if (((txtage.getText() == null) || txtage.getText().toString().equals("")))
        {
            Toast.makeText(getBaseContext(), R.string.MessErrAge, Toast.LENGTH_LONG).show();
            okage=false;
        }
        if ((txtpoids.getText() == null) || txtpoids.getText().toString().equals(""))
        {
            Toast.makeText(getBaseContext(), R.string.MessErrPoids, Toast.LENGTH_LONG).show();
            okpoids=false;
        }
        if ((txttaille.getText() == null) || txttaille.getText().toString().equals(""))
        {
            Toast.makeText(getBaseContext(), R.string.MessErrTaille, Toast.LENGTH_LONG).show();
            oktaille=false;
        }

        if (oknom && okprenom && okage && okpoids && oktaille)
        {
            //j'embarque les differents parametres pour les envoyer à l'autre activité

            intent.putExtra("spinnerGenre", spinnerGenre.getSelectedItem().toString());
            intent.putExtra("nom", txtnom.getText().toString());
            intent.putExtra("prenom", txtprenom.getText().toString());
            intent.putExtra("age", Integer.valueOf(txtage.getText().toString()));
            intent.putExtra("poids", Double.parseDouble(txtpoids.getText().toString()));
            intent.putExtra("taille", Double.parseDouble(txttaille.getText().toString()));

        }

        startActivity(intent);
    }
}