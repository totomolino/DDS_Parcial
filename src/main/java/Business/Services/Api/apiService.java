package Business.Services.Api;


import Business.Services.Api.entities.ListaJuegos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;


public interface apiService {

    @GET("games")
    Call<ListaJuegos> juegos(@Query("title") String titulo);


}
