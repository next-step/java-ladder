package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    /**
     * 사다리 모양
     *길동  맹구  짱구  훈이  유리
     * |-----|     |-----|     |
     * |     |-----|     |-----|
     * |     |     |-----|     |
     * |-----|     |-----|     |
     * |-----|     |     |     |
     * 귤   배    감   포도   사탕
     */
    @DisplayName("선물을 잘 반환하는지")
    @ParameterizedTest(name = "[{index}] participant: {0}, expectedGift: {1}")
    @MethodSource("playArguments")
    void play(Participant participant, Gift expectedGift) {
        //given
        Ladder ladder = createLadder();
        List<Participant> participants = createParticipants();
        LadderGame ladderGame = new LadderGame(participants, ladder);

        //when
        GiftBundle giftBundle = createGiftBundle();
        Gift gift = ladderGame.play(participant, giftBundle);

        //then
        assertThat(gift).isEqualTo(expectedGift);
    }

    private static Stream<Arguments> playArguments() {
        return Stream.of(
                Arguments.of(new Participant("길동"), new Gift("감")),
                Arguments.of(new Participant("맹구"), new Gift("귤")),
                Arguments.of(new Participant("짱구"), new Gift("사탕")),
                Arguments.of(new Participant("훈이"), new Gift("배")),
                Arguments.of(new Participant("유리"), new Gift("포도"))
        );
    }

    private Ladder createLadder() {
        Line first = new Line(asList(true, false, true, false));
        Line second = new Line(asList(false, true, false, true));
        Line third = new Line(asList(false, false, true, false));
        Line fourth = new Line(asList(true, false, true, false));
        Line fifth = new Line(asList(true, false, false, false));
        return new Ladder(asList(first, second, third, fourth, fifth));
    }

    private List<Participant> createParticipants() {
        return asList(
                new Participant("길동"),
                new Participant("맹구"),
                new Participant("짱구"),
                new Participant("훈이"),
                new Participant("유리")
        );
    }

    private GiftBundle createGiftBundle() {
        return new GiftBundle(asList(
                new Gift("귤"),
                new Gift("배"),
                new Gift("감"),
                new Gift("포도"),
                new Gift("사탕")
        ));
    }

}
