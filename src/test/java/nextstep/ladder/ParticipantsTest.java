package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

    @Test
    @DisplayName("일급객체 생성 확인")
    void create1(){
        Participants participants = Participants.of("man1","man2","man3");
        assertThat(participants.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("일급객체 생성 확인( ',' 포함한 문자열로 생성)")
    void create2(){
        Participants participants = Participants.of("man1,man2,man3");
        assertThat(participants.size()).isEqualTo(3);
    }


    @Test
    @DisplayName("참가자 2명 미만이면 에러 발생")
    void checkValidation(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> Participants.of("man1")
        ).withMessageContaining("이상");
    }
}