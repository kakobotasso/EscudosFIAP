package br.com.kakobotasso.escudosfiap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import br.com.kakobotasso.escudosfiap.adapter.EscudosListAdapter;
import br.com.kakobotasso.escudosfiap.api.EscudosAPI;
import br.com.kakobotasso.escudosfiap.model.Escudo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<List<Escudo>> {
    private RecyclerView rvEscudos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEscudos = (RecyclerView) findViewById(R.id.rvEscudos);
        rvEscudos.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvEscudos.setLayoutManager(linearLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EscudosAPI api = retrofit.create(EscudosAPI.class);
        Call<List<Escudo>> call = api.getAll();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Escudo>> call, Response<List<Escudo>> response) {
        EscudosListAdapter adapter = new EscudosListAdapter(this, response.body());
        rvEscudos.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<Escudo>> call, Throwable t) {
        Toast.makeText(this, getString(R.string.error_busca_lista), Toast.LENGTH_SHORT).show();
    }
}
