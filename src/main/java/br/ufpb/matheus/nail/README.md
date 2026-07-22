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

---

## 🏛️ Arquitetura e Estrutura de Classes

O projeto está organizado no pacote `br.ufpb.matheus.nail` com a seguinte estrutura:

```text
src/main/java/br/ufpb/matheus/nail/
├── NailBase.java                      # Classe modelo que representa um atendimento (Cliente, Serviço, Horário, Preço, Local)
├── NailInterface.java                 # Interface / TAD que define os métodos do sistema
├── NailSistema.java                   # Implementação das regras de negócio e gerenciamento do HashMap
├── NailCadastroController.java        # ActionController para escutar e validar os inputs de cadastro da GUI
├── JanelaPrincipal.java               # Interface gráfica (Swing) com formulário e barra de menus
├── GravadorDeDados.java               # Responsável por salvar/recuperar dados via ObjectInputStream/ObjectOutputStream
├── NaoAchouClienteException.java      # Exceção customizada lançada quando um cliente não é encontrado
└── NailPrincipal.java                 # Classe principal contendo o método main()
```

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **JDK (Java Development Kit)** 8 ou superior instalado.
- IDE de sua preferência (Eclipse, IntelliJ IDEA, VS Code ou NetBeans) ou terminal.

### Passos para Execução

1. **Clonar o Repositório**:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.e
   cd seu-repositorio
   ```

2. **Compilar os Arquivos**:
   ```bash
   javac br/ufpb/matheus/nail/*.java
   ```

3. **Executar a Aplicação**:
   ```bash
   java br.ufpb.matheus.nail.NailPrincipal
   ```

---

## 👤 Autor

Desenvolvido por **Matheus** como parte do aprendizado de Programação Orientada a Objetos (POO) na **UFPB**.
