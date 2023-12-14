package menu.domain;

public enum MenuCategory {
    JAPANESE("일식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식")
    ;
    private final String name;

    MenuCategory(String name) {
        this.name = name;
    }
}
