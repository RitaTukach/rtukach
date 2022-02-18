package Homework3;

public enum Models {

    MERCEDES ("Mercedes"),
    OPEL("Opel"),
    BMW("BMW"),
    AUDI("Audi"),
    NISSAN("Nissan")
    ;
    private final String models;

    Models(String models) {
        this.models = models;
    }

    public String getModels() {
        return models;
    }
}
