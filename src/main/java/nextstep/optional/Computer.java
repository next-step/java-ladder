package nextstep.optional;

public class Computer {

  private final Soundcard soundcard;

  public Computer(Soundcard soundcard) {
    this.soundcard = soundcard;
  }

  public Soundcard getSoundcard() {
    return soundcard;
  }

  public static class Soundcard {

    private final UniversalSerialBus universalSerialBus;

    public Soundcard(UniversalSerialBus universalSerialBus) {
      super();
      this.universalSerialBus = universalSerialBus;
    }

    public UniversalSerialBus getUsb() {
      return universalSerialBus;
    }
  }

  public static class UniversalSerialBus {

    private final String version;

    public UniversalSerialBus(String version) {
      super();
      this.version = version;
    }

    public String getVersion() {
      return this.version;
    }
  }
}
