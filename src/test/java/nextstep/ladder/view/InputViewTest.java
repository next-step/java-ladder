package nextstep.ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력 뷰 테스트")
public class InputViewTest {
    @DisplayName("참여할 사람 입력")
    @ParameterizedTest
    @MethodSource("getMemberNames")
    public void enterMembers(String input, String[] output) {
        InputView inputView = new InputView(new Scanner(input), new PrintWriter(System.out));

        List<String> memberNames = inputView.getMemberNames();

        assertThat(memberNames).containsOnly(output);
    }

    static Stream<Arguments> getMemberNames() {
        return Stream.of(
                Arguments.arguments("pobi,honux,crong,jk", new String[]{"pobi", "honux", "crong", "jk"}),
                Arguments.arguments("honux,crong,jk", new String[]{"honux", "crong", "jk"})
        );
    }

    @DisplayName("참여할 사람 입력시 문구")
    @Test
    public void phraseForEnteringMemberNames() {
        StringWriter output = new StringWriter();
        InputView inputView = new InputView(new Scanner("name"), new PrintWriter(output));

        inputView.getMemberNames();

        assertThat(output.toString()).isEqualTo("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n");
    }

    @DisplayName("최대 사다리 높이 입력")
    @ParameterizedTest
    @CsvSource(value = {"5:5", "3:3"}, delimiter = ':')
    public void enterLadderHeight(String input, int output) {
        InputView inputView = new InputView(new Scanner(input), new PrintWriter(System.out));

        int ladderHeight = inputView.getLadderHeight();

        assertThat(ladderHeight).isEqualTo(output);
    }

    @DisplayName("최대 사다리 높이 입력시 문구")
    @Test
    public void phraseForEnteringLadderHeight() {
        StringWriter output = new StringWriter();
        InputView inputView = new InputView(new Scanner("3"), new PrintWriter(output));

        inputView.getLadderHeight();

        assertThat(output.toString()).isEqualTo("최대 사다리 높이는 몇 개인가요?\n");
    }
}