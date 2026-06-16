package practice;

public class Raccoon extends Animal {
    public Raccoon() {
        super("Raccoon");
    }

    @Override
    public void makeSound() {
        System.out.println("skrskrskr");
    }
}
