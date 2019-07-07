package nextstep.step4.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 03:22
 */
public class LadderLineTest {
    private LadderLine line;

    @BeforeEach
    void setUp() {
        line = new LadderLine(
                Arrays.asList(
                        new Link(0, new Point(true, false)),
                        new Link(1, new Point(false, true))));
    }

    @DisplayName("LadderLine 생성 예외상황 - Empty, Null")
    @ParameterizedTest
    @NullAndEmptySource
    void createListEmptyNullException(List<Link> links) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderLine(links);
        }).withMessageContaining("사다리라인이 비어있습니다.");
    }

    @DisplayName("LadderLine 생성 예외상황 - Size")
    @Test
    void createListSizeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderLine(
                    Arrays.asList(
                            new Link(0, new Point(true, false))));
        }).withMessageContaining("사다리라인의 최소 개수는 2개 입니다.");
    }

    @DisplayName("한줄의 움직임을 확인해서 최종 index 위치 전달받기 - 증가 index")
    @Test
    void moveLineFromIndexIncrease() {
        assertThat(line.moveLine(0)).isEqualTo(1);
    }

    @DisplayName("한줄의 움직임을 확인해서 최종 index 위치 전달받기 - 감소 index")
    @Test
    void moveLineFromIndexDecreas() {
        assertThat(line.moveLine(1)).isEqualTo(0);
    }

    @DisplayName("한줄의 움직임을 확인해서 최종 index 위치 전달받기 - 감소 index")
    @Test
    void moveLineMismatchIndex() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            line.moveLine(2);
        }).withMessageContaining("일치하는 Index가 없습니다.");
    }
}