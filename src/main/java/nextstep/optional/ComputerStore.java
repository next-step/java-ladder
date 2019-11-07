package nextstep.optional;

import nextstep.optional.Computer.SoundCard;
import nextstep.optional.Computer.USB;

public class ComputerStore {
	public static final String UNKNOWN_VERSION = "UNKNOWN";
	
	public static String getVersion(Computer computer) {
		String version = UNKNOWN_VERSION;
		if(computer != null){
		  SoundCard soundCard = computer.getSoundCard();
		  if(soundCard != null){
		    USB usb = soundCard.getUsb();
		    if(usb != null){
		      version = usb.getVersion();
		    }
		  }
		}
		return version;
	}
	
	public static String getVersionOptional(Computer computer) {
		return null;
	}
}
