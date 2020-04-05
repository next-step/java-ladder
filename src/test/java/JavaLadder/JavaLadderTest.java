package JavaLadder;

import JavaLadder.domain.Ladder;
import JavaLadder.domain.Line;
import JavaLadder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    public void userInputTest(){
        String inputValue = "pobi,honux,crong,jk";
        String[] splitInputValue = inputValue.split(",");
        User user = new User(splitInputValue[0]);
        User user1 = new User(splitInputValue[1]);
        User user2 = new User(splitInputValue[2]);
        User user3 = new User(splitInputValue[3]);
        assertThat(user1.getName()).isEqualTo("honux");
    }

    @Test
    @DisplayName("입력 자릿수테스트")
    public void userValidationTest() {
        String inputValue = "pobi12";
        String[] splitInputValue = inputValue.split(",");
        assertThatThrownBy(() -> {new User(splitInputValue[0]);}).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("5자리이하만입력가능합니다.");
    }

    @Test
    @DisplayName("사다리생성테스트")
    public void ladderTest() {
        Ladder ladder = new Ladder(3,5);
        System.out.println(ladder);
        assertThat(ladder.countLadder(ladder)).isLessThan(2);
    }

    @Test
    @DisplayName("라인중복생성불가테스트")
    public void lineDuplicateTest() {
        Line line = new Line(3);
        System.out.println(line);
        assertThat(line.countLine(line)).isLessThan(2);
    }
    


}
