package nextstep.optional;

import nextstep.optional.Computer.SoundCard;
import nextstep.optional.Computer.USB;

import java.util.Optional;

public class ComputerStore {
    public static final String UNKNOWN_VERSION = "UNKNOWN";

    public static String getVersion(Computer computer) {
        String version = UNKNOWN_VERSION;
        if (computer != null) {
            SoundCard soundcard = computer.getSoundCard();
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
        return Optional.ofNullable(computer)
                       .map(Computer::getSoundCard)
                       .map(SoundCard::getUsb)
                       .map(USB::getVersion)
                       .orElse(UNKNOWN_VERSION);
    }
}
