package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalComponent {

    private SelenideElement resultTable = $("#resultBody");
    private SelenideElement closeButton = $("#closeModal");

    public void checkState(Condition condition) {
        $("#resultModal").shouldBe(condition);
    }

    public void checkField(String key, String value) {
        resultTable.$(byText(key))
                .parent()
                .shouldHave(text(value));
    }

    public void closeTable() {
        closeButton.click();
    }
}
