package edu.sio.randomg.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.sio.randomg.views.ConsoleView;
import edu.sio.randomg.views.IView;

public class Partie implements PropertyChangeListener {

	private boolean terminated;
	private int maxAttemptsNumber;

	private RandomNumberEngine engine;
	private IView view;

	public Partie(RandomNumberEngine engine, IView view, int maxAttempsNumber) {
		this.engine = engine;
		this.terminated = false;
		this.view = view;
		this.maxAttemptsNumber = maxAttempsNumber;
		engine.addPropertyChangeListener(this);
		engine.generate();
	}

	public void propose() {
		int value = view.inputIntMessage("Entrez une valeur", engine.getMin() - 1, engine.getMax() + 1);
		byte res = engine.compare(value);
		if (res == -1) {
			view.display("++");
		} else if (res == 1) {
			view.display("--");
		}
	}

	public boolean isTerminated() {
		return terminated;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch (evt.getPropertyName()) {
		case "success":
			if (evt.getNewValue().equals(true)) {
				terminated = true;
				view.display("Vous avez gagné !");
			}
			break;

		case "attempts":
			int number = (int) evt.getNewValue();
			view.display(evt.getNewValue() + " tentative(s)");
			if (number == maxAttemptsNumber) {
				terminated = true;
				view.display("Vous avez perdu...");
			}
			break;
		}
	}

	public static Partie initialize() {
		IView view = new ConsoleView();
		int min = view.inputIntMessage("Min ?");
		int max = view.inputIntMessage("Max ?", min);
		int attempts = view.inputIntMessage("Tentatives ?", 0, max - min);
		RandomNumberEngine engine = new RandomNumberEngine(min, max);
		return new Partie(engine, view, attempts);
	}

}
