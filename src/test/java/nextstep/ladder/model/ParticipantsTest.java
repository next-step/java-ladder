package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantsTest {
    @Test
    @DisplayName("사다리 게임할 참가자의 수와 참가자 명단의 숫자가 일치하는지 확인합니다.")
    void join() {
        List<String> names = List.of("a", "b", "c");
        Participants participants = new Participants(names);
        assertThat(names).hasSize(participants.size());
    }

    @Test
    @DisplayName("참가자는 최소 2명이상이어야 합니다.")
    void createTwoBars() {
        List<String> names = List.of("a");
        assertThrows(IllegalArgumentException.class, () -> {
            new Participants(names);
        });
    }
}