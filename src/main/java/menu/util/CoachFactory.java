package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;

public class CoachFactory {
    public static Coach generate(String name) {
        return new Coach(name);
    }

    public static List<Coach> generate(String[] names) {
        return Arrays.stream(names)
                .map(Coach::new)
                .collect(Collectors.toList());
    }
}
