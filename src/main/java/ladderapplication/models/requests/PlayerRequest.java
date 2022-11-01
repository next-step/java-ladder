package ladderapplication.models.requests;

public class PlayerRequest {

    private final String name;

    private PlayerRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PlayerRequest of(String name) {
        return new PlayerRequest(name);
    }
}
