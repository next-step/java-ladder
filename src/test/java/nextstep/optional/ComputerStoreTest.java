package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerStoreTest {
    @Test
    public void getVersion() {
        String version = "pobi's usb";
        Soundcard soundcard = new Soundcard(new USB(version));
        Computer computer = new Computer(soundcard);
        assertThat(ComputerStore.getVersion(computer)).isEqualTo(version);
    }

    @Test
    public void getVersionWhenComputerIsNull() throws Exception {
        assertThat(ComputerStore.getVersion(null)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @Test
    public void getVersionWhenSoundcardIsNull() throws Exception {
        Computer computer = new Computer(null);
        assertThat(ComputerStore.getVersion(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @Test
    public void getVersionWhenUSBIsNull() throws Exception {
        Computer computer = new Computer(new Soundcard(null));
        assertThat(ComputerStore.getVersion(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @Test
    public void getVersionOptional() {
        String version = "pobi's usb";
        Soundcard soundcard = new Soundcard(new USB(version));
        Computer computer = new Computer(soundcard);

        Optional<String> versionOptional = ComputerStore.getVersionOptional(computer);

        assertThat(versionOptional.isPresent()).isTrue();
        assertThat(versionOptional.get()).isEqualTo(version);
    }

    @Test
    public void getVersionOptionalWhenComputerIsNull() throws Exception {
        Optional<String> versionOptional = ComputerStore.getVersionOptional(null);

        assertThat(versionOptional.isPresent()).isTrue();
        assertThat(versionOptional.get()).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @Test
    public void getVersionOptionalWhenSoundcardIsNull() throws Exception {
        Computer computer = new Computer(null);

        Optional<String> versionOptional = ComputerStore.getVersionOptional(computer);

        assertThat(versionOptional.isPresent()).isTrue();
        assertThat(versionOptional.get()).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @Test
    public void getVersionOptionalWhenUSBIsNull() throws Exception {
        Computer computer = new Computer(new Soundcard(null));

        Optional<String> versionOptional = ComputerStore.getVersionOptional(computer);

        assertThat(versionOptional.isPresent()).isTrue();
        assertThat(versionOptional.get()).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }
}
