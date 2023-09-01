import java.util.*; 

public class Salario {
    public static void main(String arg[])	
	{
	    Scanner sc=new Scanner(System.in);
	    double salario_por_hora, salario_total;
	    int horas_trabajadas;
	    System.out.println("Ingrese el total de horas semanales trabajadas:");
		horas_trabajadas = sc.nextInt();
		
	    System.out.println("Ingrese el pago por hora");
        salario_por_hora = sc.nextDouble();
		
	    
	    if(horas_trabajadas > 40){
	       salario_total = salario_por_hora * horas_trabajadas * 1.3;
	    } else {
	        salario_total = salario_por_hora * horas_trabajadas;
	    }
	     System.out.println("Net Salary is="+salario_total);
	    
	}
}
