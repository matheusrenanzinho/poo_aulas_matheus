package br.ufpb.matheus.nail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NailSistemaTest {

    private NailInterface sistema;

    @BeforeEach
    public void setUp() {
        sistema = new NailSistema();
    }

    @Test
    public void testCadastrarEPesquisar() {
        assertDoesNotThrow(() -> {
            sistema.cadastrarNovoAtendimento("Ana", "Esmaltação em Gel", "10:00", 60.0, "Centro");
        });

        assertDoesNotThrow(() -> {
            sistema.pesquisarAtendimentoPorLocal("Ana");
        });
    }

    @Test
    public void testRemoverAtendimento() {
        sistema.cadastrarNovoAtendimento("Carla", "Banho de Gel", "11:00", 90.0, "Centro");

        assertDoesNotThrow(() -> {
            sistema.deletarAtendimentoPeloNomeDoCliente("Carla");
        });

        assertThrows(NaoAchouClienteException.class, () -> {
            sistema.pesquisarAtendimentoPorLocal("Carla");
        });
    }
}