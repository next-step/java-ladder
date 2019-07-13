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

public class ResultTest {

    private Users users;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        users = new Users("dhlee,jwlee,gylee");

        StatusOfPoint firstRow = StatusOfPoint.first(TRUE);
        StatusOfPoint secondRow = StatusOfPoint.first(FALSE);

        List<Point> firstRowPoints = new ArrayList<>();
        Point firstRowPoint0 = new Point(0, firstRow);
        firstRow = firstRow.next(FALSE);
        firstRowPoints.add(firstRowPoint0);
        firstRowPoints.add(new Point(1, firstRow));
        firstRowPoints.add(new Point(2, firstRow.last()));

        List<Point> secondRowPoints = new ArrayList <>();
        Point secondRowPoint0 = new Point(0, secondRow);
        secondRow = secondRow.next(TRUE);
        secondRowPoints.add(secondRowPoint0);
        secondRowPoints.add(new Point(1, secondRow));
        secondRowPoints.add(new Point(2, secondRow.last()));

        List<LadderLine> ladderLines = new ArrayList <>();
        ladderLines.add(new LadderLine(firstRowPoints));
        ladderLines.add(new LadderLine(secondRowPoints));

        ladder = new Ladder(ladderLines);
    }

    @Test
    @DisplayName("사다리 게임 참여 수에 맞지 않게 결과 값을 입력 시 오류 테스트")
    void itemNotMatch() {
        String resultItem = "꽝,5000,2000,3000";
        Assertions.assertThatThrownBy(() -> new Result(users, resultItem))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("사다리 게임 결과 값은 게임 참여자 수와 같아야 합니다.");
    }

    @Test
    @DisplayName("결과 보고싶은 사람 선택의 경우 존재하지 않는 사람 입력 시 오류 테스트")
    void notFoundUser(){
        String resultItem = "꽝,5000,2000";
        Result result = new Result(users, resultItem);
        User user = new User("yhlee");
        Ladder ladder = Ladder.of(2, "5");
        Assertions.assertThatThrownBy(() -> result.getUserResult(user, ladder))
                  .isInstanceOf(IllegalStateException.class)
                  .hasMessage("사다리 게임에 참여한 사용자 이름이 아닙니다.");
    }

    @Test
    @DisplayName("사다리 간격 조절을 윈한 상품 및 참여자 이름 길이 중 가장 큰 길이 테스트")
    void maxTextLength(){
        String resultItem = "3000000,5000,2000";
        Result result = new Result(users, resultItem);
        assertThat(result.maxLadderTextCount()).isEqualTo(7);
    }

    @Test
    @DisplayName("사다리 게임 실행에 따른 정상 결과(postion) 확인 테스트 ")
    void ladderRiding(){
        assertThat(ladder.ladderRiding(0)).isEqualTo(2);
        assertThat(ladder.ladderRiding(1)).isEqualTo(0);
        assertThat(ladder.ladderRiding(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("지정 참여자 결과 추출 테스트")
    void ladderRidingReusltUser(){
        String resultItem = "1,5000,2000";
        Result result = new Result(users, resultItem);
        User user = new User("dhlee");
        assertThat(result.getUserResult(user, ladder)).isEqualTo("2000");
    }

    @Test
    @DisplayName("전체 참여자 결과 추출 테스트")
    void ladderRidingReusltAllUser(){
        String resultItem = "1,5000,2000";
        Result result = new Result(users, resultItem);
        List<String> results = result.getAllUserResult(users, ladder);
        assertThat(results.get(0)).isEqualTo("2000");
        assertThat(results.get(1)).isEqualTo("1");
        assertThat(results.get(2)).isEqualTo("5000");
    }

}
