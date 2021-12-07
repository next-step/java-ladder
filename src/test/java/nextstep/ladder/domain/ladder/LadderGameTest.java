package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.factory.FixedWayRule;
import nextstep.ladder.domain.gift.Gift;
import nextstep.ladder.domain.gift.GiftBundle;
import nextstep.ladder.domain.ladder.size.LadderWidth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @DisplayName("참가자의 수는 2이상 이어야 한다.")
    @ParameterizedTest(name = "[{index}] participants: {0}")
    @MethodSource("createTooFewParticipantsArguments")
    void create_tooFewParticipants_throwsException(List<Participant> participants) {
        LadderLine ladderLine = LadderLine.of(new LadderWidth(2), () -> true);
        Ladder ladder = new Ladder(singletonList(ladderLine));

        assertThatThrownBy(() -> new LadderGame(participants, ladder))
                .isInstanceOf(TooFewParticipantsException.class);
    }

    @DisplayName("참가자의 수와 선물의 수는 같아야한다.")
    @ParameterizedTest(name = "[{index}] numberOfParticipants: {0}, numberOfGifts: {1}")
    @CsvSource({
            "2, 3",
            "2, 1",
            "8, 7",
            "6, 9",
    })
    void play_invalidNumberOfGifts_throwsException(int numberOfParticipants, int numberOfGifts) {
        List<Participant> participants = nCopies(numberOfParticipants, new Participant("길동"));
        List<Gift> gifts = nCopies(numberOfGifts, new Gift("선물"));

        GiftBundle giftBundle = new GiftBundle(gifts);
        LadderGame ladderGame = new LadderGame(participants, createLadder());

        assertThatThrownBy(() -> ladderGame.play(giftBundle))
                .isInstanceOf(InvalidNumberOfGiftsException.class);
    }

    public static Stream<Arguments> createTooFewParticipantsArguments() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(emptyList()),
                Arguments.of(singletonList(new Participant("홍길동")))
        );
    }
    
    /**
     *길동 훈이 짱구 맹구 순신 스프
     * |----|    |----|    |----|
     * |    |----|    |----|    |
     * |    |----|    |    |----|
     * |    |    |----|    |----|
     *감   귤   차   돈    공   쌀
     */
    @Test
    void play() {
        LadderGame ladderGame = new LadderGame(createParticipants(), createLadder());
        GiftBundle giftBundle = GiftBundle.from(asList("감", "귤", "차", "돈", "공", "쌀"));

        assertThat(ladderGame.play(giftBundle)).isEqualTo(new GameResult(expectedWinningGifts()));
    }

    private List<Participant> createParticipants() {
        return Participant.listOf(asList("길동", "훈이", "짱구", "맹구", "순신", "스프"));
    }

    private Ladder createLadder() {
        int width = 6;
        LadderLine first = ladderLine(width, asList(true, false, true, false, true));
        LadderLine second = ladderLine(width, asList(false, true, false, true, false));
        LadderLine third = ladderLine(width, asList(false, true, false, false, true));
        LadderLine fourth = ladderLine(width, asList(false, false, true, false, true));
        return new Ladder(asList(first, second, third, fourth));
    }

    private LadderLine ladderLine(int width, List<Boolean> creations) {
        return LadderLine.of(new LadderWidth(width), new FixedWayRule(creations));
    }

    private Map<Participant, Gift> expectedWinningGifts() {
        Map<Participant, Gift> winningGifts = new LinkedHashMap<>();
        winningGifts.put(new Participant("길동"), new Gift("귤"));
        winningGifts.put(new Participant("훈이"), new Gift("감"));
        winningGifts.put(new Participant("짱구"), new Gift("공"));
        winningGifts.put(new Participant("맹구"), new Gift("돈"));
        winningGifts.put(new Participant("순신"), new Gift("쌀"));
        winningGifts.put(new Participant("스프"), new Gift("차"));
        return winningGifts;
    }
}
