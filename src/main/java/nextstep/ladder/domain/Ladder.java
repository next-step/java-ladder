package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import nextstep.ladder.utils.ObjectUtils;

public class Ladder {

    private final Names names;
    private final Lines lines;
    private ConnectPolicy connectPolicy = this::randomPolicy;

    private Ladder(List<String> names, int height) {
        this.names = new Names(names);
        lines = new Lines(names.size(), height);

        lines.connectLinesWithPolicy(connectPolicy);
    }

    public static Ladder of(List<String> names, int ladderHeight) {
        if (ObjectUtils.isEmpty(names)) {
            throw new IllegalArgumentException("이름이 없으면 사다리 못 만듦");
        }

        return new Ladder(names, ladderHeight);
    }

    private boolean randomPolicy() {
        return new Random().nextBoolean();
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

