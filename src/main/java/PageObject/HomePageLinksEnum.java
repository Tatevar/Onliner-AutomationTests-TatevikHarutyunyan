package PageObject;

import org.openqa.selenium.By;

public enum HomePageLinksEnum {
    ELECTRONICS("Электроника");



    String link;

    HomePageLinksEnum(String link) {
        this.link = link;
    }

    public String getLinkText() {
        return link;
    }
}
