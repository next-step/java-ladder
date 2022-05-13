package nextstep.ladder.domain;

import static nextstep.ladder.utils.LadderPartIndexUtils.isHorizon;
import static nextstep.ladder.utils.LadderPartIndexUtils.isVertical;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int AFTER_DEFAULT_LINE = 0;

    private final List<Parts> lines = new ArrayList<>();

    public Lines(int participantsCount, int height) {
        final int verticalCount = participantsCount;
        final int horizonCount = participantsCount - 1;

        for (int j = 0; j < height; ++j) {
            lines.add(new Parts(verticalCount + horizonCount));
        }
    }



    public int resultIndexOf(int startIndex) {
        validate(startIndex);

        PartIndex partIndex = new PartIndex(0, startIndex);

        int height = lines.size();

        while (partIndex.rowIsSmallerThan(height)) {
            partIndex.modifyIfConnectedPartOf(lines);
        }

        return partIndex.getCol();
    }

    private void validate(int startIndex) {
        if (!isVertical(startIndex)) {
            throw new IllegalArgumentException("결과 확인은 세로줄에서 시작해야함.");
        }

        if (startIndex < 0 || startIndex >= lines.get(0).size()) {
            throw new IllegalArgumentException("유효하지 않은 결과 확인 인덱스.");
        }
    }

    public void connectLinesWithPolicy(ConnectPolicy connectPolicy) {
        // 이미 기본연결된 부분 이후로 라인들 순회
        for (int i = AFTER_DEFAULT_LINE; i < lines.size(); ++i) {
            connectParts(lines.get(i), connectPolicy);
        }
    }

    private void connectParts(Parts parts, ConnectPolicy connectPolicy) {
        // 홀수의 Horz 파트만 확인함
        for (int j = 1; j < parts.size(); j += 2) {
            parts.connectPartWithPolicy(j, connectPolicy);
        }
    }

    public int lineHeight() {
        return lines.size();
    }

    public int lineCount() {
        return lines.stream()
            .findAny()
            .orElseThrow(() -> new IllegalStateException("연결을 확인 할 수 없음"))
            .size();
    }

    public List<Parts> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "{" + lines + "}\n";
    }

    protected void connectLineManually(int lineIndex, int partIndex) {
        if (!isHorizon(partIndex)) {
            throw new IllegalArgumentException("연결 시에는 세로줄 part 가 아니라 가로줄 part 인덱스를 넣어야함.");
        }

        lines.get(lineIndex).connectPart(partIndex);
    }
}
