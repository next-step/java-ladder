package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Parts {

    private List<Part> parts = new ArrayList<>();


    public void add(int index) {
        parts.add(Part.valueOf(index));
    }

    public int size() {
        return parts.size();
    }

    public void connectPart(int index) {
        parts.get(index).connect();
    }

    public boolean isConnected(int index) {
        return parts.get(index).isConnected();
    }

    public List<Part> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "{" + parts + "}\n";
    }
}
