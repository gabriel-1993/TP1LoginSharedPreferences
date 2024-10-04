package com.ulpsoft.tp1loginsharedpreferences.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ulpsoft.tp1loginsharedpreferences.model.Usuario;
import com.ulpsoft.tp1loginsharedpreferences.request.ApiClient;
import com.ulpsoft.tp1loginsharedpreferences.ui.login.MainActivity;

import java.io.*;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class RegistroActivityViewModel extends AndroidViewModel {

    private Context context;

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public void crear(String dni, String apellido, String nombre, String email, String password){
        long dniLong = Long.parseLong(dni);
        Usuario usuario = new Usuario(dniLong, apellido, nombre, email, password);

        ApiClient.guardar(context, usuario);

            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

           // Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show();

    }

}

