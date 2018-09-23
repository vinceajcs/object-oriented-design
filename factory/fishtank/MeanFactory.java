package fishtank;

public class MeanFactory extends FishFactory {
    public Fish create() {
        FishBehavior fb = new ErraticBehavior();
        return new Fish(new MeanFish(), fb);
    }
}
