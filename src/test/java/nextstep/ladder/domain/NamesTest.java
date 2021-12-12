package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NamesTest {

    @DisplayName("참가자 이름목록 생성 테스트")
    @Test
    void create() {
        String nameInput = "kjh,sjw";
        Names names = Names.from(nameInput);

        assertThat(names).isNotNull();
        assertThat(names.entryMemberCount()).isEqualTo(2);
    }

    @DisplayName("참가자는 2명 이상이어야 한다.")
    @Test
    void entryMemberMoreThanTwo() {
        assertThatThrownBy(() -> Names.from("kjh"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자는 2명 이상이어야 합니다.");
    }
}
