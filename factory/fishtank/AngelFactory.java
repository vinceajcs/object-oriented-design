package hw5;

public class AngelFactory extends FishFactory {
    public Fish create() {
        FishBehavior fb = new NormalBehavior();
        return new Fish(new AngelFish(), fb);
    }
}
