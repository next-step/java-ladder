package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.exception.EmptyNamesException;
import ladder.domain.exception.InvalidHeightException;
import ladder.domain.exception.InvalidLinesException;
import ladder.domain.exception.InvalidNameLengthException;
import ladder.domain.exception.NullNamesException;
import ladder.domain.line.ManualLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리 그리기")
    void add_lines() {
        Ladder ladder = new Ladder(List.of("abc", "adgda", "adg"), 4);

        assertDoesNotThrow(() -> ladder.addLines(
                List.of(
                        new ManualLine(3, List.of(false, false, true)),
                        new ManualLine(3, List.of(false, true, false)),
                        new ManualLine(3, List.of(false, true, false)),
                        new ManualLine(3, List.of(false, false, true))
                )
        ));
    }

    @Test
    @DisplayName("전 칸에 사다리 바가 있는데 이번 칸에도 바가 있다면 예외 발생.")
    void fail_to_add_lines_with_invalid_bar() {
        Ladder ladder = new Ladder(List.of("abc", "adgda", "adg"), 4);

        assertThatExceptionOfType(InvalidLinesException.class)
                .isThrownBy(() ->
                        ladder.addLines(
                                List.of(
                                        new ManualLine(3, List.of(false, true, true)),
                                        new ManualLine(3, List.of(false, false, true)),
                                        new ManualLine(3, List.of(false, true, false)),
                                        new ManualLine(3, List.of(false, false, true))
                                )
                        ));
    }

    @Test
    @DisplayName("사다리 첫 라인은 무조건 false, 아니면 예외 발생.")
    void fail_to_add_lines_with_invalid_first_bar() {
        Ladder ladder = new Ladder(List.of("abc", "adgda", "adg"), 4);

        assertThatExceptionOfType(InvalidLinesException.class)
                .isThrownBy(() ->
                        ladder.addLines(
                                List.of(
                                        new ManualLine(3, List.of(false, false, true)),
                                        new ManualLine(3, List.of(false, true, false)),
                                        new ManualLine(3, List.of(false, true, false)),
                                        new ManualLine(3, List.of(true, false, true))
                                )
                        ));
    }

    @Test
    @DisplayName("사람 수에 맞게 사다리 바가 안그려져 있으면 예외 발생.")
    void fail_to_add_lines_with_invalid_bar_count() {
        Ladder ladder = new Ladder(List.of("abc", "adgda", "adg"), 4);

        assertThatExceptionOfType(InvalidLinesException.class)
                .isThrownBy(() ->
                        ladder.addLines(
                                List.of(
                                        new ManualLine(3, List.of(false, false, true)),
                                        new ManualLine(3, List.of(false, false)),
                                        new ManualLine(3, List.of(false, false, true)),
                                        new ManualLine(3, List.of(false, false, true))
                                )
                        ));
    }

    @Test
    @DisplayName("주어진 사다리 높이를 충족하지 못하면 예외 발생.")
    void fail_to_add_lines_with_not_enough_bars() {
        Ladder ladder = new Ladder(List.of("abc", "adgda", "adg"), 4);

        assertThatExceptionOfType(InvalidLinesException.class)
                .isThrownBy(() ->
                        ladder.addLines(
                                List.of(
                                        new ManualLine(3, List.of(false, false, true)),
                                        new ManualLine(3, List.of(false, false, true)),
                                        new ManualLine(3, List.of(false, false, true))
                                )
                        ));
    }

    @Test
    @DisplayName("사다리 높이가 1 미만이면 예외 발생.")
    void fail_to_init_ladder_by_invalid_height() {
        assertThatExceptionOfType(InvalidHeightException.class)
                .isThrownBy(() -> new Ladder(List.of("abc", "adgda", "adg"), 0));
    }

    @Test
    @DisplayName("이름들이 null 이면 예외 발생.")
    void fail_to_init_ladder_by_null_names() {
        assertThatExceptionOfType(NullNamesException.class)
                .isThrownBy(() -> new Ladder(null, 4));
    }

    @Test
    @DisplayName("이름이 한개도 없으면 예외 발생.")
    void fail_to_init_ladder_by_empty_names() {
        assertThatExceptionOfType(EmptyNamesException.class)
                .isThrownBy(() -> new Ladder(new ArrayList<>(), 4));
    }

    @Test
    @DisplayName("이름길이가 0 초과 5 이하가 아니면 예외 발생.")
    void fail_to_init_ladder_by_invalid_name_length() {
        assertAll(
                () -> assertThatExceptionOfType(InvalidNameLengthException.class)
                        .isThrownBy(() -> new Ladder(List.of("abcvsdgagh", "adgda", "adg"), 4)),
                () -> assertThatExceptionOfType(InvalidNameLengthException.class)
                        .isThrownBy(() -> new Ladder(List.of("", "adgda", "adg"), 4))
        );
    }

    @Test
    @DisplayName("사다리 도착 결과")
    void get_end_point() {
        Ladder ladder = new Ladder(List.of("abc", "def", "ghi"), 5);
        ladder.addLines(
                List.of(
                        new ManualLine(3, List.of(false, false, true)),
                        new ManualLine(3, List.of(false, true, false)),
                        new ManualLine(3, List.of(false, false, true)),
                        new ManualLine(3, List.of(false, true, false)),
                        new ManualLine(3, List.of(false, false, true))
                )
        );

        assertAll(
                () -> assertThat(ladder.getEndPoint("abc")).isEqualTo(1),
                () -> assertThat(ladder.getEndPoint("def")).isEqualTo(0),
                () -> assertThat(ladder.getEndPoint("ghi")).isEqualTo(2)
        );

    }
}
