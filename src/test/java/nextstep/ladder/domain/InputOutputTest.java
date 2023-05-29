package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputOutputTest {

    @Test
    void input_output_개수_다를경우_예외처리() {
        //given
        People people = new People(new String[]{"a", "b"});
        ExecuteResults executeResults = new ExecuteResults(new String[]{"꽝"});

        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputOutput(people, executeResults))
                .withMessageContaining("참여할 사람 수와 실행 결과 수는 일치해야 합니다.");
    }
}
