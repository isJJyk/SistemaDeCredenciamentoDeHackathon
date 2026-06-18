package sistemaDeCredenciamentoDeHackathon.project;

import sistemaDeCredenciamentoDeHackathon.entidades.Desenvolvedor;
import sistemaDeCredenciamentoDeHackathon.entidades.Designer;
import sistemaDeCredenciamentoDeHackathon.entidades.Participante;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project {
    static void main(String[] args) {

        String inscrito = "C:\\Users\\Aluno_Tarde\\inscrição\\inscri.txt";
        ArrayList<Participante> participantes = new ArrayList<>();
        ArrayList<String> erro= new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inscrito))){

            String line;
            while ((line = br.readLine()) != null) {
                String[] vectin= null;

                Integer idade = null;
                vectin = line.split(";");

                try {
                    idade= Integer.parseInt(vectin[2]);

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    erro.add(line);
                }

                try {
                    if (vectin[0].equalsIgnoreCase("DEV")) {

                        Desenvolvedor desenvolvedor = new Desenvolvedor(vectin[1], idade, vectin[3], vectin[4]);
                        participantes.add(desenvolvedor);
                    } else if (vectin[0].equalsIgnoreCase("DESIGN")) {

                        Designer designer = new Designer(vectin[1], idade, vectin[3], vectin[4]);
                        participantes.add(designer);
                    }
                    else {
                        erro.add(line);
                    }
                } catch (Exception e) {
                    erro.add(line);
                }
            }
        }catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o caminho dos arquivos: ");
        String path = sc.nextLine();
        String pathDev = path + "\\aprovados_hackathon.txt";
        String pathErro = path + "\\pendencias_inscricao.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDev))) {
            for (Participante line : participantes) {
                bw.write(line.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo.");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathErro))) {
            for (String line : erro) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo.");
        }
    }
}