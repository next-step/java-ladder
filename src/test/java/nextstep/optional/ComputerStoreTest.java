package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerStoreTest {

    @DisplayName("컴퓨터에 내장된 usb 버전을 반환하는지 테스트")
    @Test
    public void getVersion() {
        String version = "pobi's usb";
        Soundcard soundcard = new Soundcard(new USB(version));
        Computer computer = new Computer(soundcard);
        assertThat(ComputerStore.getVersion(computer)).isEqualTo(version);
    }

    @DisplayName("컴퓨터가 null 일 경우 디폴트 버전을 반환하는지 테스트")
    @Test
    public void getVersionWhenComputerIsNull() throws Exception {
        assertThat(ComputerStore.getVersion(null)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @DisplayName("사운드카드가 null 일 경우 디폴트 버전을 반환하는지 테스트")
    @Test
    public void getVersionWhenSoundcardIsNull() throws Exception {
        Computer computer = new Computer(null);
        assertThat(ComputerStore.getVersion(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @DisplayName("USB가 null 일 경우 디폴트 버전을 반환하는지 테스트")
    @Test
    public void getVersionWhenUSBIsNull() throws Exception {
        Computer computer = new Computer(new Soundcard(null));
        assertThat(ComputerStore.getVersion(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @DisplayName("Optional을 이용하여 객체중 하나라도 null 일 경우 디폴트 버전을 반환하는지 테스트")
    @Test
    public void getVersionOptional() {
        String version = "pobi's usb";
        Soundcard soundcard = new Soundcard(new USB(version));
        Computer computer = new Computer(soundcard);
        assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(version);
    }

    @DisplayName("Optional을 이용하여 컴퓨터가 null 일 경우 디폴트 버전을 반환하는지 테스트")
    @Test
    public void getVersionOptionalWhenComputerIsNull() throws Exception {
        assertThat(ComputerStore.getVersionOptional(null)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @DisplayName("Optional을 이용하여 사운드카드가 null 일 경우 디폴트 버전을 반환하는지 테스트")
    @Test
    public void getVersionOptionalWhenSoundcardIsNull() throws Exception {
        Computer computer = new Computer(null);
        assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }

    @DisplayName("Optional을 이용하여 USB가 null 일 경우 디폴트 버전을 반환하는지 테스트")
    @Test
    public void getVersionOptionalWhenUSBIsNull() throws Exception {
        Computer computer = new Computer(new Soundcard(null));
        assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
    }
}
