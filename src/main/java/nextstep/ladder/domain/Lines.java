package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lines {
    private final List<String> names;
    private final PartsLines partsLines = new PartsLines();

    public Lines(List<String> names, int height) {
        this.names = names;

        for (int j = 0; j < height; ++j) {
            partsLines.add(new Parts());
            for (int i = 0; i < names.size() + names.size()-1; ++i) {
                partsLines.get(j).add(i);
            }
        }
    }

    public void connectMinimum() {
        partsLines.connectMinimum();
    }

    public void connectLinesWithPolicy(ConnectPolicy connectPolicy) {
        partsLines.connectAdditionalLinesWithPolicy(connectPolicy);
    }

    public int lineHeight() {
        return partsLines.size();
    }

    public int lineCount() {
        return partsLines.get(0).size();
    }

    public List<String> getLineNames() {
        return names;
    }

    public boolean isAllLineConnected() {
        boolean lineResult = true;

        for (int i = 1; i < names.size() + names.size()-1; i += 2) {
            final int ii = i;

            lineResult = partsLines.stream()
                .anyMatch(parts -> parts.isConnected(ii));

            if (!lineResult)
                return false;
        }

        return lineResult;
    }

    public List<Parts> getPartsLine() {
        return partsLines.get();
    }

    @Override
    public String toString() {
        return "{" + partsLines + "}\n";
    }

    public Stream<Parts> stream() {
        return partsLines.stream();
    }
}
