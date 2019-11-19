package ladder.domain.result;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Destinations {
    private final List<Destination> destinations;

    public Destinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Destination> getDestinations() {
        return Collections.unmodifiableList(destinations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destinations that = (Destinations) o;
        return Objects.equals(destinations, that.destinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations);
    }
}
