package com.example.simon.ingegneriauniparthenope;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class ProfActivity extends AppCompatActivity {


    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_prof);
        ListaDocenti lidoc=new ListaDocenti();

        final TextView nomeDocente = (TextView) findViewById(R.id.nomeDocente) ;
        final TextView studioDocente = (TextView) findViewById(R.id.studioDocente) ;
        final TextView telefonoDocente = (TextView) findViewById(R.id.telefonoDocente) ;
        final TextView emailDocente = (TextView) findViewById(R.id.emailDocente) ;

        Spinner spinnerDoc = (Spinner)findViewById(R.id.spinnerDocenti);

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ListaDocenti.nome);
        spin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDoc.setAdapter(spin_adapter);

        spinnerDoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                nomeDocente.setText(ListaDocenti.nome.get(position).toString());
                studioDocente.setText(ListaDocenti.studio.get(position).toString());
                telefonoDocente.setText(ListaDocenti.telefono.get(position).toString());
                emailDocente.setText(ListaDocenti.email.get(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {}
        });


        ImageButton bottoneHome = (ImageButton) findViewById(R.id.buttonHome);
        bottoneHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfActivity.this, MainActivity.class));
            }
        });

    }

}




