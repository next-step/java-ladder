package ladder.domain.ladder;

public class Pillar {

    private final Stairs stairs;

    private Pillar(final Stairs stairs) {
        this.stairs = stairs;
    }

    public static Pillar of(final PillarCount pillarCount) {
        return new Pillar(Stairs.of(pillarCount));
    }
}
