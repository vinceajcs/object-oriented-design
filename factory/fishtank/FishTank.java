package fishtank;

import java.util.*;
import javafx.scene.layout.Pane;

public class FishTank {
   List<Fish> fishes = new ArrayList<>();
   FishFactory[] factories;
   Pane p;
   boolean suspended = false;

   public FishTank(Pane p, FishFactory[] factories) {
      this.p = p;
      this.factories = factories;
   }

   public void addFish(int type) {
      FishFactory ff = factories[type-1];
      Fish f = ff.create();

      fishes.add(f);
      p.getChildren().add(f.getView());
   }

   public void startAnimation() {
      suspended = false;
   }

   public void stopAnimation() {
      suspended = true;
   }

   public void move(double height, double width) {
      if (!suspended) {
         for (Fish f : fishes)
            f.move(height, width);
      }
   }
}
