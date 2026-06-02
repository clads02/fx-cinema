package br.edu.ifba.saj.ads.poo;

import java.io.IOException;
import java.util.Objects;

import br.edu.ifba.saj.ads.poo.data.Cinema;
import br.edu.ifba.saj.ads.poo.model.Filme;
import javafx.util.StringConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

public class SessaoController {

    @FXML
    private DatePicker dtHorario;

    @FXML
    private ChoiceBox<Filme> slFilme;

    @FXML
    public void abrirCadastarFilme(ActionEvent event) {
        try {
            App.setRoot("Filme");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    private void initialize() {
        slFilme.setConverter(new StringConverter<Filme>() {
            @Override
            public String toString(Filme obj) {
                if (obj != null) {
                    return obj.getNome() + ":" + obj.getDuracao();
                }
                return "";
            }

            @Override
            public Filme fromString(String stringFilme) {
                return Cinema.filmes
                        .stream()
                        .filter(filme -> stringFilme.equals(filme.getNome() + ":" + filme.getDuracao()))
                        .findAny()
                        .orElse(null);
            }
        });

        carregarListaFilmes();
    }

    @FXML
    void salvar(ActionEvent event) {
        // if ((Objects.nonNull(txDuracao.getText())
        // && !txDuracao.getText().isEmpty()
        // && !txDuracao.getText().isEmpty())
        // &&
        // (Objects.nonNull(txNome.getText())
        // && !txNome.getText().isEmpty()
        // && !txNome.getText().isEmpty())) {
        // Filme novoFilme = new Filme(txNome.getText(),
        // Float.valueOf(txDuracao.getText()));
        // Cinema.filmes.add(novoFilme);
        // new Alert(AlertType.INFORMATION, String.format("Novo filme %s cadastrado",
        // novoFilme.getNome())).showAndWait();
        //
        // }else{
        // new Alert(AlertType.ERROR,"Nome e duração são informações
        // obrigatórias").showAndWait();
        // }

    }

    private void carregarListaFilmes() {
        slFilme.setItems(Cinema.filmes);
    }

}
