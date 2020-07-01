package ladder.domain.play;

public class Player extends Item {
    private Player(final String input) {
        super(input);
    }

    public static Player of(String input) {
        return new Player(input);
    }
}
