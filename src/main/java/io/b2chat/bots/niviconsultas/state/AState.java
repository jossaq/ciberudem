package io.b2chat.bots.niviconsultas.state;

public abstract class AState implements IState {
	
	private static final long serialVersionUID = 839441584524239539L;
	
	private int step;
	
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
}
