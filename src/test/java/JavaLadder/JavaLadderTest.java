package JavaLadder;

import JavaLadder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JavaLadderTest {
    @Test
    @DisplayName("입력된 사람수 테스트")
    public void userTest() {
        List<User> list = Arrays.asList(new User("pobi"), new User("honux"), new User("crong"), new User("jk"));
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("입력된 문자 사람클래스 테스트")
    public void userInputTest() {
        String inputValue = "pobi,honux,crong,jk";
        String[] splitInputValue = inputValue.split(",");
        User user = new User(splitInputValue[0], 0);
        User user1 = new User(splitInputValue[1], 1);
        User user2 = new User(splitInputValue[2], 2);
        User user3 = new User(splitInputValue[3], 3);
        assertThat(user1.getName()).isEqualTo("honux");
    }

    @Test
    @DisplayName("입력 자릿수테스트")
    public void userValidationTest() {
        String inputValue = "pobi12";
        String[] splitInputValue = inputValue.split(",");
        assertThatThrownBy(() -> {
            new User(splitInputValue[0]);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[" + splitInputValue[0] + "]: 5자리이하만입력가능합니다.");
    }

    @Test
    @DisplayName("사다리생성테스트")
    public void ladderTest() {
        Ladder ladder = new Ladder(3, 5);
        System.out.println(ladder);
        assertThat(ladder.countLadder()).isLessThan(2);
    }

    @Test
    @DisplayName("라인중복생성불가테스트")
    public void lineDuplicateTest() {
        Line line = new Line(3);
        System.out.println(line);
        System.out.println(line.countLine());
        assertThat(line.countLine()).isLessThan(2);
    }

    @Test
    @DisplayName("상품입력테스트")
    public void prizeTest() {
        Prizes prizes = new Prizes("1000원,꽝");
        assertThat(prizes.getPrize(0)).isEqualTo("1000원");
    }

    @Test
    @DisplayName("상품벨리데이션테스트")
    public void prizeValidationTest() {
        Users users = new Users(("test"));
        Prizes prizes = new Prizes("1000원,꽝");
        assertThatThrownBy(() -> {
            JavaLadder.validateSize(users, prizes);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사람입력 수(" + users.size() + ")와 실행결과입력 수(" + prizes.size() + ")같아야합니다.");
    }

    @Test
    @DisplayName("좌표생성테스트")
    public void pointTest() {
        Point point = new Point();
        assertThat(point.getPoint()).isEqualTo(0);
    }

    @Test
    @DisplayName("좌표이동테스트왼쪽")
    public void pointMoveLeft() {
        Point point = new Point(1);
        point.leftMove();
        assertThat(point.getPoint()).isEqualTo(0);
    }

    @Test
    @DisplayName("좌표이동테스트오른쪽")
    public void pointMoveRight() {
        Point point = new Point(1);
        point.rightMove();
        assertThat(point.getPoint()).isEqualTo(2);
    }

    @Test
    @DisplayName("사람별 포인트가지고오는 테스트")
    public void userPointTest() {
        Users users = new Users(("test,test1,test2"));
        assertThat(users.getUserPoint("test1")).isEqualTo(new Point(1));
    }

    @Test
    @DisplayName("라인의방향확인테스트")
    public void lineTest() {
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(false);
        Line line = new Line(list);

        Point point = new Point(1);
        line.moveByLine(point);
        assertThat(point.getPoint()).isEqualTo(0);
    }
}
