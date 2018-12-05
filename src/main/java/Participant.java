import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participant {
	private String name;
	
	public Participant(String name) {
		this.name = name;
	}
	
	
	public static List<Participant> getParticipants(String[] split) {
		return Arrays.stream(split)
				.map(Participant::new)
				.collect(Collectors.toList());
	}
}
