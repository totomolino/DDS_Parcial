package Business.Services.Api;
import Business.Services.Api.entities.game;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
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

    //public List<game>




}
