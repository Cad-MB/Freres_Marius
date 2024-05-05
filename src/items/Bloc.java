package items;

import javax.swing.ImageIcon;
import java.util.Objects;

public class Bloc extends Item {
	public Bloc(int x, int y) {
		super(x, y, 30, 30);		
		super.icoObjet = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/bloc.png")));
		super.imgObjet = this.icoObjet.getImage();
	}
}
