import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		
		int linhas = in.nextInt();
		int colunas = in.nextInt();
		in.nextLine();
		Trilhos trilho = new Trilhos(linhas, colunas);
		
		
		
		for(int  i = 0; i < linhas; i++) {
			for(int z = 0; z < colunas; z++) {
				int num = in.nextInt();
				
				trilho.adicionarValores(i, z, num);
			}
			in.nextLine();
		}
		
		trilho.acharCaminho();
		for(int i = 0; i < trilho.getNumDirecoes(); i++) {
			if(trilho.getValorDirecoes(i) == 1) {
			System.out.print("D");
			}
			else if(trilho.getValorDirecoes(i) == 2) {
				System.out.print("B");
				}
			else if(trilho.getValorDirecoes(i) == 3) {
				System.out.print("E");
				}
			else if(trilho.getValorDirecoes(i) == 4) {
				System.out.print("C");
				}
			
		}
		System.out.println("");
		System.out.println(trilho.getValorTotal());
		
	}

}
