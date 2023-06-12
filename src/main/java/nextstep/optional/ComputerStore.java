package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.UniversalSerialBus;

public class ComputerStore {

  public static final String UNKNOWN_VERSION = "UNKNOWN";

  public static String getVersion(Computer computer) {
    String version = UNKNOWN_VERSION;
    if (computer != null) {
      Soundcard soundcard = computer.getSoundcard();
      if (soundcard != null) {
        UniversalSerialBus universalSerialBus = soundcard.getUsb();
        if (universalSerialBus != null) {
          version = universalSerialBus.getVersion();
        }
      }
    }
    return version;
  }

  public static String getVersionOptional(Computer computer) {
    return null;
  }
}
