package ladder.domain;

import java.util.Objects;

public class Rung {
    private final boolean connected;

    public Rung(boolean connected) {
        this.connected = connected;
    }

    public static Rung create(RungGenerator generator, Rung previous) {
        boolean isConnected = canConnect(previous) && generator.isConnected();
        return new Rung(isConnected);
    }

    private static boolean canConnect(Rung other) {
        return other == null || !other.connected;
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
