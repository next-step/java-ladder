package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Destinations {

    private final List<Destination> destinationList;

    public Destinations(List<Destination> destinationList) {
        this.destinationList = destinationList;
    }

    public List<Destination> destinations(){
        return Collections.unmodifiableList(destinationList);
    }

    public int count(){
        return destinationList.size();
    }
}
