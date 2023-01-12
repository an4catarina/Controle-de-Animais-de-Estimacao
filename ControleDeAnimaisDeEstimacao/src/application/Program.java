package application;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import enumerate.Especie;
import enumerate.Genero;
import enumerate.Intervalo;
import enumerate.Porte;
import models.Animal;
import models.Remedio;
import models.Saude;
import models.Usuario;
import models.Vacina;

public class Program {

	public static void main(String[] args) throws ParseException {
		ArrayList<Vacina> vacinas = new ArrayList<>();
		ArrayList<Remedio> remedios = new ArrayList<>();
		ArrayList<Animal> animais = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Usuario usuario = new Usuario("Sarah", null);
		Vacina vacina = new Vacina(1234532, "Lab", true, "Vacina", sdf.parse("08/07/2020"), 3, Intervalo.ANOS);
		Vacina vacina1 = new Vacina(1234532, "Lab", true, "Vacina2", sdf.parse("08/07/2020"), 5, Intervalo.ANOS);
		Remedio remedio = new Remedio(1.0, 2, "15:00", "Remedio", sdf.parse("22/08/2022"), 1, Intervalo.DIAS);
		

		vacinas.add(vacina);
		vacinas.add(vacina1);
		remedios.add(remedio);
		Saude saude = new Saude(vacinas, remedios);
		Animal animal = new Animal("Lola", Especie.CANINO, "SRD", Genero.FEMININO, 3, Porte.MEDIO, saude);
		animais.add(animal);
		

		usuario.setAnimais(animais);
		System.out.println(usuario);
	}
}
