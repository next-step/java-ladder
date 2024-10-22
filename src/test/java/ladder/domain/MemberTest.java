package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MemberTest {
    public static final Member m1 = new Member("hee");
    public static final Member m2 = new Member("chul");
    public static final Member m3 = new Member("chul");


    @Test
    @DisplayName("생성자로 이름을 생성한다.")
    void 이름_생성() {
        assertThat(m1.getName()).isEqualTo("hee");
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우 예외를 발생시킨다.")
    void 이름이5자초과() {
        assertThatThrownBy(() -> new Member("asdasd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
