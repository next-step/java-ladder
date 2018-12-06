package domain;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayResultTest {

    @Test
    public void result_에_맞는_참여자와_결과_맵핑을_반환() {
        Participants participants = Participants.from("aaa,bbb");
        Rewards rewards = Rewards.from("good,bad");

        PlayResult playResult = new PlayResult(Position.from(0), Position.from(0));
        Map.Entry<Participant, String> entry = playResult.getEntry(participants, rewards);

        assertThat(entry.getKey()).isEqualTo(participants.get(0));
        assertThat(entry.getValue()).isEqualTo(rewards.get(0));
    }
}