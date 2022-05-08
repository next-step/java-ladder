package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

enum PartDirection {
    VERT, HORZ;
}

public class Lines {
    private final List<String> names;
    private final List<Parts> partsPlate = new ArrayList<>();

    public Lines(List<String> names, int height) {
        this.names = names;

        for (int j = 0; j < height; ++j) {
            partsPlate.add(new Parts());
            for (int i = 0; i < names.size() + names.size()-1; ++i) {
                partsPlate.get(j).add(i);
            }
        }
    }

    public void connectMinimum() {
        Parts firstParts = this.partsPlate.get(0);
        Parts secondParts = this.partsPlate.get(1);
        int flag = 0;
        for (int i = 1; i < firstParts.size(); i += 2) {
            if (flag++ % 2 == 0) {
                firstParts.connectPart(i);
                firstParts.connectPart(i-1);
                firstParts.connectPart(i+1);
                continue;
            }

            secondParts.connectPart(i);
            secondParts.connectPart(i-1);
            secondParts.connectPart(i+1);
        }
    }

    public void connectLinesWithPolicy(ConnectPolicy connectPolicy) {
        for (int i = 2; i < partsPlate.size(); ++i) {
            Parts parts = this.partsPlate.get(i);

            for (int j = 1; j < parts.size(); j += 2) {
                if (!parts.isConnected(j)
                    && !parts.isConnected(j-1)
                    && !parts.isConnected(j+1)
                    && connectPolicy.check()) {
                    parts.connectPart(j);
                    parts.connectPart(j-1);
                    parts.connectPart(j+1);
                }
            }
        }
    }

    public int lineHeight() {
        return partsPlate.size();
    }

    public int lineCount() {
        return partsPlate.get(0).size();
    }

    public List<String> getLineNames() {
        return names;
    }

    public boolean isAllLineConnected() {
        boolean lineResult = true;
        for (int i = 1; i < names.size() + names.size()-1; i += 2) {
            final int ii = i;
            lineResult = partsPlate.stream()
                .anyMatch(parts -> parts.isConnected(ii));
        }

        return lineResult;
    }

    public List<Parts> getPartsPlate() {
        return partsPlate;
    }

    @Override
    public String toString() {
        return "{" + partsPlate + "}\n";
    }

    public Stream<Parts> stream() {
        return partsPlate.stream();
    }
}
