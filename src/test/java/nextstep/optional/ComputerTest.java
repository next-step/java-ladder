package nextstep.optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    private Computer computer;
    private Computer.Soundcard soundcard;
    private Computer.USB usb;

    @BeforeEach
    void setUp() {
        this.usb = new Computer.USB("1.0");
        this.soundcard = new Computer.Soundcard(usb);
        this.computer = new Computer(soundcard);
    }

    @Test
    void getVersion() {
        assertThat(usb.getVersion()).isEqualTo("1.0");
        assertThat(soundcard.getVersion()).isEqualTo(Optional.of("1.0"));
        assertThat(computer.getVersion()).isEqualTo(Optional.of("1.0"));
    }

    @Test
    void getVersionWithNull() {
        assertThat(new Computer.USB(null).getVersion()).isEqualTo(null);
        assertThat(new Computer.Soundcard(null).getVersion()).isEqualTo(Optional.empty());
        assertThat(new Computer.Soundcard(null).getVersion()).isEqualTo(Optional.empty());
    }
}
