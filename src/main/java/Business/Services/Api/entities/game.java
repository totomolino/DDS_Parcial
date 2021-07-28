package Business.Services.Api.entities;

public class game {

    public String gameID;
    public String steamAppID;
    public String cheapest;
    public String cheapestDealID;
    public String external;
    public String internalName;
    public String thumb;


    public String getInternalName() {
        return internalName;
    }

    public String getExternal() {
        return external;
    }

    public String getPrecio() {
        return cheapest;
    }
}
