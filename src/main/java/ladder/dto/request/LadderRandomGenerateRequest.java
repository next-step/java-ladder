package ladder.dto.request;

import ladder.domain.Prize;

import java.util.List;

public class LadderRandomGenerateRequest {
    private final List<Prize> prizes;
    private final int ropeSize;
    private final int lineHeight;

    public LadderRandomGenerateRequest(List<Prize> prizes, int ropeSize, int lineHeight) {
        this.prizes = prizes;
        this.ropeSize = ropeSize;
        this.lineHeight = lineHeight;
    }

    public List<Prize> prizes() {
        return prizes;
    }

    public int ropeSize() {
        return ropeSize;
    }

    public int lineHeight() {
        return lineHeight;
    }
}
