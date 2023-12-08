package seungjun.ladder;

import ladder.LadderBody;
import ladder.LadderLine;
import seungjun.generator.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SeungjunLadderBody implements LadderBody {
    private final List<SeungjunLadderLine> lines;

    public SeungjunLadderBody(List<SeungjunLadderLine> lines) {
        validateLadderLines(lines);
        this.lines = lines;
    }

    private static void validateLadderLines(List<SeungjunLadderLine> lines) {
        checkAllLinesHasSameColumn(lines);
    }

    /**
     * 각 LadderLine이 모두 같은 수의 컬럼을 가지고 있는지 체크합니다.
     * 다른 개수의 컬럼을 가진 LadderLine이 있다면 예외가 던져집니다.
     * @param lines 검사할 LadderLine의 리스트
     */
    private static void checkAllLinesHasSameColumn(List<SeungjunLadderLine> lines) {
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
     * 이 정적 팩토리 메서드는 입력으로 사다리 라인 생성기를 받습니다.
     * 생성기가 생성하는 사다리 라인에 따라 사다리를 구성합니다.
     *
     * @param generator 사다리 생성기
     * @param depth 라인을 몇 개나 생성할 것인지 설정합니다.
     *
     * @return 생성된 사다리 객체
     */
    public static SeungjunLadderBody of(Generator<SeungjunLadderLine> generator, int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException("사다리 라인을 " + depth + "개 생성하라고 설정되었습니다.");
        }

        List<SeungjunLadderLine> lines = new ArrayList<>(depth);

        for (int i = 0; i < depth; i++) {
            lines.add(generator.make());
        }

        return new SeungjunLadderBody(lines);
    }

    @Override
    public int howLongDepth() {
        return this.lines.size();
    }

    @Override
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
        SeungjunLadderBody ladder = (SeungjunLadderBody) o;
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

    @Override
    public int calculateResultOf(int columnIndex) {
        int currentColumnIndex = columnIndex;
        for (SeungjunLadderLine line : lines) {
            currentColumnIndex = line.connectedColumnOf(currentColumnIndex);
        }
        return currentColumnIndex;
    }
}