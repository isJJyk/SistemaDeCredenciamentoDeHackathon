package br.com.senaimg.portal_hackathon.controllers;

import br.com.senaimg.portal_hackathon.entidades.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CredenciamentoController {
    @PostMapping("/hackathon/processar")
    public List<Participante> processos() {


        String inscrito = "C:\\inscricao\\inscri.txt";


        ArrayList<Participante> participantes = new ArrayList<>();

        ArrayList<String> erro = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inscrito))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] vectin = null;

                Integer idade = null;
                vectin = line.split(";");

                try {

                    idade = Integer.parseInt(vectin[2]);

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
                    } else {
                        erro.add(line);
                    }
                } catch (Exception e) {
                    erro.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        String pathDev = "C:\\relatorios\\aprovados_hackathon.txt";
        String pathErro = "C:\\relatorios\\pendencias_inscricao.txt";

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

        int quantAprovados = participantes.size();
        int quantRejeitados = erro.size();


        String status;
        if (quantAprovados > 0 && quantRejeitados == 0) {
            status = "Todos Aprovados";
        } else if (quantAprovados > 0 && quantRejeitados > 0) {
            status = "Pendências";
        } else if (quantAprovados == 0 && quantRejeitados > 0) {
            status = "Todos Rejeitados";
        } else {
            status = "Nenhum Arquivo Encontrado";
        }


        RelatorioProcessamento relatorio = new RelatorioProcessamento(quantAprovados,quantRejeitados,status);
        participantes.add(relatorio);

        //Dúvida: Fazer List<Participante> Retornar dados do objeto RelatorioProcessamento

        return participantes;

    }
}
