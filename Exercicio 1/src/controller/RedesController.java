package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ip(String so) {
		String WinIp = "ipconfig /all";
		String LinIp = "ip addr show";
		if (so.startsWith("W")) {
			try {
				Process proc = Runtime.getRuntime().exec(WinIp);
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffinho = new BufferedReader(leitor);
				String linha = buffinho.readLine();
				while (linha != null) {
					if (linha.contains("IPv4")) {
						System.out.println(linha.toString());
					} else if (linha.contains("Descri")) {
						System.out.println(linha.toString());
					}
					linha = buffinho.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (so.startsWith("L")) {
			try {
				Process proc = Runtime.getRuntime().exec(LinIp);
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffinho = new BufferedReader(leitor);
				String linha = buffinho.readLine();
				while (linha != null) {
					if(linha.contains("scope")){
					System.out.println(linha);				
					}
					linha = buffinho.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}