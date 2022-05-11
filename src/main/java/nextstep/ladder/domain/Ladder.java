package nextstep.ladder.domain;

import java.util.List;
import nextstep.ladder.utils.ObjectUtils;

public class Ladder {

    private final Names names;
    private final Lines lines;

    private Ladder(List<String> names, int height, ConnectPolicy connectPolicy) {
        validate(names);

        this.names = new Names(names);
        lines = new Lines(names.size(), height);

        lines.connectLinesWithPolicy(connectPolicy);
    }

    public static Ladder of(List<String> names, int ladderHeight, ConnectPolicy connectPolicy) {
        return new Ladder(names, ladderHeight, connectPolicy);
    }

    private void validate(List<String> names) {
        if (ObjectUtils.isEmpty(names)) {
            throw new IllegalArgumentException("이름이 없으면 사다리 못 만듦");
        }
    }

    public int lineHeight() {
        return lines.lineHeight();
    }

    public int lineCount() {
        return lines.lineCount();
    }

    public List<String> getLineNames() {
        return names.get();
    }

    public boolean isAllLineConnected() {
        return lines.isAllLineConnected();
    }

    @Override
    public String toString() {
        return "{" + lines + '}';
    }

    public Lines getLines() {
        return lines;
    }

}

