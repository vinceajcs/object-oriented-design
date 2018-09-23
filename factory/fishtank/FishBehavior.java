package hw5;

public abstract class FishBehavior {
    public abstract double getXSpeed();
    public abstract double getYSpeed();
    public abstract void setXSpeed(double xSpeed);
    public abstract void setYSpeed(double ySpeed);
    public abstract double xDirectionChangePct();
    public abstract double yDirectionChangePct();
    public abstract double initialXPos();
    public abstract double initialYPos();
}
