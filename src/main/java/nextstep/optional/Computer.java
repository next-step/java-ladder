package nextstep.optional;

public class Computer {
    private Soundcard soundcard;

    public Computer(Soundcard soundcard) {
        this.soundcard = soundcard;
    }

    public Soundcard getSoundcard() {
        return soundcard;
    }

    public static class Soundcard {
        private USB usb;

        public Soundcard(USB usb) {
            super();
            this.usb = usb;
        }

        public USB getUsb() {
            return usb;
        }
    }

    public static class USB {
        private String version;

        public USB(String version) {
            super();
            this.version = version;
        }

        public String getVersion() {
            return this.version;
        }
    }
}
