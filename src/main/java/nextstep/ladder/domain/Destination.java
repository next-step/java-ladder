package nextstep.ladder.domain;

import java.util.Objects;

public class Destination {
    private final String destination;

    public Destination(String destination) {
        validateIfEmpty(destination);
        this.destination = destination;
    }

    private void validateIfEmpty(String destination) {
        if(destination == null || destination.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;
        Destination that = (Destination) o;
        return Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return this.destination;
    }
}
