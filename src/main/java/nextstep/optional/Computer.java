package nextstep.optional;

import java.util.Optional;

public class Computer {
    private SoundCard soundCard;

    public Computer(SoundCard soundCard) {
        this.soundCard = soundCard;
    }


    public SoundCard getSoundCard() {
        return soundCard;
    }

    public static class SoundCard {
        private USB usb;

        public SoundCard(USB usb) {
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
