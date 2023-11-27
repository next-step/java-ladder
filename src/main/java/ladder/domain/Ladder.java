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
     * 이 정적 팩토리 메서드는 입력으로 사다리 라인 표현식을 받습니다.
     * 각 파라미터는 사다리 한 줄을 정의하며 파라미터 순서가 앞선 사다리 라인이 상층에 쌓이고 파라미터 상 뒤에 오는 사다리 라인이 하층에 쌓입니다.
     *
     * @param lines `-` `|` ` `로 구성된 사다리 라인 표현식
     *
     * @return 생성된 사다리 객체
     */
    public static Ladder of(String... lines) {
        List<LadderLine> ladderLines = Arrays.stream(lines)
                .map(LadderLine::of)
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
     * 이 사다리의 컬럼 수를 반환합니다.
     *
     * @return 사다리 컬럼 수
     */
    public int howManyColumn() {
        return this.lines.get(0).howManyColumns();
    }

    /**
     * 특정 depth의 특정 컬럼이 우측 컬럼과 이어져 있는지를 확인합니다.
     *
     * @param depthIndex 사다리 높이 번호입니다. 0부터 시작하며 숫자가 낮을 수록 상층입니다.
     * @param leftColumnIndex 컬럼 번호입니다. 0부터 시작합니다.
     *
     * @return 주어진 depth의 주어진 컬럼이 우측 컬럼과 연결되어 있다면 true를 반환합니다.
     */
    public ColumnConnection isConnected(int depthIndex, int leftColumnIndex) {
        if (depthIndex < 0 || depthIndex >= this.lines.size()) {
            throw new IllegalArgumentException("주어진 depth 위치 " + depthIndex + "는 존재하지 않습니다.");
        }

        return this.lines.get(depthIndex).isConnected(leftColumnIndex);
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

}