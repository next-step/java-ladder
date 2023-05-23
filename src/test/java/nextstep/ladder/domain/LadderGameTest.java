package nextstep.ladder.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.InputValueSwitch;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"2:5", "3:7", "6:2"}, delimiter = ':')
    public void 사다리게임_생성_테스트(int ladderHeight, int countOfPerson) throws Exception {
        LadderGame ladderGame = LadderGame.create(new LadderHeight(ladderHeight), countOfPerson);
        SoftAssertions softAssertions = new SoftAssertions();
        List<Line> lines = ladderGame.toList();
        softAssertions.assertThat(lines.size()).as("사다리 높이 확인").isEqualTo(ladderHeight);

        int ladderWeight = countOfPerson - 1;
        lines.stream()
                .forEach(i -> softAssertions.assertThat(i.size()).as("사다리 너비 확인").isEqualTo(ladderWeight));

        softAssertions.assertAll();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1"}, delimiter = ':')
    public void 사다리게임_생성_엣지_케이스_테스트(int ladderHeight, int countOfPerson) throws Exception {
        LadderGame ladderGame = LadderGame.create(new LadderHeight(ladderHeight), countOfPerson);
        SoftAssertions softAssertions = new SoftAssertions();
        List<Line> lines = ladderGame.toList();
        softAssertions.assertThat(lines.size()).as("사다리 높이 확인").isEqualTo(ladderHeight);

        int ladderWeight = countOfPerson - 1;
        lines.stream()
                .forEach(i -> softAssertions.assertThat(i.size()).as("사다리 너비 확인").isEqualTo(ladderWeight));

        softAssertions.assertAll();
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:0", "0:0", "0:-1", "-8:-9"}, delimiter = ':')
    public void 사다리게임_생성_예외_테스트(int ladderHeight, int countOfPerson) throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.create(new LadderHeight(ladderHeight), countOfPerson));
    }

}
