package com.ulpsoft.tp1loginsharedpreferences.ui.registro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.ulpsoft.tp1loginsharedpreferences.R;
import com.ulpsoft.tp1loginsharedpreferences.databinding.ActivityMainBinding;
import com.ulpsoft.tp1loginsharedpreferences.databinding.ActivityRegistroBinding;
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