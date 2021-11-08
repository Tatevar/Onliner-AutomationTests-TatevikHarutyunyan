package PageObject;


public enum HomeMenuItemEnum {
    ELECTRONICS("Электроника"),
    COMPUTERS("Компьютеры и сети"),
    APPLIANCES("Бытовая техника"),
    CONSTRACTIONSANDREPAIR("Стройка и ремонт"),
    HOUSE("Дом и сад"),
    CAR("Авто и мото"),
    BEUTYANDSPORT("Красота и спорт"),
    WORKANDOFFICE("Работа и офис"),
    MOMMIESANDBABIES("Детям и мамам"),
    FOOD("Еда");

    String MenuText;

    HomeMenuItemEnum(String MenuText) {
        this.MenuText = MenuText;
    }

    public String getMenuText() {
        return MenuText;
    }
}
