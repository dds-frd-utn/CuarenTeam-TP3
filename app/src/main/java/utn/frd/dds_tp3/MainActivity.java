package utn.frd.dds_tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int nroCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int nroCuenta = intent.getIntExtra(Login.EXTRA_NROCUENTA, 0);

        findViewById(R.id.btnSalir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnMovimientos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Movimientos.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnTransferencia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Transferencia.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnRealizarPago).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pagos.class);
                startActivity(intent);
            }
        });
/*        findViewById(R.id.btnEjecutar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MiAsyncTask().execute();
            }
        });
    }

    private class MiAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            return RESTService.makeGetRequest(
                    "https://jsonplaceholder.typicode.com/posts/1");
        }

        @Override
        protected void onPostExecute(String result) {
            Toast notificacion = Toast.makeText(
                    getApplicationContext(), result, Toast.LENGTH_LONG);
            notificacion.show();
        }*/
    }
}
