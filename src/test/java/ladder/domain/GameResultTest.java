package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class GameResultTest {

    Users users;
    Ladder ladder;
    LadderResults ladderResults;

    @BeforeEach
    public void setup() {
        users = Users.create("pobi,honux,crong,jk");
        ladder = Ladder.create(getLines());
        ladderResults = LadderResults.create("꽝,5000,꽝,3000");
    }

    @Test
    public void 사다리와_참여자_그리고_사다리결과를_받아서_사다리게임_객체를_만들_수_있다() {
        //given
        //when
        GameResult gameResult = GameResult.create(users, ladder, ladderResults);
        //then
        assertAll(
                () -> assertEquals(GameResult.create(users, ladder, ladderResults), gameResult),
                () -> assertEquals(LadderResult.create("꽝"), gameResult.resultOf(User.create("pobi"))),
                () -> assertEquals(LadderResult.create("5000"), gameResult.resultOf(User.create("honux")))
        );
    }

    @Test
    public void 없는_사용자를_조회_시_익셉션이_발생한다() {
        //given
        //when
        GameResult gameResult = GameResult.create(users, ladder, ladderResults);
        //then
        assertThatThrownBy(() -> gameResult.resultOf(User.create("hoski")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("찾을 수 없는 참여자입니다.");
    }

    @Test
    public void 모든_참여자에_대한_결과를_얻을_수_있다() {
        //given
        GameResult gameResult = GameResult.create(users, Ladder.create(getLines()), ladderResults);
        //when
        Map<User, LadderResult> result = gameResult.getAll();
        //then
        assertThat(result.keySet()).isEqualTo(getExpectHashMap().keySet());
        assertThat(result.values()).containsAll(getExpectHashMap().values());
    }

    private Line[] getLines() {
        /*
            |-----|     |-----|
            |     |-----|     |
            |-----|     |     |
         */
        return new Line[]{
                Line.create(true, false, true),
                Line.create(false, true, false),
                Line.create(true, false, false)
        };
    }

    private Map<User, LadderResult> getExpectHashMap() {
        Map<User, LadderResult> map = new HashMap<>();
        map.put(User.create("crong"), LadderResult.create("꽝"));
        map.put(User.create("jk"), LadderResult.create("꽝"));
        map.put(User.create("pobi"), LadderResult.create("꽝"));
        map.put(User.create("honux"), LadderResult.create("5000"));
        return map;
    }

}
