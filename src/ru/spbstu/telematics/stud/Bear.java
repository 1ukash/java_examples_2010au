package ru.spbstu.telematics.stud;

import java.awt.Color;
import java.util.Random;

public abstract class Bear implements Creature {
	public void eat() {
		System.out.println("Niam-Niam");
	}

	abstract Color getColor();

	@Override
	public void live() {
		while (true) {

			sleep();
			try {
				hunt();
				eat();
			} catch (FailHuntException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				tryDie();// TODO Auto-generated method stub
			}
		}
	}

	private void hunt() throws FailHuntException {
		// TODO Auto-generated method stub
		int r = new Random().nextInt();
		if (r % 2 == 0) {
			throw new FailHuntException();
		}
	}

	private void tryDie() {
		// TODO Auto-generated method stub
		int y = new Random().nextInt();
		if (y % 13 == 0) {
			throw new DeadBearException();
		} else
			System.out.printf("%d\n", y);
	}

	private void sleep() {
		// TODO Auto-generated method stub

	}

}
