package nextstep.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 사다리의 각 행을 관리하는 객체
 */
public class Line {
    private final int column;
    private final List<Boolean> rowStatus;
    private final Random random = new Random();

    /* 생성자 */
    private Line(int column) {
        this(column, new ArrayList<>(Collections.nCopies(column - 1, false)));
    }

    // 테스트를 위한 생성자
    public Line(int column, List<Boolean> rowStatus) {
        this.column = column;
        this.rowStatus = rowStatus;
    }

    /* 생성의도 명확하게 하는 팩토리 메서드 */
    public static Line ofColumn(int column) {
        return new Line(column);
    }

    /* 핵심 메서드 : 순회하면서 이전 상태를 참고해서 false면 랜덤, true면 false로 */
    public void generateRandomStatus() {
        IntStream.range(0, column - 1)
            .forEach(this::setRandomStatus);
    }

    private void setRandomStatus(int index) {
        boolean prevStatus = (index > 0 && rowStatus.get(index - 1));
        rowStatus.set(index, !prevStatus && random.nextBoolean());
    }

    /* 단순 정보 확인용 getter */
    public List<Boolean> rowStatus() {
        return Collections.unmodifiableList(rowStatus);
    }

}
