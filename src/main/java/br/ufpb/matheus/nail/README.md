# 💅 Nail System - Sistema de Agendamento e Gestão de Atendimentos

O **Nail System** é um sistema desenvolvido em Java para o gerenciamento e agendamento de atendimentos de manicure e estéticas de unhas. O objetivo é permitir o cadastro de novos agendamentos, busca rápida por clientes, remoção e persistência de dados em arquivo.

---

## 💻 Sobre o Projeto

O projeto foi desenvolvido em **Java (Java Swing)** como aplicação de conceitos de Programação Orientada a Objetos (POO), tais como:
- **Interface e Polimorfismo** (`NailInterface`)
- **Tratamento de Exceções Personalizadas** (`NaoAchouClienteException`)
- **Padrão MVC / Controllers** (`NailCadastroController`)
- **Persistência de Dados via Serialização** (`GravadorDeDados`, `Serializable`)
- **Interface Gráfica com Swing** (`JanelaPrincipal`)

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java 8+
- **GUI Framework**: Java Swing / AWT
- **Armazenamento**: Arquivo binário serializado (`.dat`)
- **Estrutura de Dados**: `HashMap<String, NailBase>`

---

## 📌 Funcionalidades Principais

- ➕ **Cadastrar Atendimento**: Registra o nome do cliente, serviço, horário, preço e estabelecimento.
- 🔍 **Pesquisar Cliente**: Busca se existe um atendimento cadastrado para o cliente informado.
- 🗑️ **Apagar Atendimento**: Remove o registro do cliente informado do sistema.
- 💾 **Salvar e Recuperar Dados**: Salva o estado atual dos agendamentos em disco (`atendimentos.dat`) e recupera automaticamente ao iniciar a aplicação.