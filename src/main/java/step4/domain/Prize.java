package step4.domain;

public class Prize {
    private final Position position;
    private final String prize;

    public Prize(int position, String prize) {
        this.position = Position.valueOf(position);
        this.prize = prize;
    }
}
