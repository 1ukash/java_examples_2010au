package ru.spbstu.telematics.stud.concurency;

public class Buyer implements Runnable {
	private Bank bank;
	private boolean success;

	public Buyer(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			success = bank.buy(55);
		}
	}

	public boolean isSuccess() {
		return success;
	}
	
	

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		Buyer first = new Buyer(bank);
		Buyer second = new Buyer(bank);
		new Thread(first, "One").start();
		new Thread(second, "Two").start();
		while (true) {
			Bank b = new Bank();
			first.setBank(b);
			second.setBank(b);
			if (first.isSuccess() && second.isSuccess()) {
				System.err.println("Oops");
			}
		}
	}

}
