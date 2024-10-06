package com.ulpsoft.tp1loginsharedpreferences.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.ulpsoft.tp1loginsharedpreferences.model.Usuario;
import com.ulpsoft.tp1loginsharedpreferences.request.ApiClient;
import com.ulpsoft.tp1loginsharedpreferences.ui.registro.RegistroActivity;
import com.ulpsoft.tp1loginsharedpreferences.ui.registro.RegistroActivityViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void verificarLogin(String mail, String password){

        Usuario usuarioEncontrado = ApiClient.login(context, mail, password);

        if(usuarioEncontrado != null){
            Intent intent = new Intent(context, RegistroActivity.class);
            intent.putExtra("esRegistro", false);  // Enviar el mismo boolean para que exista en ambos casos
            intent.putExtra("usuario", usuarioEncontrado);  // Enviar el objeto Usuario
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else{
            Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
