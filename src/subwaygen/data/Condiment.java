package subwaygen.data;

import java.util.List;

public abstract class Condiment<T> {
    String name;
    List<Allergy> allergies;

    public Condiment() {

    }

    public T setName(String name) {
        this.name = name;
        return (T) this;
    }

    public abstract int getCalories();
}
