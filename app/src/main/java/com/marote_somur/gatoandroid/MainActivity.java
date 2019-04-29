package com.marote_somur.gatoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton rb_comienza1;
    private RadioButton rb_comienza2;
    private RadioButton rb_solo;
    private RadioButton rb_multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.rb_multi = (RadioButton) findViewById(R.id.rb_multiplayer);
        this.rb_solo = (RadioButton) findViewById(R.id.rb_solo);
        this.rb_comienza1 = (RadioButton) findViewById(R.id.rb_comienza1);
        this.rb_comienza2 = (RadioButton) findViewById(R.id.rb_comienza2);
    }

    public void jugar(View v) {
        Intent i = new Intent(this, JugarActivity.class);
        String tipoJuego;
        boolean comienzaJ1;
        if (this.rb_solo.isChecked()) {
            tipoJuego = "Solo";
        } else if (rb_multi.isChecked()) {
            tipoJuego = "Multijugador";
        } else {
            Toast.makeText(this,
                    "Porfavor seleccione el modo de juego",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(this.rb_comienza1.isChecked()){
            comienzaJ1 = true;
        }else if (this.rb_comienza2.isChecked()){
            comienzaJ1 = false;
        }else{
            Toast.makeText(this,
                    "Porfavor seleccione su tipo de marca",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        i.putExtra("tipoJuego",tipoJuego);
        i.putExtra("comienzaJ1",comienzaJ1);
        startActivity(i);
    }

    public void cargarEstadisticas(View v) {
        Intent intent = new Intent(this, EstadisticasActivity.class);
        startActivity(intent);
    }

}
