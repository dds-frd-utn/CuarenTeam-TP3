package utn.frd.dds_tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static java.lang.Integer.*;

public class Login extends AppCompatActivity {

    int nroCuenta;
    EditText inputNroCuenta;
    public static final String EXTRA_NROCUENTA = "utn.frd.dds_tp3.EXTRA_NROCUENTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputNroCuenta = (EditText) findViewById(R.id.inputNroCuenta);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nroCuenta = parseInt(inputNroCuenta.getText().toString());
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.putExtra(EXTRA_NROCUENTA, nroCuenta);
                startActivity(intent);
            }
        });
    }
}