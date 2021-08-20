package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;
import nextstep.optional.OptionalComputer.OptionalSoundcard;
import nextstep.optional.OptionalComputer.OptionalUSB;
import org.junit.jupiter.api.Test;

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
        OptionalSoundcard soundcard = new OptionalSoundcard(new OptionalUSB(version));
        OptionalComputer optionalComputer = new OptionalComputer(soundcard);
        assertThat(ComputerStore.getVersionOptional(optionalComputer)).isEqualTo(version);
    }

    @Test
    public void getVersionOptionalWhenComputerIsNull() throws Exception {
        assertThat(ComputerStore.getVersionOptional(null)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @Test
    public void getVersionOptionalWhenSoundcardIsNull() throws Exception {
        OptionalComputer optionalComputer = new OptionalComputer(null);
        assertThat(ComputerStore.getVersionOptional(optionalComputer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @Test
    public void getVersionOptionalWhenUSBIsNull() throws Exception {
        OptionalComputer optionalComputer = new OptionalComputer(new OptionalSoundcard(null));
        assertThat(ComputerStore.getVersionOptional(optionalComputer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }
}
