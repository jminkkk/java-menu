package menu.util.validator;

import menu.domain.Menu;

public class MenuValidator {
    public static void validate(String[] hateMenus) {
        validateMenuCount(hateMenus.length);

        for (String hateMenu : hateMenus) {
            validateMenu(hateMenu);
        }
    }

    private static void validateMenuCount(int count) {
        if (count > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 코치 당 2개까지만 가능합니다.");
        }
    }

    private static void validateMenu(String name) {
        if (!Menu.isMenu(name)) {
            throw new IllegalArgumentException("[ERROR] 올바르지 못한 메뉴 이름입니다.");
        }
    }
}
