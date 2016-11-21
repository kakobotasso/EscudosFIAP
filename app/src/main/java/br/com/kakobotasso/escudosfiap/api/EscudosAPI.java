package br.com.kakobotasso.escudosfiap.api;

import java.util.List;

import br.com.kakobotasso.escudosfiap.model.Escudo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EscudosAPI {

    @GET("/v2/57c49ba10f00007111b50c00")
    Call<List<Escudo>> getAll();
}
