package nextstep.ladder.domain;

import static nextstep.ladder.utils.LadderPartIndexUtils.isVertical;

import java.util.ArrayList;
import java.util.List;

public class Parts {

    private List<Part> parts = new ArrayList<>();

    public Parts(int length) {
        for (int i = 0; i < length; ++i) {
            this.add(i);
        }
    }

    public void add(int index) {
        parts.add(Part.valueOf(index));
    }

    public int size() {
        return parts.size();
    }

    protected void connectPart(int index) {
        if (isVertical(index) || index >= parts.size() || index < 0) {
            throw new IllegalArgumentException("연결 할 수 없는 파트.");
        }

        parts.get(index+1).connect();
        parts.get(index).connect();
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

    public Part part(int colIndex) {
        return parts.get(colIndex);
    }

}
