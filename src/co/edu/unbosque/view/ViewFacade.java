package co.edu.unbosque.view;

public class ViewFacade {

	private Window win;

	public ViewFacade() {
		win = new Window();
	}

	public Window getWin() {
		return win;
	}

	public void setWin(Window win) {
		this.win = win;
	}

}
