package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private ConnectPolicy connectPolicy = this::randomPolicy;

    private Ladder(List<String> names, int height) {
        for (String name : names) {
            lines.add(Line.of(name, height));
        }

        connectMinimum();
        connectLinesWithPolicy(connectPolicy);
    }

    public static Ladder of(List<String> names, int ladderHeight) {
        if (ObjectUtils.isEmpty(names)) {
            throw new IllegalArgumentException("이름이 없으면 사다리 못 만듦");
        }

        return new Ladder(names, ladderHeight);
    }

    private void connectMinimum() {
        for (int i = 0; i < lines.size()-1; ++i) {
            Line line1 = lines.get(i);

            if (i % 2 == 0) {
                line1.parts.get(0).connect();
                continue;
            }

            line1.parts.get(1).connect();
        }
    }

    public void connectLinesWithPolicy(ConnectPolicy connectPolicy) {
        for (int i = 1; i < lines.size(); ++i) {
            Line line = lines.get(i);

            for (int j = 0; j < line.parts.size(); ++j) {
                LinePart linePart = line.parts.get(j);

                if (!linePart.isConnected()
                    && connectPolicy.check()
                    && !isConnected(i, j))
                {
                    linePart.connect();
                }
            }
        }
    }

    private boolean isConnected(int i, int j) {
        return lines.get(i-1)
            .parts.get(j)
            .isConnected();
    }

    private boolean randomPolicy() {
        return new Random().nextBoolean();
    }

    public int lineHeight() {
        return lines.stream()
            .findAny()
            .orElseThrow(IllegalStateException::new)
            .getHeight();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int lineCount() {
        return lines.size();
    }

    public List<String> getLineNames() {
        return lines.stream()
//            .filter(VerticalLine.class::isInstance)
            .map(Line::getName)
            .filter(name -> !StringUtils.isEmpty(name))
            .collect(Collectors.toUnmodifiableList());
    }

    public List<Line> getConnectedLines() {
        return lines.stream()
            .filter(Line::hasConnected)
            .collect(Collectors.toUnmodifiableList());
    }

    public void setConnectPolicy(ConnectPolicy connectPolicy) {
        this.connectPolicy = connectPolicy;
    }

}

