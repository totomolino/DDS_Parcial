package Business.Services.Api;
import Business.Services.Api.entities.ListaJuegos;
import Business.Services.Api.entities.game;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;


public class apiGames {

    private static apiGames instancia = null;
    private static final String urlAPI = "https://www.cheapshark.com/api/1.0/";
    private Retrofit retrofit;

    public apiGames(){

        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static apiGames getInstacia(){
        if(instancia == null){
            instancia = new apiGames();
        }
        return instancia;

    }

    public List<game> dameJuegos(String titulo) throws IOException {
        apiService juegosService = this.retrofit.create(apiService.class);
        Call<ListaJuegos> requestJuegos = juegosService.juegos(titulo);
        Response<ListaJuegos> responseJuegos = requestJuegos.execute();

        return responseJuegos.body().listaDeJuegos;

    }

    public float damePrecio(String titulo) throws IOException {
        //Busco la lista de juegos aproximada
        List<game> juegosAproximados = this.dameJuegos(titulo);
        game juego = (game) juegosAproximados.stream().filter(game -> this.buscarGame(game,titulo));
        return Float.parseFloat(juego.getPrecio());
    }

    private boolean buscarGame(game game, String titulo) {
        return titulo.equals(game.getInternalName()) || titulo.equals(game.getExternal());
    }


}
