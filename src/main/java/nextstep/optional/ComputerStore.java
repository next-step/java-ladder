package nextstep.optional;

import java.util.Optional;
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
		return Optional.ofNullable(computer)
			.stream()
			.map(computer1 -> getVersion(computer1))
			.findFirst()
			.orElse(UNKNOWN_VERSION);
	}
}
