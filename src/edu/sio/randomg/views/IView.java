package edu.sio.randomg.views;

public interface IView {

	public void display(String message);

	public int inputInt();

	public int inputIntMessage(String message);

	public int inputIntMessage(String message, int min);

	public int inputIntMessage(String message, int min, int max);

}
