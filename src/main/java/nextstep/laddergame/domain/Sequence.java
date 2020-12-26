package nextstep.laddergame.domain;

public class Sequence {

    private final int sequence;

    private Sequence(int sequence) {
        this.sequence = sequence;
    }

    public static Sequence create(int sequence) {
        return new Sequence(sequence);
    }

    public int getSequence() {
        return sequence;
    }
}
