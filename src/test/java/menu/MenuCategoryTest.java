package menu;

import static org.assertj.core.api.Assertions.assertThat;

import menu.domain.MenuCategory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuCategoryTest {
    @ParameterizedTest
    @CsvSource(value = "KOREAN,2")
    void of(MenuCategory menuCategory, int num) {
        assertThat(MenuCategory.findByCategoryNum(num)).isEqualTo(menuCategory);
    }
}
