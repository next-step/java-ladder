package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int AFTER_DEFAULT_LINE = 2;

    private final List<Parts> partsList = new ArrayList<>();

    public Lines(int participantsCount, int height) {
        final int verticalCount = participantsCount;
        final int horizonCount = participantsCount - 1;

        for (int j = 0; j < height; ++j) {
            partsList.add(new Parts());
        }

        partsList.forEach(parts -> {
                for (int i = 0; i < verticalCount + horizonCount; ++i) {
                    parts.add(i);
                }
            });
    }

    public void connectMinimum() {
        connectFirstLineEvenPart();
        connectSecondLineOddPart();
    }

    private void connectFirstLineEvenPart() {
        Parts parts = this.partsList.get(0);

        int flag = 0;
        for (int i = 1; i < parts.size(); i += 2) {
            parts.connectEvenPart(flag++ % 2, i);
        }
    }

    private void connectSecondLineOddPart() {
        Parts parts = this.partsList.get(1);

        int flag = 0;
        for (int i = 1; i < parts.size(); i += 2) {
            parts.connectOddPart(flag++ % 2, i);
        }
    }

    public void connectLinesWithPolicy(ConnectPolicy connectPolicy) {
        // 이미 기본연결된 부분 이후로 라인들 순회
        for (int i = AFTER_DEFAULT_LINE; i < partsList.size(); ++i) {
            connectParts(partsList.get(i), connectPolicy);
        }
    }

    private void connectParts(Parts parts, ConnectPolicy connectPolicy) {
        // 홀수의 Horz 파트만 확인함
        for (int j = 1; j < parts.size(); j += 2) {
            parts.connectPartWithPolicy(j, connectPolicy);
        }
    }

    public int lineHeight() {
        return partsList.size();
    }

    public int lineCount() {
        return partsList.stream()
            .findAny()
            .orElseThrow(() -> new IllegalStateException("연결을 확인 할 수 없음"))
            .size();
    }

    public boolean isAllLineConnected() {
        int lineCount = lineCount();

        boolean isConnected;
        for (int i = 1; i < lineCount; i += 2) {
            final int ii = i;

            isConnected = partsList.stream()
                .anyMatch(parts -> parts.isConnected(ii));

            if (!isConnected)
                return false;
        }

        return true;
    }

    public List<Parts> getPartsLine() {
        return partsList;
    }

    @Override
    public String toString() {
        return "{" + partsList + "}\n";
    }

}
