package Business.Services.Api;


import Business.Services.Api.entities.ListaJuegos;
import Business.Services.Api.entities.game;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.util.List;


public interface apiService {

    @GET("games")
    Call<List<game>>  juegos(@Query("title") String titulo);


}
