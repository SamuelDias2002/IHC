
public class p1 {

	public static void main(String[] args) {
		FileIN f = new FileIN("https://www.di.ubi.pt/~jpaulo/ensino/IHC/praticas/nutrition.txt");
		f.open();
		String[] lines = f.readAll();
		f.close();

		
		for (int i=1 ; i < lines.length; i++) {
			String line = lines[i];
			//System.out.printf("%3d ----> %s\n" ,i ,line);
			String [] partes = line.split("[|]");
			
			int peso = Integer.parseInt(partes[3]);
			int kcal = Integer.parseInt(partes[5]);
			float prot= Float.parseFloat(partes[6]);
			int kcal100 =  100*kcal/peso;
			
			
			System.out.printf("%-40s      %3d       %5d           %6.2f        %d\n",partes [0] ,peso, kcal, prot, kcal100);
			
			

			
			
			
		}

	}

}
