package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Menu {
    JAPANESE_MENU(MenuCategory.JAPANESE, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_MENU(MenuCategory.KOREAN, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_MENU(MenuCategory.CHINESE, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_MENU(MenuCategory.ASIAN, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN_MENU(MenuCategory.WESTERN, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")),
    ;
    private final MenuCategory menuCategory;
    private final List<String> menuNames;

    Menu(MenuCategory menuCategory, List<String> menuNames) {
        this.menuCategory = menuCategory;
        this.menuNames = menuNames;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

    public static boolean isMenu(String name) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.menuNames.contains(name));
    }

    public static List<String> findMenuNamesByCategory(MenuCategory menuCategory) {
        Menu menu =  Arrays.stream(Menu.values())
                .filter(m -> m.menuCategory.equals(menuCategory))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 카테고리의 메뉴 목록이 존재하지 않습니다."));

        return menu.getMenuNames();
    }

    public static Menu findMenuByMenuName(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(m -> m.getMenuNames().contains(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 메뉴가 존재하지 않습니다."));
    }
}
