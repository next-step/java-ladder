package nextstep.laddergame.domain.participant;

public record Position(int value) {

    public Position {
        validate(value);
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수없다");
        }
    }
}
