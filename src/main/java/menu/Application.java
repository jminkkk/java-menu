package menu;

import menu.controller.CoachController;
import menu.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(new CoachController());
        mainController.run();
    }
}
