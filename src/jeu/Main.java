package jeu;

import javax.swing.JFrame;

public class Main {

	public static Level1Scene level1Scene;

	public static void main(String[] args) {

		JFrame window = new JFrame("Frerers Marius");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(700, 360);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setAlwaysOnTop(true);

		level1Scene = new Level1Scene();

		window.setContentPane(level1Scene);
		window.setVisible(true);
	}
}