package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @DisplayName("참가자가 2명보다 적다면 예외발생")
    @Test
    void 최소_참가인원() {
        assertThatThrownBy(() -> new Participants(new ArrayList<>(Arrays.asList("choi"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 2명 이상 참가해야됩니다.");
    }

    @DisplayName("참가자가 존재하는지 여부를 리턴")
    @ParameterizedTest
    @CsvSource(value = {"choi:true", "jae:true", "hyeon:true", "java:false"}, delimiter = ':')
    void 참가자_존재여부(String name, boolean flag) {
        Participants participants = new Participants(new ArrayList<>(Arrays.asList("choi", "jae", "hyeon")));
        assertThat(participants.isParticipants(name)).isEqualTo(flag);
    }
}