package main;

import java.text.DecimalFormat;

public class Calculator {
	
	static int  listas=0, nnotas=0;
	static char[] cadena = new char[5];
	static double[] notas = new double[30];
	static double[] porcentajes = new double[30];
	static DecimalFormat df = new DecimalFormat("0.00");
	
	public static void operar(String contenido) {
		// TODO Auto-generated method stub
		int ntab=0, flag=0, pos=0;
		char caracter;
		
		////////////////////////////////////////////////lectura de contenido/////////////////////////////////////////7
		
		for (int i = 0; i < contenido.length(); i++) {
			caracter = contenido.charAt(i);
			//System.out.print(caracter);
			
			if (caracter == 10){
				nnotas++;
				ntab = 0;
			}else if(caracter == 9){
				ntab++;
			}
			
			if(flag == 1){
				cadena[pos-1] = caracter;
				
			}
			
			if(ntab == 2){
				flag = 1;
				pos++;
			}else if(ntab == 3){
				flag = 0;
				pos = 0;
				if(cadena[0] == 32){
					notas[nnotas] = -1;
				}else{
					//notas[nnotas] = atof(cadena);
					String n1 = "";
					for (int j = 0; j < cadena.length; j++) {
						if(cadena[j]==' ' || cadena[j]==9 || cadena[j]==10) {
						j = cadena.length;
						}else {
							n1 = n1 + cadena[j];
						}
					}
					//notas[nnotas] = Double.parseDouble(String.valueOf(cadena));
					notas[nnotas] = Double.parseDouble(n1);
				}
			}else if(ntab == 4){
				flag = 1;
				pos++;
			}else if(ntab == 5){
				flag = 0;
				pos = 0;
				//porcentajes[nnotas] = atoi(cadena);
				String t = "";
				for (int k = 0; k < cadena.length; k++) {
					if(cadena[k]==' ' || cadena[k]==9 || cadena[k]==10) {
					k = cadena.length;
					}else {
						t = t + cadena[k];
					}
				}
				
				//System.out.println(t + " " + nnotas);
				porcentajes[nnotas] = Double.parseDouble(t);
			}
			
			
		}
		
		/////////////////////////////////////////imprimir tabla///////////////////////////////////
		
		
	}
	
	public static String mostrarInfo() {
		// TODO Auto-generated method stub
		String t2 = "<html>";
		for(int l=0; l <= nnotas; l++){
			if(notas[l]!=-1){
			listas++;
			//System.out.printf("\n\nNota %d:\t\t%.2f\nPorcentaje:\t%d\n",l+1,notas[l],porcentajes[l]);
			//System.out.println("\n\nNota " + (l+1) + ":\t\t" + notas[l] + "\nPorcentaje:\t" + porcentajes[l] + "\n");
			t2 = t2 + "Nota " + (l+1) + ":&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
			+ notas[l] + "<br>Porcentaje:&nbsp;&nbsp;&nbsp;&nbsp;" + porcentajes[l] + "<br><br>";
			//se usa etiquetas html para el JLabel, así...
			//tab: &nbsp;&nbsp;&nbsp;&nbsp;
			//salto de linea: <br>
			}
			
		}
		
		t2 = t2 + "</html>";
		return t2;
		
		
	}
	
	
	
	
	
	public static String mostrarRespuesta(){
		int i =0;
		double mult = 0, sum=0, sump=0, porct=0, nota=0;
		String t3 = "<html>";
		
		for (i=0;i<=nnotas;i++){
			porct = porct+porcentajes[i];
			if(notas[i]!=-1){
				sump = sump+porcentajes[i];
			}
			if(porct > 100){
				//System.out.printf("\n\nPORCENTAJES NO DEBEN EXCEDER EL 100%%\n\n");
				return "PORCENTAJES NO DEBEN EXCEDER EL 100%";
			}
		}
		
		for (i=0;i<=nnotas;i++){
			if(notas[i]!=-1){
				mult = notas[i]*(porcentajes[i]*0.01);
				sum = sum+mult;
			}
		}
		
		//System.out.printf("\n\nDefinitiva actual:\t%f\n",sum);
		t3 = t3 + "Definitiva actual: &nbsp;&nbsp;&nbsp;&nbsp; " + df.format(sum);
		
		
		if(sump==100){
			//System.out.printf("\nMAXIMO DE NOTAS INGRESADO\n");
			t3 = t3 + "<br>MÁXIMO NÚMERO DE NOTAS INGRESADO<br>";
			return t3 + "</html>";
		}
		sump = 100-sump;
		nota = (3.0-sum)/(sump*0.01);
		//System.out.printf("\nDebes sacar %f en el %f%% para poder ganar.\n",nota,sump);
		t3 = t3 + "<br>Debes sacar " + df.format(nota) + " en el " + df.format(sump) + "% para poder ganar.";
		
		//System.out.println("<html>" + df.format(2.222000000000) + "</html>");
		//System.out.println(sum);
		return t3 + "</html>";
		
	}
	
	public static void reset() {
		// TODO Auto-generated method stub
		listas = 0;
		nnotas = 0;
		
		for (int i = 0; i < cadena.length; i++) {
			cadena[i]=0;
		}
		for (int i = 0; i < notas.length; i++) {
			notas[i]=0.0;
		}
		for (int i = 0; i < porcentajes.length; i++) {
			porcentajes[i]=0.0;
		}
		
	}
	
}






