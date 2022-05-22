package nextstep.optional;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;

public class ComputerStore {

  public static final String UNKNOWN_VERSION = "UNKNOWN";

  public static String getVersion(Computer computer) {
    String version = UNKNOWN_VERSION;
    if (computer != null) {
      Soundcard soundcard = computer.getSoundcard();
      if (soundcard != null) {
        USB usb = soundcard.getUsb();
        if (usb != null) {
          version = usb.getVersion();
        }
      }
    }
    return version;
  }

  public static String getVersionOptional(Computer computer) {
    AtomicReference<String> version = new AtomicReference<>(UNKNOWN_VERSION);
    Optional.ofNullable(computer)
        .ifPresent(c -> Optional.ofNullable(c.getSoundcard())
            .ifPresent(soundcard -> Optional.ofNullable(soundcard.getUsb())
                .ifPresent(usb -> version.set(usb.getVersion()))));

    return version.get();
  }
}
