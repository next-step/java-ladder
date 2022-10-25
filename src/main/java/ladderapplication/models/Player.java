package ladderapplication.models;

import ladderapplication.models.requests.PlayerRequest;

public class Player {

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player from(PlayerRequest playerRequest) {
        return new Player(playerRequest.getName());
    }
}
