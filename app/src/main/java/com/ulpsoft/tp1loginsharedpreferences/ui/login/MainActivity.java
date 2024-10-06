package com.ulpsoft.tp1loginsharedpreferences.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ulpsoft.tp1loginsharedpreferences.R;
import com.ulpsoft.tp1loginsharedpreferences.databinding.ActivityMainBinding;
import com.ulpsoft.tp1loginsharedpreferences.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel mv;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Verificar si el usuario existe y coincide el password
                mv.verificarLogin(binding.etEmailIniciar.getText().toString(), binding.etPassIniciar.getText().toString());
            }
        });

        binding.btRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, RegistroActivity.class);
                intent.putExtra("esRegistro", true);  // Enviar un boolean para indicar registro
                startActivity(intent);
            }
        });



    }




}