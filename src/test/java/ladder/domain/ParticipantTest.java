package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {
    @Test
    @DisplayName("참가자 이름이 비어있거나, 5글자를 초과할 경우 에러 발생")
    void 참가자_이름_확인_실패() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Participant("aaaaaa"));
        assertThatIllegalArgumentException().isThrownBy(() -> new Participant(""));
    }

    @Test
    @DisplayName("참가자 이름 생성")
    void 참가자_이름_성공() {
        assertThat(new Participant("aaaaa").getName()).isEqualTo("aaaaa");
        assertThat(new Participant("bbbb").getName()).isEqualTo("bbbb");
        assertThat(new Participant("ccc").getName()).isEqualTo("ccc");
        assertThat(new Participant("dd").getName()).isEqualTo("dd");
        assertThat(new Participant("e").getName()).isEqualTo("e");
    }

}