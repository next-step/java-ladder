package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.member.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 테스트")
public class LadderTest {
    @DisplayName("참여자 수만큼 사다리 생성")
    @Test
    public void createLadderWithMember() {
        Members members = Members.of(Arrays.asList("pobi", "honux", "crong", "jk"));

        Ladder ladder = Ladder.of(members, 5);

        assertThat(ladder.getMembersCount()).isEqualTo(4);
    }

    @DisplayName("주어진 높이로 사다리 생성")
    @Test
    public void createLadderWithHeight() {
        int height = Ladder.of(Members.of(Arrays.asList("pobi", "honux", "crong", "jk")), 5).getHeight();

        assertThat(height).isEqualTo(5);
    }

    @DisplayName("0이하 높이로 사다리 생성")
    @ParameterizedTest
    @CsvSource(value = {"-1", "0"})
    public void createLadderWithInvalidHeight(int invalidHeight) {
        assertThatThrownBy(() -> {
            Ladder.of(Members.of(Arrays.asList("pobi", "honux", "crong", "jk")), invalidHeight);
        }).isInstanceOf(InvalidLadderHeightException.class)
                .hasMessageContaining("사다리 높이는 1이상이어야 합니다.");
    }

}