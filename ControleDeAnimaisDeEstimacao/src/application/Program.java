package application;

import java.util.Arrays;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import enumerate.Especie;
import enumerate.Genero;
import enumerate.Intervalo;
import enumerate.Porte;
import models.Animal;
import models.Peso;
import models.Remedio;
import models.Saude;
import models.Usuario;
import models.Vacina;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Usuario usuario = new Usuario("12345", "Sarah");
		Peso peso = new Peso(3.0, sdf.parse("09/09/2020"));
		List<Peso> pesos = Arrays.asList(peso);
		Vacina vacina = new Vacina(1234532, "Lab", true, "Vacina", sdf.parse("08/07/2020"), 3, Intervalo.ANOS);
		Vacina vacina1 = new Vacina(1234532, "Lab", true, "Vacina2", sdf.parse("08/07/2020"), 5, Intervalo.ANOS);
		Remedio remedio = new Remedio(1.0, 2, "15:00", "Remedio", sdf.parse("22/08/2022"), 1, Intervalo.DIAS);
		
		List<Vacina> vacinas = Arrays.asList(vacina, vacina1);
		List<Remedio> remedios = Arrays.asList(remedio);
		Saude saude = new Saude(vacinas, remedios);
		Animal animal = new Animal("156", "Lola", Especie.CANINO, "SRD", Genero.FEMININO, 3, Porte.MEDIO, pesos, saude);
		
		System.out.println(animal);

	}

}
