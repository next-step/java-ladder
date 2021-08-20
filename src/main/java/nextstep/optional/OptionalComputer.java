package nextstep.optional;


import java.util.Optional;

public class OptionalComputer {
    private Optional<OptionalSoundcard> soundcard;


    public OptionalComputer(OptionalSoundcard soundcard) {
        this.soundcard = Optional.ofNullable(soundcard);
    }

    public Optional<OptionalSoundcard> getSoundcard() {
        return soundcard;
    }

    public static class OptionalSoundcard {
        private Optional<OptionalUSB> usb;

        public OptionalSoundcard(OptionalUSB usb) {
            super();
            this.usb = Optional.ofNullable(usb);
        }

        public Optional<OptionalUSB> getUsb() {
            return usb;
        }
    }

    public static class OptionalUSB {
        private Optional<String> version;

        public OptionalUSB(String version) {
            super();
            this.version = Optional.ofNullable(version);
        }

        public Optional<String> getVersion() {
            return this.version;
        }
    }
}
