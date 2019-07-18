package ladder.domain;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SingleUserTest {
    @Test
    @DisplayName("SingleUser 생성")
    public void init() {
        System.out.println(SingleUser.init("ben", 0));
    }

    @Test
    @DisplayName("UserName 유효성 체크")
    public void checkUserName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> SingleUser.init("Bentley", 0))
                .withMessage("이름이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
    }

    @Test
    @DisplayName("User 사다리 게임 진행 후 User Postion 업데이트 체크")
    public void playLadderLine() {
        UserGroup userGroup = new UserGroup("a,b,c,d");
        LadderFactory factory = new LadderFactory(5, userGroup.getUserGroup().size());
        System.out.println(userGroup.getUserGroup().get(0));
        userGroup.getUserGroup().get(0).playLadderGame(factory.getLadder());
        System.out.println(userGroup.getUserGroup().get(0));
    }
}
