package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("성공 - Ladder를 생성했을 떄 주어진 넓이와 높이만큼의 map이 생성된다.")
    void initTest() {
        Ladder ladder = new Ladder(new PositiveNumber(3), new PositiveNumber(5));
        List<LadderRow> ladderLadderRows = ladder.getLadderRows();
        assertThat(ladderLadderRows).hasSize(5);
        ladderLadderRows.forEach(row ->
                assertThat(row.getRow()).hasSize(3)
        );
    }

    @Test
    @DisplayName("getLadderAsString 메서드가 width 만큼의 가로 폭과 지정된 height 만큼의 세로 길이를 가진 사다리 문자열을 반환한다.")
    void getLadderAsStringTest() {
        PositiveNumber width = new PositiveNumber(3);
        PositiveNumber height = new PositiveNumber(3);
        Ladder ladder = new Ladder(width, height);

        List<String> ladderAsString = Arrays.stream(ladder.getLadderAsString().split("\n"))
                .collect(Collectors.toList());

        for (String row : ladderAsString) {
            long pipeCount = row.chars().filter(it -> it == '|').count();
            assertThat(pipeCount).isEqualTo(width.getValue());
        }
        assertThat(ladderAsString)
                .hasSize(height.getValue());
    }

    /**
     * [ 테스트 사다리 모양 ]
     * |     |     |
     * |-----|     |
     * |     |     |
     */
    @Test
    @DisplayName("getLadderResultIndex 메서드가 사다리 게임 후 마지막 인덱스를 반환한다.")
    void name() {
        PositiveNumber width = new PositiveNumber(3);
        List<LadderRow> map = List.of(
                new LadderRow(new PositiveNumber(3), () -> false),
                new LadderRow(new PositiveNumber(3), () -> true),
                new LadderRow(new PositiveNumber(3), () -> false)
        );
        Ladder ladder = new Ladder(width, map);
        System.out.println(ladder.getLadderAsString());
        assertThat(ladder.getLadderResultIndex(new Point(0))).isEqualTo(new Point(1));
        assertThat(ladder.getLadderResultIndex(new Point(1))).isEqualTo(new Point(0));
        assertThat(ladder.getLadderResultIndex(new Point(2))).isEqualTo(new Point(2));
    }
}