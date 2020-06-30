package ladder.domain.play;

public class Prize extends Item {
    private Prize(String input) {
        super(input);
    }

    public static Prize of(String input) {
        return new Prize(input);
    }
}
