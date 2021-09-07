package nextstep.ladder;

import nextstep.ladder.model.Person;
import nextstep.ladder.model.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderGameMakeUtilTest {
    @DisplayName("사람들 생성 테스트")
    @ParameterizedTest
    @CsvSource({"'crong, ap, cdd', 3", "'test', 1", "'a, b, c, d, ew, e', 6"})
    public void makePeopleTest(String input, int expected) {
        //when
        List<Person> people = LadderGameMakeUtil.makePeople(input);

        //then
        assertThat(people.size()).isEqualTo(expected);
    }

    @DisplayName("잘못 된 입력값을 받았을 때  사람들 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "", "abcdef", "abc, abce, abcdef", "abc, , ad"})
    public void wrongInputMakePeopleTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGameMakeUtil.makePeople(input));
    }

    @DisplayName("보상 생성 테스트")
    @ParameterizedTest
    @CsvSource({"'꽝, 1000, 4000', 3", "'5000', 1"})
    public void makeRewardsTest(String input, int expected) {
        //when
        List<Reward> rewards = LadderGameMakeUtil.makeRewards(input);

        //then
        assertThat(rewards.size()).isEqualTo(expected);
    }

    @DisplayName("잘못 된 입력값을 받았을 때  사람들 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "", "100000", "꽝, 꽝, 100000", "꽝, , 꽝"})
    public void wrongInputMakeRewardTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGameMakeUtil.makeRewards(input));
    }

    @DisplayName("잘못된 입력값에 의한 사다리 테스트")
    @ParameterizedTest
    @CsvSource({"-5,3", "3,-2", "0,2", "3,0", "0,0"})
    public void wrongInputMakeLadderTest(int numberOfPeople, int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderGameMakeUtil.makeLadder(numberOfPeople, height));
    }
}
