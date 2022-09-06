package edu.sio.randomg.views;

import java.util.Scanner;

public class ConsoleView implements IView {
	private Scanner sc;

	public ConsoleView() {
		sc = new Scanner(System.in);
	}

	@Override
	public void display(String message) {
		System.out.println(message);
	}

	@Override
	public int inputInt() {
		if (sc.hasNextInt()) {
			return sc.nextInt();
		}
		sc.next();
		return inputInt();
	}

	@Override
	public int inputIntMessage(String message) {
		display(message);
		return inputInt();
	}

	@Override
	public int inputIntMessage(String message, int min) {
		int resp;
		do {
			resp = inputIntMessage(message);
		} while (resp <= min);
		return resp;
	}

	@Override
	public int inputIntMessage(String message, int min, int max) {
		int resp;
		do {
			resp = inputIntMessage(message);
		} while (resp <= min || resp >= max);
		return resp;
	}
}
