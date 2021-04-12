package nextstep.refactoring.laddergame.concrete.player;

public class Player {

    private final PlayerName name;

    private Player(PlayerName name) {
        this.name = name;
    }

    public static Player of(String name) {
        return new Player(new PlayerName(name));
    }

}
