package visualnovel.scenes;

public class Choice {
    private String text;
    private Scene scene;

    public Choice(String text, Scene scene) {
        this.text = text;
        this.scene = scene;
    }

    public String getText() {
        return text;
    }

    public Scene getNextScene() {
        return scene;
    }

    public static Choice getDefault(Scene scene) {
        return new Choice("", scene);
    }
}
