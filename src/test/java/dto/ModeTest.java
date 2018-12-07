package dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ModeTest {

    @Test
    public void enumTest() {
        assertThat(Mode.find("상")).isEqualTo(Mode.HELL);
        assertThat(Mode.find("중")).isEqualTo(Mode.HARDCORE);
        assertThat(Mode.find("하")).isEqualTo(Mode.NORMAL);
    }

    @Test
    public void 라인_그릴_가능성확인() {
        System.out.println((Mode.drawLineByPercentage(Mode.HELL)));
        System.out.println((Mode.drawLineByPercentage(Mode.HARDCORE)));
        System.out.println((Mode.drawLineByPercentage(Mode.NORMAL)));
    }
}
