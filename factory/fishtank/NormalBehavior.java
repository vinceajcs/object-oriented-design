package fishtank;


public class NormalBehavior extends FishBehavior{
    private double xSpeed = 2.0;
    private double ySpeed = 1.0;
    private double xDirectionChangePct = 0.1; // the fish changes horizontal direction 0.1% of the time
    private double yDirectionChangePct = 0.5; // the fish changes vertical direction 0.5% of the time
    private double initialXPos = Aquarium.INIT_TANK_WD / 3;
    private double initialYPos = Aquarium.INIT_TANK_HT / 3;

    public double getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public double xDirectionChangePct() {
        return xDirectionChangePct;
    }

    public double yDirectionChangePct() {
        return yDirectionChangePct;
    }

    public double initialXPos() {
        return initialXPos;
    }

    public double initialYPos() {
        return initialYPos;
    }

}
