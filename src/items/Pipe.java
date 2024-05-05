package items;

import javax.swing.ImageIcon;
import java.util.Objects;

public class Pipe extends Item {
	public Pipe(int x, int y) {

		super(x, y, 43, 65);		
		super.icoObjet = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/pipe.png")));
		super.imgObjet = this.icoObjet.getImage();
	}
}
