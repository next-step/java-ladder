package nextstep.optional;

import java.util.Optional;

public class Computer {
    private Optional<Soundcard> soundcard;

    public Computer(Optional<Soundcard> soundcard) {
        this.soundcard = soundcard;
    }

    public Optional<Soundcard> getSoundcard() {
        return soundcard;
    }

    public static class Soundcard {
        private Optional<USB> usb;

        public Soundcard(Optional<USB> usb) {
            super();
            this.usb = usb;
        }

        public Optional<USB> getUsb() {
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
