package ladder.domain;

import java.util.Objects;

public class Rung {
    private final boolean connected;

    protected Rung(boolean connected) {
        this.connected = connected;
    }

    public static Rung create(RungGenerator generator) {
        return new Rung(generator.isConnected());
    }

    public Rung createNext(RungGenerator generator) {
        boolean isConnected = !this.connected && generator.isConnected();
        return new Rung(isConnected);
    }

    public boolean isConnected() {
        return connected;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rung rung = (Rung) o;
        return connected == rung.connected;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(connected);
    }

}
