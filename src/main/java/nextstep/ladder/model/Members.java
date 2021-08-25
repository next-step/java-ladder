package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Members {

	private List<Member> members;

	private Members(List<Member> members) {
		this.members = members;
	}

	public static Members of(List<String> members) {
		List<Member> memberList = members.stream()
										.map(Member::new)
										.collect(Collectors.toCollection(ArrayList<Member>::new));

		return new Members(memberList);
	}

	public static Members of(String members) {
		return of(Arrays.stream(members.split(","))
					.map(String::trim)
					.collect(Collectors.toList()));
	}

	public int size() {
		return members.size();
	}
}
