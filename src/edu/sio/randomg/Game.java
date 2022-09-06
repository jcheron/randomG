package edu.sio.randomg;

import edu.sio.randomg.models.Partie;

public class Game {
	public static void main(String[] args) {
		Partie p = Partie.initialize();
		do {
			p.propose();
		} while (!p.isTerminated());
	}
}
