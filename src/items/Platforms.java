// Base class Platform in package items;
package items;

import javax.swing.ImageIcon;
import java.util.Objects;

public class Platforms extends Item {
    private String imagePath;

    // Constructor to initialize Platform with specific attributes
    public Platforms(int x, int y, int width, int height, String imagePath) {
        super(x, y, width, height);
        this.imagePath = imagePath;
        this.icoObjet = new ImageIcon(Objects.requireNonNull(getClass().getResource(this.imagePath)));
        this.imgObjet = this.icoObjet.getImage();
    }

    // Static factory method to create a Bloc
    public static Platforms createBloc(int x, int y) {
        return new Platforms(x, y, 31, 30, "/images/bloc.png");
    }

    // Static factory method to create a Pipe
    public static Platforms createPipe(int x, int y) {
        return new Platforms(x, y, 64, 65, "/images/pipe.png");
    }
}
