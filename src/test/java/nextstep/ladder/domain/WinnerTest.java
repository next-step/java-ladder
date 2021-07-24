package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinnerTest {
    @Test
    void create() {
        Member member = Member.of("pobi");
        Winner winner = Winner.of(member, Prize.of("5000"));
        assertThat(winner.member()).isEqualTo(member);
    }
}