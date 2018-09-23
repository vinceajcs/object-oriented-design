package fishtank;

public class DolphinFactory extends FishFactory {
    public Fish create() {
        FishBehavior fb = new NormalBehavior();
        return new Fish(new Dolphin(), fb);
    }
}
