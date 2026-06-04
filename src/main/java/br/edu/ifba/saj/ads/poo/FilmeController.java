package br.edu.ifba.saj.ads.poo;

import java.io.IOException;
import java.util.Objects;
import java.util.function.UnaryOperator;

import br.edu.ifba.saj.ads.poo.data.Cinema;
import br.edu.ifba.saj.ads.poo.model.Filme;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Alert.AlertType;

public class FilmeController {

    @FXML
    private TextField txDuracao;

    @FXML
    private TextField txNome;

        @FXML
    private void initialize() {
        
        // Expressão regular que aceita apenas dígitos (0-9) e permite que o campo fique
        // vazio
        UnaryOperator<TextFormatter.Change> filtroInteiro = change -> {
            String novoTexto = change.getControlNewText();
            if (novoTexto.matches("\\d*")) {
                return change; // Permite a alteração
            }
            return null; // Rejeita a alteração se contiver letras ou caracteres inválidos
        };

        // Aplica o filtro formatador no TextField
        txDuracao.setTextFormatter(new TextFormatter<>(filtroInteiro));

        Platform.runLater(() -> txNome.requestFocus());
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
