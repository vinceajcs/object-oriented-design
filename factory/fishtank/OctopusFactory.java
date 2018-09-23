package hw5;

public class OctopusFactory extends FishFactory {
    public Fish create() {
        FishBehavior fb = new BottomFeedingBehavior();
        return new Fish(new Octopus(), fb);
    }
}
