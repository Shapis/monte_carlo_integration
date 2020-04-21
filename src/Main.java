import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		int dim, r, dentro;
		double lowerBound, upperBound,volume, numberOfPoints,distance;
		ArrayList<Double> returnList = new ArrayList<>();
		
		dentro = 0;
		
		dim = 10;
		r = 1;
		
		numberOfPoints = 1E2;
		volume = Math.pow(r*2,dim);
		
		double k = 0;
		while (numberOfPoints <= 1E6){
			dentro = 0;
		for (int i = 0 ; i < numberOfPoints ; i ++) {
			double dimCheck = 0;
			for (int j = 0 ; j < dim ; j++) {
				dimCheck += Math.pow((Math.random()*2-1)*r,2);
			}
			
			double check = 	Math.sqrt(dimCheck);
			
			
				if (check <= r) {
					dentro++;
				}
				
				
			
		}
		double vD = Math.pow(r,dim)*Math.pow(Math.PI,dim/2)/factorial(dim/2);
		double result = ((volume / numberOfPoints))*dentro;
		
		System.out.println(vD + "\t\t\t" + result);
		
		returnList.add(Math.log(numberOfPoints));
		returnList.add(Math.log(Math.abs(vD-result)));
		k++;
		numberOfPoints = numberOfPoints *1.01;
		
		}
		
		
		
		
		salvarArquivo(returnList, "F:\\dataoutput\\meuserros.txt");
		
		
		

}
	
	static double factorial(double n) {
		double fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	
	private static int salvarArquivo(ArrayList<Double> meusPontos, String localArquivoSaida) {

		String stringTemp = "Inicialização de variável.";
		String stringFinal = "Inicialização de variável.";
		StringBuilder stringBuilder = new StringBuilder();
		int k = 0;

		for (Double i: meusPontos){
		stringTemp = i.toString() + "\t";
		stringBuilder.append(stringTemp);
		k++;

		if (k==2) {
			stringBuilder.append(System.getProperty("line.separator"));
			k = 0;
		}

		}


		stringFinal = stringBuilder.toString();
		//System.out.println(stringFinal);



		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					localArquivoSaida));

			writer.write(stringFinal);

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("O arquivo não foi salvo!");
		}

		return 0;

	}

}
