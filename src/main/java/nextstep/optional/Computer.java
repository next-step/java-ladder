package nextstep.optional;

public final class Computer {
    private final Soundcard soundcard;

    public Computer(Soundcard soundcard) {
        this.soundcard = soundcard;
    }

    public final Soundcard getSoundcard() {
        return soundcard;
    }

    public static final class Soundcard {
        private USB usb;

        public Soundcard(USB usb) {
            super();
            this.usb = usb;
        }

        public final USB getUsb() {
            return usb;
        }
    }

    public static final class USB {
        private String version;

        public USB(String version) {
            super();
            this.version = version;
        }

        public final String getVersion() {
            return this.version;
        }
    }
}
