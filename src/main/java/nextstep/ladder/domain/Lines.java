package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int AFTER_DEFAULT_LINE = 2;

    private final List<Parts> lines = new ArrayList<>();

    public Lines(int participantsCount, int height) {
        final int verticalCount = participantsCount;
        final int horizonCount = participantsCount - 1;

        for (int j = 0; j < height; ++j) {
            lines.add(new Parts(verticalCount + horizonCount));
        }
    }

    public void connectMinimum() {
        connectFirstLineEvenPart();
        connectSecondLineOddPart();
    }

    private void connectFirstLineEvenPart() {
        Parts parts = this.lines.get(0);

        int flag = 0;
        for (int i = 1; i < parts.size(); i += 2) {
            parts.connectEvenPart(flag++ % 2, i);
        }
    }

    private void connectSecondLineOddPart() {
        Parts parts = this.lines.get(1);

        int flag = 0;
        for (int i = 1; i < parts.size(); i += 2) {
            parts.connectOddPart(flag++ % 2, i);
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

    public boolean isAllLineConnected() {
        int lineCount = lineCount();

        boolean isConnected;
        for (int i = 1; i < lineCount; i += 2) {
            final int ii = i;

            isConnected = lines.stream()
                .anyMatch(parts -> parts.isConnected(ii));

            if (!isConnected)
                return false;
        }

        return true;
    }

    public List<Parts> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "{" + lines + "}\n";
    }

}
