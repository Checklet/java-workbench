package visualnovel.scenes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scene {
    private static final String LOCATION = "/res/visualnovel/scenes/";
    private String path;
    private Decision decision;

    public Scene(String path) {
        this.path = LOCATION + path + ".txt";
    }

    public Scene addChoice(Choice choice) {
        this.decision.add(choice);
        return this;
    }

    public void print() {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            System.out.println();
            read.lines().forEach(System.out::println);
            System.out.println();
        } catch (FileNotFoundException e) {
            System.err.printf("File %s not found\n", path);
        } catch (IOException e) {
            System.err.printf("Error reading file %s\n", path);
        }
    }
}
