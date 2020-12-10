package ladder.domain;

import ladder.domain.LadderLevelGenerator;
import ladder.domain.LevelItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLevelGeneratorTest {

    LadderLevelGenerator generator ;

    @BeforeEach
    void setUp(){
        generator = LadderLevelGenerator.auto();
    }

    @DisplayName("ladder level 은 bar-step-bar-step-bar 로 구성된다. bar 로 시작해서 bar 로 끝난다")
    @Test
    void generate(){
        List<LevelItem> items = generator.generate(5);

        assertThat(items).hasSize(5);
        assertThat(items.get(0).getType()).isEqualTo(LevelItem.Type.Bar);
        assertThat(items.get(1).getType()).isNotEqualTo(LevelItem.Type.Bar);
        assertThat(items.get(2).getType()).isEqualTo(LevelItem.Type.Bar);
        assertThat(items.get(3).getType()).isNotEqualTo(LevelItem.Type.Bar);
        assertThat(items.get(4).getType()).isEqualTo(LevelItem.Type.Bar);

    }

    @DisplayName("ladder level 에서 step 은 연속해서 만들수 없다")
    @Test
    void shouldNotContinuesStep(){
        List<LevelItem> items = generator.generate(5);

        if( items.get(1).isStep() ) assertThat(items.get(3).isStep()).isEqualTo(false);
        if( items.get(3).isStep() ) assertThat(items.get(1).isStep()).isEqualTo(false);
    }

}