package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GoalsTest {

    @Test
    public void goal등록() {
        String results = "꽝,5000,꽝,3000";
        Goals goals = new Goals(results);
        int position = 1;
        assertThat(goals.result(position)).isEqualTo("5000");
    }
}