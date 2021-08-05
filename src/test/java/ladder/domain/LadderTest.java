package ladder.domain;

import ladder.dto.request.LadderRandomGenerateRequest;
import ladder.dto.response.LadderResult;
import ladder.exception.InvalidPrizeException;
import ladder.exception.InvalidRopeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LadderTest {
    @DisplayName("사다리 정상 생성")
    @Test
    void ofTest() {
        LadderLine line = LadderLine.of(
                Stream.of(true, false, true)
                        .map(Rope::of)
                        .collect(Collectors.toList())
        );
        Prize prize = new Prize(
                new Name("상품")
        );

        assertThatCode(() ->
                Ladder.of(
                        Arrays.asList(line, line, line, line),
                        Arrays.asList(prize, prize, prize)
                )
        ).doesNotThrowAnyException();
    }

    @DisplayName("사다리의 로프 갯수가 다를 경우 오류")
    @Test
    void ofInvalidRopeExceptionTest() {
        LadderLine threeRopeLine = LadderLine.of(
                Stream.of(true, false, true)
                        .map(Rope::of)
                        .collect(Collectors.toList())
        );
        LadderLine fourRopeLine = LadderLine.of(
                Stream.of(true, false, true, false)
                        .map(Rope::of)
                        .collect(Collectors.toList())
        );
        Prize prize = new Prize(
                new Name("상품")
        );

        assertThatThrownBy(() ->
                Ladder.of(
                        Arrays.asList(threeRopeLine, fourRopeLine, threeRopeLine, fourRopeLine),
                        Arrays.asList(prize, prize, prize)
                )
        ).isInstanceOf(InvalidRopeException.class);
    }

    @DisplayName("사다리의 로프 갯수와 상품 갯수가 다를 경우 오류")
    @Test
    void ofInvalidPrizeExceptionTest() {
        LadderLine line = LadderLine.of(
                Stream.of(true, false, true)
                        .map(Rope::of)
                        .collect(Collectors.toList())
        );
        Prize prize = new Prize(
                new Name("상품")
        );

        assertThatThrownBy(() ->
                Ladder.of(
                        Arrays.asList(line, line, line, line),
                        Arrays.asList(prize, prize)
                )
        ).isInstanceOf(InvalidPrizeException.class);
    }

    @DisplayName("사다리 자동 생성 테스트")
    @CsvSource({
            "10,100",
            "20,200"
    })
    @ParameterizedTest
    void generate(int ropeSize, int lineHeight) {
        List<Prize> prizes = IntStream.range(0, ropeSize)
                .mapToObj(i -> new Name("상품"))
                .map(Prize::new)
                .collect(Collectors.toList());

        assertThatCode(() -> Ladder.randomGenerate(
                new LadderRandomGenerateRequest(prizes, ropeSize, lineHeight)
        )).doesNotThrowAnyException();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @DisplayName("result Test")
    @Test
    void resultTest() {
        LadderLine ladderLine = LadderLine.of(
                Stream.of(false, true, false)
                        .map(Rope::of)
                        .collect(Collectors.toList())
        );

        List<LadderLine> ladderLines =
                Stream.of(ladderLine, ladderLine, ladderLine)
                        .collect(Collectors.toList());
        List<Prize> prizes =
                Stream.of("1", "2", "3")
                        .map(Name::new)
                        .map(Prize::new)
                        .collect(Collectors.toList());
        Ladder ladder = Ladder.of(ladderLines, prizes);

        Players players =
                Stream.of("p1", "p2", "p3")
                        .map(Name::new)
                        .map(Player::new)
                        .collect(Collectors.collectingAndThen(
                                Collectors.toList(), Players::new
                        ));

        LadderResult ladderResult = ladder.result(players);

        assertThat(
                ladderResult.prize(
                        players.findByName(
                                new Name("p1")
                        ).get()
                ).toString() // p1
        ).isEqualTo("2");
        assertThat(
                ladderResult.prize(
                        players.findByName(
                                new Name("p2")
                        ).get()
                ).toString() // p2
        ).isEqualTo("1");
        assertThat(
                ladderResult.prize(
                        players.findByName(
                                new Name("p3")
                        ).get()
                ).toString() // p3
        ).isEqualTo("3");
    }
}