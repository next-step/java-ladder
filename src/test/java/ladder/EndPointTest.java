package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EndPointTest {
    @Test
    public void 엔드포인트이름_5자() {
        // given
        String name = "하하하하하";
        // when
        EndPoint player = new EndPoint(name);
        // then
        assertThat(player.getName()).isEqualTo(name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 엔드포인트이름_5자초과() {
        // given
        String name = "하하하하하하";
        // when
        EndPoint player = new EndPoint(name);
        // then
    }

    @Test
    public void 엔드포인트이름_4자_출력시_길이5() {
        // given
        String name = "하하하하";
        // when
        EndPoint player = new EndPoint(name);
        // then
        assertThat(player.toString().length()).isEqualTo(5);
    }

    @Test
    public void 엔드포인트이름_5자_출력시_길이5() {
        // given
        String name = "하하하하하";
        // when
        EndPoint player = new EndPoint(name);
        // then
        assertThat(player.toString().length()).isEqualTo(5);
    }


}
