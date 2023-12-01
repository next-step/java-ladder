package ladder.domain;

import ladder.domain.generator.Generator;
import ladder.domain.type.ColumnConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 사다리를 정의합니다.
 * 사다리는 사다리 라인의 묶음입니다.
 * 불변 객체입니다.
 */
public class Ladder {
    private final List<LadderLine> lines;

    private Ladder(List<LadderLine> lines) {
        validateLadderLines(lines);
        this.lines = lines;
    }

    private static void validateLadderLines(List<LadderLine> lines) {
        checkAllLinesHasSameColumn(lines);
    }

    /**
     * 각 LadderLine이 모두 같은 수의 컬럼을 가지고 있는지 체크합니다.
     * 다른 개수의 컬럼을 가진 LadderLine이 있다면 예외가 던져집니다.
     * @param lines 검사할 LadderLine의 리스트
     */
    private static void checkAllLinesHasSameColumn(List<LadderLine> lines) {
        int theNumberOfColumn = lines.get(0).howManyColumns();

        lines.stream()
                .filter(line -> !line.hasTheSameNumberOfColumn(theNumberOfColumn))
                .findFirst()
                .ifPresent(line -> {
                    throw new IllegalArgumentException("Ladder를 구성하는 모든 LadderLine은 같은 수의 컬럼을 가지고 있어야 하나 다른 수의 컬럼을 가진 LadderLine이 발견되었습니다.");
                });
    }

    /**
     * 사다리를 하나 정의합니다.
     * 이 정적 팩토리 메서드는 입력으로 사다리 라인 표현식의 목록을 받습니다.
     * 각 파라미터는 사다리 한 줄을 정의하며 파라미터 순서가 앞선 사다리 라인이 상층에 쌓이고 파라미터 상 뒤에 오는 사다리 라인이 하층에 쌓입니다.
     *
     * @param connectionInfos 사다리 라인 표현식. 한 엘리먼트가 한 라인을 정의합니다.
     * @param columnSymbol 사다리 라인 표현식에서 사용하는 컬럼 기호
     * @param connectionSymbol 사다리 라인 표현식에서 사용하는 연결 기호
     *
     *
     * @return 생성된 사다리 객체
     */
    public static Ladder of(List<String> connectionInfos, char columnSymbol, char connectionSymbol) {
        List<LadderLine> ladderLines = connectionInfos.stream()
                .map(connectionInfo -> LadderLine.of(connectionInfo, columnSymbol, connectionSymbol))
                .collect(Collectors.toList());

        return new Ladder(ladderLines);
    }

    /**
     * 사다리를 하나 정의합니다.
     * 이 정적 팩토리 메서드는 입력으로 사다리 라인 객체의 목록을 받습니다.
     * 파라미터 상 순서가 앞선 사다리 라인이 상층에 쌓이고 파라미터 상 뒤에 오는 사다리 라인이 하층에 쌓입니다.
     *
     * @param lines 사다리 라인들
     *
     * @return 생성된 사다리 객체
     */
    public static Ladder of(LadderLine... lines) {
        return new Ladder(List.of(lines));
    }

    /**
     * 사다리를 하나 정의합니다.
     * 이 정적 팩토리 메서드는 입력으로 사다리 라인 객체의 리스트를 받습니다.
     * 파라미터 상 순서가 앞선 사다리 라인이 상층에 쌓이고 파라미터 상 뒤에 오는 사다리 라인이 하층에 쌓입니다.
     *
     * @param lines 사다리 라인들
     *
     * @return 생성된 사다리 객체
     */
    public static Ladder of(List<LadderLine> lines) {
        return new Ladder(List.copyOf(lines));
    }

    /**
     * 사다리를 하나 정의합니다.
     * 이 정적 팩토리 메서드는 입력으로 사다리 라인 생성기를 받습니다.
     * 생성기가 생성하는 사다리 라인에 따라 사다리를 구성합니다.
     *
     * @param generator 사다리 생성기
     * @param depth 라인을 몇 개나 생성할 것인지 설정합니다.
     *
     * @return 생성된 사다리 객체
     */
    public static Ladder of(Generator<LadderLine> generator, int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException("사다리 라인을 " + depth + "개 생성하라고 설정되었습니다.");
        }

        List<LadderLine> lines = new ArrayList<>(depth);

        for (int i = 0; i < depth; i++) {
            lines.add(generator.make());
        }

        return Ladder.of(lines);
    }

    /**
     * 이 사다리의 깊이를 반환합니다.
     *
     * @return 사다리 깊이
     */
    public int howLongDepth() {
        return this.lines.size();
    }

    /**
     * 이 타입과 호환되 않는 곳에서 Ladder를 사용하기 위해 List로 변환합니다.
     *
     * @return 사다리 연결 정보
     */
    public List<LadderLine> toList() {
        return List.copyOf(this.lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }

    public int calculateResultOf(int columnIndex) {
        int currentColumnIndex = columnIndex;
        for (LadderLine line : lines) {
            currentColumnIndex = line.connectedColumnOf(currentColumnIndex);
        }
        return currentColumnIndex;
    }
}