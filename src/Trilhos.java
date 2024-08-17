public class Trilhos {

	private int[][] vetorTrilhos;
	private int[] direcoes;
	private int numDirecoes;
	private int linhas;
	private int colunas;
	private int somaTotal = 0;
	private int[] vetorDirecoes;

	public Trilhos(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		vetorTrilhos = new int[linhas][colunas];
		direcoes = new int [1];
	}

	public void adicionarValores(int linha, int coluna, int valor) {
		vetorTrilhos[linha][coluna] = valor;
	}

	public int getValores(int linha, int coluna) {
		int t = vetorTrilhos[linha][coluna];
		return t;
	}

	public boolean isInside(int linha, int coluna) {
		return (getValores(linha, coluna) < colunas && getValores(linha, coluna) < linhas);
	}

	public void turnUsado(int linha, int coluna) {
		vetorTrilhos[linha][coluna] = 36274;
	}

	public boolean hasBeenUsed(int linha, int coluna) {

		return vetorTrilhos[linha][coluna] == 36274;
	}

	public void addVal(int l, int c) {
		somaTotal = somaTotal + vetorTrilhos[l][c];
	}
	public int getValorTotal() {
		return somaTotal;
	}
	private void aumentarTamanhoVetor() {
		int[]tmp = new int[direcoes.length + 1];
		
		for(int  i = 0; i < direcoes.length ; i++) {
			tmp[i] = direcoes[i];
		}
		direcoes = tmp;
	}
	public int getNumDirecoes() {
		return numDirecoes;
	}
	public int getValorDirecoes(int i) {
		return direcoes[i];
	}

	public void acharCaminho() {
		int posAtual = vetorTrilhos[0][0];
		 //turnUsado(0, 0);
		int t = 0;
		addVal(0, 0);
		int c = 0;
		 numDirecoes = 0;
		boolean hasNext = false;
		int l = 0;

		
		while (c < colunas ) {

			if (c < colunas-1 && vetorTrilhos[l][c + 1] == posAtual && hasBeenUsed(l, c+1) == false) {

				turnUsado(l, c);
				posAtual = vetorTrilhos[l][c + 1];
				addVal(l, c + 1);
				c = c + 1;
				direcoes[numDirecoes] = 1;
				numDirecoes++;
				aumentarTamanhoVetor();
				

			} else if (l < linhas-1 && vetorTrilhos[l + 1][c] == posAtual && hasBeenUsed( l+1, c) == false ) {

				turnUsado(l, c);
				posAtual = vetorTrilhos[l + 1][c];
				addVal(l + 1, c);
				l = l + 1;
				direcoes[numDirecoes] = 2;
				numDirecoes++;
				aumentarTamanhoVetor();
				
			} else if (c > 0 && vetorTrilhos[l][c-1] == posAtual && hasBeenUsed(l, c-1) == false) {

				turnUsado(l, c);
				posAtual = vetorTrilhos[l][c-1];
				addVal(l, c-1);
				c = c -1;
				direcoes[numDirecoes] = 3;
				numDirecoes++;
				aumentarTamanhoVetor();
				
			} else if (l > 0 && vetorTrilhos[l - 1][c] == posAtual && hasBeenUsed(l-1, c) == false) {

				turnUsado(l, c);
				posAtual = vetorTrilhos[l - 1][c];
				addVal(l - 1, c);
				l = l - 1;
				direcoes[numDirecoes] = 4;
				numDirecoes++;
				aumentarTamanhoVetor();
				
			}else {
				l = linhas; c = colunas;
				//System.out.println(getValorTotal());
			}

		}

		

	}

	
}
