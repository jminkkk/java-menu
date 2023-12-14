package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateMenus;

    public Coach(String name) {
        this.name = name;
        this.hateMenus = new ArrayList<>();
    }

    public List<String> getHateMenus() {
        return hateMenus;
    }

    public boolean hateMenu(String name) {
        return this.hateMenus.contains(name);
    }

    public String getName() {
        return name;
    }

    public void addHateMenu(String menu) {
        hateMenus.add(menu);
    }

    public void addHateMenus(List<String> menus) {
        hateMenus.addAll(menus);
    }
}
