package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatusTest {


    @Test
    public void move_left() {
        Status status = Status.ofFisrt(true).createNext(false);
        assertThat(status.move()).isEqualTo(-1);
    }

    @Test
    public void move_right() {
        Status status = Status.ofFisrt(true);
        assertThat(status.move()).isEqualTo(1);
    }

    @Test
    public void move_straight() {
        Status status = Status.ofFisrt(false);
        assertThat(status.move()).isEqualTo(0);
    }

    @Test
    public void createFirst_왼쪽은False() {
        Status status1 = Status.ofFisrt(true);
        Status status2 = Status.ofFisrt(false).createNext(true);
        assertThat(status1).isEqualTo(status2);
    }

    @Test
    public void createLast_오른쪽은False() {
        Status status1 = Status.ofFisrt(true).createNext(true);
        status1.changeToLastStatus();
        Status status2 = Status.ofFisrt(true).createNext(false);
        assertThat(status1).isEqualTo(status2);
    }

    @Test
    public void TrueTrue_생성해도_TrueFalse() {
        Status status1 = Status.ofFisrt(true).createNext(true);
        Status status2 = Status.ofFisrt(true).createNext(false);
        assertThat(status1).isEqualTo(status2);
    }


}