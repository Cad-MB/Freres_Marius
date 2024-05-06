package items;

import javax.swing.ImageIcon;
import java.util.Objects;

public class Platforms extends Item {

    public Platforms(int x, int y, int width, int height, String imagePath) {
        super(x, y, width, height);
        this.icoObject = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath)));
        this.imgObjet = this.icoObject.getImage();
    }

    public static Platforms createBloc(int x, int y) {
        return new Platforms(x, y, 31, 30, "/images/bloc.png");
    }

    public static Platforms createPipe(int x, int y) {
        return new Platforms(x, y, 64, 65, "/images/pipe.png");
    }
}
