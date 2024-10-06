package com.ulpsoft.tp1loginsharedpreferences.ui.registro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.ulpsoft.tp1loginsharedpreferences.R;
import com.ulpsoft.tp1loginsharedpreferences.databinding.ActivityMainBinding;
import com.ulpsoft.tp1loginsharedpreferences.databinding.ActivityRegistroBinding;
import com.ulpsoft.tp1loginsharedpreferences.model.Usuario;
import com.ulpsoft.tp1loginsharedpreferences.request.ApiClient;
import com.ulpsoft.tp1loginsharedpreferences.ui.login.MainActivityViewModel;

public class RegistroActivity extends AppCompatActivity {

    private ActivityRegistroBinding binding;
    private RegistroActivityViewModel mv;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);
        context = getApplicationContext();

        // Obtenet boolean para saber si es registro o login, false es el valor  por defecto para no tener el dato vacio
        //(de todas formas siempre llega un valor es el unico boolean para ambos casos)
        boolean esRegistro = getIntent().getBooleanExtra("esRegistro", false);

        if(!esRegistro){
            //recuperar usuario para mostrar sus datos
            Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
            binding.etDni.setText(String.valueOf(usuario.getDni()));
            binding.etApellido.setText(usuario.getApellido());
            binding.etNombre.setText(usuario.getNombre());
            binding.etEmail.setText(usuario.getMail());
            binding.etPassword.setText(usuario.getPassword());
            Toast.makeText(context, "¡ Bienvenido !", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Por favor ingrese todos los datos para crear un usuario.", Toast.LENGTH_SHORT).show();
        }

        binding.btCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            mv.crear (binding.etDni.getText().toString(),
                    binding.etApellido.getText().toString(),
                    binding.etNombre.getText().toString(),
                    binding.etEmail.getText().toString(),
                    binding.etPassword.getText().toString());
            }
        });

    }
}


