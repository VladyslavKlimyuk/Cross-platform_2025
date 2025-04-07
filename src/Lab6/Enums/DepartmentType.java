package Lab6.Enums;

public enum DepartmentType {
    FOOD("Продукти харчування"),
    CLOTHES("Одяг та взуття"),
    ELECTRONICS("Електроніка та побутова техніка"),
    HOUSEHOLD("Товари для дому"),
    BOOKS("Книги та канцтовари"),
    PHARMACY("Аптека"),
    TOYS("Іграшки"),
    BEAUTY("Косметика та парфумерія"),
    SPORT("Спортивні товари"),
    OTHER("Інше");

    private final String displayName;

    DepartmentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}