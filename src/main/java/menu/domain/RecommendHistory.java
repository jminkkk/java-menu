package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendHistory {
    private final Coach coach;
    private final List<String> menus;

    public RecommendHistory(Coach coach) {
        this.coach = coach;
        this.menus = new ArrayList<>();
    }

    public Coach getCoach() {
        return coach;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void addRecommendMenu(String menu) {
        menus.add(menu);
    }

    public boolean canEat(String menu) {
        return !menus.contains(menu)
                && !coach.hateMenu(menu);
    }

    public int countOf(MenuCategory menuCategory) {
        return (int) menus.stream()
                .filter(menu -> MenuCategory.findMenuCategoryByMenu(menu) == menuCategory)
                .count();
    }

    @Override
    public String toString() {
        String joinMenuNames = String.join(" | ", menus);
        return "[ " + coach.getName() + " | "
                 + joinMenuNames +
                " ]";
    }

    public String getCategories() {
        List<String> categories = menus.stream()
                .map(i -> MenuCategory.findMenuCategoryByMenu(i).getName())
                .collect(Collectors.toList());

        String joinMenuNames = String.join(" | ", categories);
        return "[ " + "카테고리" + " | "
                + joinMenuNames +
                " ]";
    }
}
