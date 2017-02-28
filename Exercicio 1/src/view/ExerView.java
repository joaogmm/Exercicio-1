package view;


import controller.RedesController;

public class ExerView {

	public static void main(String[] args) {
		RedesController grr = new RedesController();
		String so = System.getProperty("os.name");
		grr.ip(so);
	}

}