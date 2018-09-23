package hw5;

public class BottomFeedingBehavior extends FishBehavior {
    private double xSpeed = 0.3;
    private double ySpeed = 0.0;
    private double xDirectionChangePct = 0.1; // the fish changes horizontal direction 0.1% of the time
    private double yDirectionChangePct = 0.0; // the fish never changes vertical direction
    private double initialXPos = Aquarium.INIT_TANK_WD / 3;
    private double initialYPos = Aquarium.INIT_TANK_HT - 80;

    public double getXSpeed() {
        return xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
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
