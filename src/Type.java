public enum Type {
    WORK ("Рабочая"),
    PERSONAL("Личная");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Тип задачи: " + getType();
    }
}
