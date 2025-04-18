package ladder.domain;

public class RungFactory {
    private final RungGenerator generator;
    private Rung lastRung;

    public RungFactory(RungGenerator generator) {
        this.lastRung = null;
        this.generator = generator;
    }

    public Rung createNextRung() {
        Rung newRung = Rung.create(generator, lastRung);
        lastRung = newRung;
        return newRung;
    }

}
