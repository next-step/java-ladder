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

        if (index < parts.size()-1)
            parts.get(index+1).connect();

        if (index > 0)
            parts.get(index-1).connect();
    }

    public void connectPartWithPolicy(int index, ConnectPolicy connectPolicy) {
        if (this.isConnected(index)
            || !connectPolicy.check()) {
            return;
        }

        connect(index);
    }

    public boolean isConnected(int index) {
        return parts.get(index).isConnected()
            || parts.get(index+1).isConnected()
            || parts.get(index-1).isConnected();
    }

    private void connect(int partIndex) {
        parts.get(partIndex).connect();
        parts.get(partIndex+1).connect();
        parts.get(partIndex-1).connect();
    }

    public List<Part> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "{" + parts + "}\n";
    }

    public void connectEvenPart(int flag, int index) {
        if (flag == 0) {
            this.connectPart(index);
        }
    }

    public void connectOddPart(int flag, int index) {
        if (flag != 0) {
            this.connectPart(index);
        }
    }
}
