package nextstep.optional;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.UniversalSerialBus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class ComputerStoreTest {

  @Test
  public void getVersion() {
    String version = "pobi's usb";
    Soundcard soundcard = new Soundcard(new UniversalSerialBus(version));
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
  public void getVersionWhenUsbIsNull() throws Exception {
    Computer computer = new Computer(new Soundcard(null));
    assertThat(ComputerStore.getVersion(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
  }

  @Test
  public void getVersionOptional() {
    String version = "pobi's usb";
    Soundcard soundcard = new Soundcard(new UniversalSerialBus(version));
    Computer computer = new Computer(soundcard);
    assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(version);
  }

  @Test
  public void getVersionOptionalWhenComputerIsNull() throws Exception {
    assertThat(ComputerStore.getVersionOptional(null)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
  }

  @Test
  public void getVersionOptionalWhenSoundcardIsNull() throws Exception {
    Computer computer = new Computer(null);
    assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
  }

  @Test
  public void getVersionOptionalWhenUsbIsNull() throws Exception {
    Computer computer = new Computer(new Soundcard(null));
    assertThat(ComputerStore.getVersionOptional(computer)).isEqualTo(ComputerStore.UNKNOWN_VERSION);
  }
}
