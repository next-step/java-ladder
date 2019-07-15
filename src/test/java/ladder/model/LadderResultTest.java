package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderResultTest {

    private Users users;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        users = new Users("dhlee,jwlee,gylee");

        List<LadderLine> ladderLines = new ArrayList <>();
        ladderLines.add(setUpDetail(TRUE, FALSE));
        ladderLines.add(setUpDetail(FALSE, TRUE));

        ladder = new Ladder(ladderLines);
    }

    private LadderLine setUpDetail(boolean startStatus, boolean nextStatus){
        StatusOfPoint statusOfPoint = StatusOfPoint.first(startStatus);

        List<Point> rowPoints = new ArrayList <>();
        Point rowPoint = new Point(0, statusOfPoint);
        statusOfPoint = statusOfPoint.next(nextStatus);
        rowPoints.add(rowPoint);
        rowPoints.add(new Point(1, statusOfPoint));
        rowPoints.add(new Point(2, statusOfPoint.last()));
        return new LadderLine(rowPoints);
    }

    @Test
    @DisplayName("사다리 게임 참여 수에 맞지 않게 결과 값을 입력 시 오류 테스트")
    void itemNotMatch() {
        String resultItem = "꽝,5000,2000,3000";
        Assertions.assertThatThrownBy(() -> new LadderResult(users, resultItem))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("사다리 게임 결과 값은 게임 참여자 수와 같아야 합니다.");
    }

    @Test
    @DisplayName("결과 보고싶은 사람 선택의 경우 존재하지 않는 사람 입력 시 오류 테스트")
    void notFoundUser() {
        String resultItem = "꽝,5000,2000";
        LadderResult ladderResult = new LadderResult(users, resultItem);
        User user = new User("yhlee");
        Ladder ladder = Ladder.of(2, "5");
        Assertions.assertThatThrownBy(() -> ladderResult.getUserResult(user, ladder))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("사다리 게임에 참여한 사용자 이름이 아닙니다.");
    }

    @Test
    @DisplayName("사다리 간격 조절을 윈한 상품 및 참여자 이름 길이 중 가장 큰 길이 테스트")
    void maxTextLength() {
        String resultItem = "3000000,5000,2000";
        LadderResult ladderResult = new LadderResult(users, resultItem);
        assertThat(ladderResult.maxLadderTextCount()).isEqualTo(7);
    }

    @Test
    @DisplayName("사다리 게임 실행에 따른 정상 결과(postion) 확인 테스트 ")
    void ladderRiding() {
        assertThat(ladder.ladderRid(0)).isEqualTo(2);
        assertThat(ladder.ladderRid(1)).isEqualTo(0);
        assertThat(ladder.ladderRid(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("지정 참여자 결과 추출 테스트")
    void ladderRidingReusltUser() {
        String resultItem = "1,5000,2000";
        LadderResult ladderResult = new LadderResult(users, resultItem);
        User user = new User("dhlee");
        LadderRidResult userRidResult = ladderResult.getUserResult(user, ladder);
        assertThat(userRidResult.getMatchResult()).isEqualTo("2000");
    }

    @Test
    @DisplayName("전체 참여자 결과 추출 테스트")
    void ladderRidingReusltAllUser() {
        String resultItem = "1,5000,2000";
        LadderResult ladderResult = new LadderResult(users, resultItem);
        LadderRidResult allUserRidResult = ladderResult.getAllUserResult(users, ladder);
        List <String> results = allUserRidResult.getAllUserMatchResult();
        assertThat(results.get(0)).isEqualTo("2000");
        assertThat(results.get(1)).isEqualTo("1");
        assertThat(results.get(2)).isEqualTo("5000");
    }

}
