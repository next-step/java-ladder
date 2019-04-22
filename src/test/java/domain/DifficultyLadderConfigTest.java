package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DifficultyLadderConfigTest {
    @Test
    public void 전달한_길이만큼_boolean_list를_반환한다() {
        DifficultyLadderConfig difficultyLadderConfig =
            new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.POOR);

        assertThat(difficultyLadderConfig.booleans()).hasSize(5);
    }

    @Test
    public void 난이도가_하_이면_길이와_높이가_같다() {
        DifficultyLadderConfig difficultyLadderConfig
            = new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.POOR);
        assertThat(difficultyLadderConfig.height()).isEqualTo(5);


        difficultyLadderConfig = new DifficultyLadderConfig(6, DifficultyLadderConfig.Difficulty.POOR);
        assertThat(difficultyLadderConfig.height()).isEqualTo(6);
    }

    @Test
    public void 난이도만큼_높이가_길어진다() {
        DifficultyLadderConfig difficultyLadderConfig
            = new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.POOR);
        assertThat(difficultyLadderConfig.height()).isEqualTo(5);

        difficultyLadderConfig = new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.FAIR);
        assertThat(difficultyLadderConfig.height()).isEqualTo(10);

        difficultyLadderConfig = new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.GOOD);
        assertThat(difficultyLadderConfig.height()).isEqualTo(20);
    }

    @Test
    public void 난이도가_높아질수록_TRUE가_더많이_나온다() {
        DifficultyLadderConfig difficultyLadderConfig
            = new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.POOR);
        assertThat(difficultyLadderConfig.booleans().stream()
            .filter(b -> b.equals(Boolean.TRUE)).count()).isEqualTo(1);

        difficultyLadderConfig = new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.FAIR);
        assertThat(difficultyLadderConfig.booleans().stream()
            .filter(b -> b.equals(Boolean.TRUE)).count()).isEqualTo(2);

        difficultyLadderConfig = new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.GOOD);
        assertThat(difficultyLadderConfig.booleans().stream()
            .filter(b -> b.equals(Boolean.TRUE)).count()).isEqualTo(4);
    }
}
