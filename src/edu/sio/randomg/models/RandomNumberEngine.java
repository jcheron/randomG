package edu.sio.randomg.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class RandomNumberEngine {

	private PropertyChangeSupport changes = new PropertyChangeSupport(this);

	private int attemptsNumber;
	private int value;
	private int min;
	private int max;

	public RandomNumberEngine(int min, int max) {
		this.min = min;
		this.max = max;
	}

	private void setSuccess(boolean value) {
		changes.firePropertyChange("success", false, value);
	}

	private void incAttemptsNumber() {
		changes.firePropertyChange("attempts", this.attemptsNumber, ++this.attemptsNumber);
	}

	public void generate() {
		Random r = new Random();
		value = r.nextInt(max - min) + min;
		System.out.println(value + " generated");
	}

	public byte compare(Integer value) {
		byte resp = 0;
		if (value < this.value) {
			resp = -1;
		} else if (value > this.value) {
			resp = 1;
		}
		incAttemptsNumber();
		setSuccess(resp == 0);
		return resp;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changes.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changes.removePropertyChangeListener(listener);
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
}
