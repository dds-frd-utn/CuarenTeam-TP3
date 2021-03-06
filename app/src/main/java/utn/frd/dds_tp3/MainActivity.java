package utn.frd.dds_tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    int nroCuenta;
    TextView balanceNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        new MiAsyncTask().execute();
        int nroCuenta = intent.getIntExtra(Login.EXTRA_NROCUENTA, 0);
        balanceNumero = (TextView) findViewById(R.id.balanceNumero);

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
        });*/
    }

    class MiAsyncTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... strings) {
        return RESTService.makeGetRequest(
                "https://jsonplaceholder.typicode.com/posts/1");
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String i = jsonObject.getString("id");
            ((TextView) findViewById(R.id.balanceNumero)).setText(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*Toast notificacion = Toast.makeText(
                getApplicationContext(), result, Toast.LENGTH_LONG);
        notificacion.show();*/
    }
    }
}
