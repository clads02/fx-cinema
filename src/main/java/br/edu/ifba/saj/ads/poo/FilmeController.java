package br.edu.ifba.saj.ads.poo;

import java.io.IOException;
import java.util.Objects;

import br.edu.ifba.saj.ads.poo.data.Cinema;
import br.edu.ifba.saj.ads.poo.model.Filme;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FilmeController {

    @FXML
    private TextField txDuracao;

    @FXML
    private TextField txNome;

    @FXML
    void abrirCadastarSessao(ActionEvent event) {

        try {
            App.setRoot("Sessao");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void salvar(ActionEvent event) {
        if ((Objects.nonNull(txDuracao.getText()) 
            && !txDuracao.getText().isEmpty() 
            && !txDuracao.getText().isEmpty())
            &&
            (Objects.nonNull(txNome.getText()) 
            && !txNome.getText().isEmpty() 
            && !txNome.getText().isEmpty())) {
                Filme novoFilme = new Filme(txNome.getText(), Float.valueOf(txDuracao.getText()));
                Cinema.filmes.add(novoFilme);
                new Alert(AlertType.INFORMATION, String.format("Novo filme %s cadastrado", novoFilme.getNome())).showAndWait();
                
        }else{
            new Alert(AlertType.ERROR,"Nome e duração são informações obrigatórias").showAndWait();
        }

    }

}
