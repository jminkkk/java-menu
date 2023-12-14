package menu.domain;

import java.util.Arrays;

public enum MenuCategory {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(3, "아시안"),
    WESTERN(4, "양식")
    ;
    private final int categoryNum;
    private final String name;

    MenuCategory(int categoryNum, String name) {
        this.categoryNum = categoryNum;
        this.name = name;
    }

    public int getCategoryNum() {
        return categoryNum;
    }

    public static MenuCategory findByCategoryNum(int num) {
        return Arrays.stream(MenuCategory.values())
                .filter(menuCategory -> menuCategory.getCategoryNum() == num)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("숫자와 해당하는 카테고리가 없습니다."));
    }

    public static MenuCategory findMenuCategoryByMenu(String menu) {
        Menu findOne = Menu.findMenuByMenuName(menu);
        return findOne.getMenuCategory();
    }
}
