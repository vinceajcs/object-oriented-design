package fishtank;

import javafx.scene.image.*;

public class Fish {
    private ImageView view = new ImageView();  // holds the image and current position
		private FishType ft;
		private FishBehavior fb;

		public Fish(FishType fishType, FishBehavior fishBehavior) {
			this.ft = fishType;
			this.fb = fishBehavior;
			view.setX(fb.initialXPos()); //initial fish location
			view.setY(fb.initialYPos());
		}

		public void move(double tankheight, double tankwidth) {
			Image image = getImage();
			view.setImage(image);
			double x = moveXY(view.getX(), fb.getXSpeed(), fb.xDirectionChangePct());
			double y = moveXY(view.getY(), fb.getYSpeed(), fb.yDirectionChangePct());
			if (legalMove(x, image.getWidth(), tankwidth)) {
				view.setX(x);
			} else {
				changeXdirection();
				if (legalMove(y, image.getHeight(), tankheight))
					view.setY(y);
				else
					hangeYdirection();
			}
		}

		public ImageView getView() {
			return view;
		}

		private Image getImage() {
			return movesRight() ? ft.rightImage() : ft.leftImage();
		}

		private double moveXY(double pos, double speed, double pct) {
			if (changesDirection(pct))
				return -1;
			else
				return pos + speed;
		}

		private boolean legalMove(double pos, double size, double limit) {
			return (pos >=0) && (pos + size <= limit);
		}

		private void changeXdirection() {
			fb.setXSpeed(-fb.getXSpeed());
		}

		private void changeYdirection() {
			fb.setYSpeed(-fb.getYSpeed());
		}
		private boolean movesRight() {
			return fb.getXSpeed() >= 0;
		}

		private boolean changesDirection(double frequency) {
			return Math.random() * 100 < frequency;
		}

}
