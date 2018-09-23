package hw5;

public class ErraticBehavior extends FishBehavior {
    private double xSpeed = 5.0;
    private double ySpeed = 5.0;
    private double xDirectionChangePct = 5.0; // the fish changes horizontal direction 5% of the time
    private double yDirectionChangePct = 5.0; // the fish changes vertical direction 5% of the time
    private double initialXPos;
    private double initialYPos;

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
        double xPos = Aquarium.INIT_TANK_WD * Math.random();
        while (xPos >= Aquarium.INIT_TANK_WD - 150) { //ensure the fish does not get stuck outside the tank
            xPos = Aquarium.INIT_TANK_WD * Math.random();
        }
        initialXPos = xPos;
        return initialXPos;
    }

    public double initialYPos() {
        double yPos = Aquarium.INIT_TANK_HT * Math.random();
        while (yPos >= Aquarium.INIT_TANK_HT - 100) { //ensure the fish does not get stuck outside the tank
            yPos = Aquarium.INIT_TANK_HT * Math.random();
        }
        initialYPos = yPos;
        return initialYPos;
    }
}
