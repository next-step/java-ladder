package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PartsLines {

    private static final int AFTER_DEFAULT_LINE = 2;

    List<Parts> partsLines = new ArrayList<>();

    public void connectMinimum() {
        connectFirstLineEvenPart();
        connectSecondLineOddPart();
    }

    private void connectFirstLineEvenPart() {
        Parts parts = this.partsLines.get(0);

        int flag = 0;
        for (int i = 1; i < parts.size(); i += 2) {
            parts.connectEvenPart(flag++ % 2, i);
        }
    }

    private void connectSecondLineOddPart() {
        Parts parts = this.partsLines.get(1);

        int flag = 0;
        for (int i = 1; i < parts.size(); i += 2) {
            parts.connectOddPart(flag++ % 2, i);
        }
    }

    public void connectAdditionalLinesWithPolicy(ConnectPolicy connectPolicy) {
        // 이미 기본연결된 부분 이후로 라인들 순회
        for (int i = AFTER_DEFAULT_LINE; i < partsLines.size(); ++i) {
            connectParts(partsLines.get(i), connectPolicy);
        }
    }

    private void connectParts(Parts parts, ConnectPolicy connectPolicy) {
        // 홀수의 Horz 파트만 확인함
        for (int j = 1; j < parts.size(); j += 2) {
            parts.connectPartWithPolicy(j, connectPolicy);
        }
    }

    public void add(Parts parts) {
        partsLines.add(parts);
    }

    public Parts get(int index) {
        return partsLines.get(index);
    }

    public int size() {
        return partsLines.size();
    }

    public Stream<Parts> stream() {
        return partsLines.stream();
    }

    public List<Parts> get() {
        return partsLines;
    }

    @Override
    public String toString() {
        return "{" + partsLines + '}';
    }

}
