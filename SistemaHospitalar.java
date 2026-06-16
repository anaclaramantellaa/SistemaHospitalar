package trabalho;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

class Usuario {
    String nome;
    String CPF;
}

class Arquivo {

    private static final String CAMINHO = "consultas.txt";

    // SALVAR uma consulta no arquivo
    public static void salvarConsulta(String data, String horario, String paciente, String medico) {
        try {
            FileWriter fw = new FileWriter(CAMINHO, true); // true = adiciona ao final, não apaga
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(data + ";" + horario + ";" + paciente + ";" + medico);
            bw.newLine(); // pula linha

            bw.close();
            System.out.println("Consulta salva com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar consulta: " + e.getMessage());
        }
    }

    // LER e exibir as consultas como tabela
    public static void exibirConsultas(String nomeMedico) {
        try {
            FileReader fr = new FileReader(CAMINHO);
            BufferedReader br = new BufferedReader(fr);

            System.out.println("Boa tarde, " + nomeMedico);
            System.out.println("Suas próximas consultas são: ");
            System.out.println("=============================================================");
            System.out.printf("%-12s %-8s %-20s %-15s%n", "Data", "Horário", "Paciente", "Médico");
            System.out.println("=============================================================");

            String linha;
            boolean temConsulta = false;

            while ((linha = br.readLine()) != null) { 
                String[] dados = linha.split(";"); 
                String medico = dados[3];

                if (medico.equals(nomeMedico)) { // mostra só as do médico logado
                    System.out.printf("%-12s %-8s %-20s %-15s%n",
                            dados[0], dados[1], dados[2], dados[3]);
                    temConsulta = true;
                }
            }

            if (!temConsulta) {
                System.out.println("Nenhuma consulta encontrada.");
            }

            System.out.println("=============================================================");
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Nenhuma consulta cadastrada ainda.");
        } catch (IOException e) {
            System.out.println("Erro ao ler consultas: " + e.getMessage());
        }
    }
}

class Medico extends Usuario {

    // private String nome;
    private int CRM;
    private String areaAtuacao;

    public void adcConsultas(Scanner sc, String nomeMedico) {
        System.out.print("Data da consulta (dd/mm/aaaa): ");
        String data = sc.nextLine();
        System.out.print("Horário (hh:mm): ");
        String horario = sc.nextLine();
        System.out.print("Nome do paciente: ");
        String paciente = sc.nextLine();

        Arquivo.salvarConsulta(data, horario, paciente, nomeMedico);
        System.out.println("Consulta adicionada com sucesso!!");
    }

    // public String getNome() {
    // return nome;
    // }

    // public void setNome(String nome) {
    // this.nome = nome;
    // }

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", CRM=" + CRM +
                ", areaAtuacao='" + areaAtuacao + '\'' +
                '}';
    }

    public void mostrarConsultas(String nome, int CRM, String areaAtuacao) {
        System.out.println("Boa tarde, " + nome);
        System.out.println("Suas próximas consultas são: ");
        System.out.println("=============================================================");
        System.out.println(" Data        Horário  Paciente          Médico         ");
        System.out.println("=============================================================");
        System.out.println("10/06/2026  08:00    Ana Clara              " + nome);
        System.out.println(" 10/06/2026  09:30    Carlos Oliveira       " + nome);
        System.out.println(" 11/06/2026  14:00    Maria Souza           " + nome);
        System.out.println("=============================================================");
    }
}

class Residente extends Usuario {

    // private String nome;
    private String CPF;
    private String instituicaoEnsino;
    double tempo;

    /*
     * public String getNome() {
     * return nome;
     * }
     * 
     * public void setNome(String nome) {
     * this.nome = nome;
     * }
     */

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getInstituicao() {
        return instituicaoEnsino;
    }

    public void setInstituicao(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    Random random = new Random();

    String[] tempoRes = {
            "1 ano",
            "2 anos",
            "3 anos",
            "4 anos",
            "5 anos",
            "6 anos",

    };

    String temp = tempoRes[random.nextInt(tempoRes.length)];

    public void TempoRestante() {
        System.out.println("O tempo que falta para garantir seu CRM é: " + temp);
    }

    @Override
    public String toString() {
        return "Residente{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", instituicaoEnsino='" + instituicaoEnsino + '\'' +
                ", tempo=" + tempo +
                '}';
    }
}

class Visitante extends Usuario {

    // private String nome;
    private String CPF;
    private String nivelParentesco;
    int horario;

    /*
     * public String getNome() {
     *     return nome;
     * }
     *
     * public void setNome(String nome) {
     *     this.nome = nome;
     * }
     */

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getnivelParentesco() {
        return nivelParentesco;
    }

    public void setnivelParentesco(String nivelParentesco) {
        this.nivelParentesco = nivelParentesco;
    }

    Random random = new Random();

    String[] horas = {
            "14:00",
            "14:30",
            "15:00",
            "15:30",
            "16:00",
            "16:30",
            "17:00",
            "17:30",
            "18:00",
            "18:30"
    };

    String vis = horas[random.nextInt(horas.length)];

    public void horarioVisita(String nome) {
        System.out.println("Olá, " + nome);
        System.out.println("Seu horario de visita é: " + vis);
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", nivelParentesco='" + nivelParentesco + '\'' +
                ", horario=" + horario +
                '}';
    }
}

class Enfermeiro extends Usuario {

    // private String nome;
    private String CPF;
    private String turno;

    /*
     * public String getNome() {
     * return nome;
     * }
     * 
     * public void setNome(String nome) {
     * this.nome = nome;
     * }
     */

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", turno='" + turno + '\'' +
                '}';
    }

    public void mostrarEnf(String nome, String CPF, String turno) {
        System.out.println("Olá, " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Turno: " + turno);
    }
}

class Paciente extends Usuario {

    // private String nome;
    private String CPF;
    private String doenca;

    /*
     * public String getNome() {
     * return nome;
     * }
     * 
     * public void setNome(String nome) {
     * this.nome = nome;
     * }
     */

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", doenca='" + doenca + '\'' +
                '}';
    }

    public void mostrarPac(String nome, String CPF, String doenca) {
        System.out.println("Olá, " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Doença: " + doenca);
    }
}

class Login {
    private static String[] ultimasSenhas = { "1234", "", "" };
    private static String senhaAtual = "1234";

    public static boolean fazerLogin(Scanner sc) {
        int tentativas = 0;

        do {
            System.out.print("Digite a senha: ");
            String senhaDigitada = sc.nextLine();

            if (senhaDigitada.equals(senhaAtual)) {
                System.out.println("Login realizado com sucesso!");
                return true; // entrou no sistema

            } else {
                tentativas++;
                int restantes = 3 - tentativas;
                if (restantes > 0) {
                    System.out.println("Senha incorreta. Tentativas restantes: " + restantes);
                }

            }
        } while (tentativas < 3);

        System.out.println("\nVocê errou 3 vezes! Cadastre uma nova senha");
        cadastrarNovaSenha(sc);
        return false; // não entrou no sistema - volta para o login depois
    }

    private static void cadastrarNovaSenha(Scanner sc) {
        String novaSenha = "";
        boolean senhaValida = false;

        while (!senhaValida) {
            System.out.print("Digite a nova senha: ");
            novaSenha = sc.nextLine();
            boolean jaUsada = false; // declarar dentro do loop para resetar a cada nova tentativa e n ficar true
                                     // para sempre

            // Verificar se a nova senha é igual a alguma das últimas 3 senhas
            for (String senha : ultimasSenhas) {
                if (novaSenha.equals(senha)) {
                    jaUsada = true;
                    break;
                }
            }

            if (jaUsada) {
                System.out.println("Essa senha já foi usada recentemente. Por favor, escolha outra senha.");
            } else {
                senhaValida = true; // A nova senha é válida
            }
        }
        // Atualizar as últimas senhas
        ultimasSenhas[2] = ultimasSenhas[1];
        ultimasSenhas[1] = ultimasSenhas[0];
        ultimasSenhas[0] = novaSenha;

        // Atualizar a senha atual
        senhaAtual = novaSenha;
        System.out.println("Nova senha cadastrada com sucesso!");
    }

}

public class SistemaHospitalar {
    public static void main(String[] args) {

        Medico medico = new Medico();
        Residente residente = new Residente();
        Visitante visitante = new Visitante();
        Enfermeiro enfermeiro = new Enfermeiro();
        Paciente paciente = new Paciente();

        Scanner sc = new Scanner(System.in);
       

        System.out.println("============Seattle Grace============");
        System.out.println("Seja bem vindo, faça o login para acessar o sistema");

        boolean logado = false;

        int opcao = 0;

        do { // Executa PRIMEIRO, DEPOIS verifica a condição - executa pelo menos uma vez
            System.out.println("\n============MENU============");
            System.out.println("1- Sou médico(a)");
            System.out.println("2- Sou enfermeiro(a)");
            System.out.println("3- Sou residente");
            System.out.println("4- Sou paciente");
            System.out.println("5- Sou visitante");
            System.out.println("6- Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();// Limpar o buffer do scanner

         if (opcao != 6) {   
            while (!logado) {  
                 logado = Login.fazerLogin(sc);
            }
        }  
            switch (opcao) {
                case 1:
                    System.out.println("Digite seu nome: ");
                    String nome1 = sc.nextLine();
                    System.out.println("Digite seu CRM: ");
                    int crm = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite sua área de atuação: ");
                    String areaAt = sc.nextLine();
                     int opcaoMedico = 0;
    do {
        System.out.println("\n--- Menu Médico ---");
        System.out.println("1- Ver minhas consultas");
        System.out.println("2- Cadastrar nova consulta");
        System.out.println("3- Voltar");
        System.out.print("Escolha: ");
        opcaoMedico = sc.nextInt();
        sc.nextLine();

        switch (opcaoMedico) {
            case 1:
                Arquivo.exibirConsultas(nome1);
                break;
            case 2:
                medico.adcConsultas(sc, nome1);
                break;
            case 3:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    } while (opcaoMedico != 3);
    break;
                case 2:
                    System.out.println("Digite seu nome: ");
                    String nome2 = sc.nextLine();
                    System.out.println("Digite seu CPF: ");
                    String cpf2 = sc.nextLine();
                    System.out.println("Digite seu turno:  ");
                    String turno = sc.nextLine();
                    enfermeiro.mostrarEnf(nome2, cpf2, turno);
                    break;
                case 3:
                    System.out.println("Digite seu nome: ");
                    String nome3 = sc.nextLine();
                    System.out.println("Digite seu CPF: ");
                    String cpf3 = sc.nextLine();
                    System.out.println("Digite sua Instituição de ensino:  ");
                    String inst = sc.nextLine();
                    residente.TempoRestante();
                    break;
                case 4:
                    System.out.println("Digite seu nome: ");
                    String nome4 = sc.nextLine();
                    System.out.println("Digite seu CPF: ");
                    String cpf4 = sc.nextLine();
                    System.out.println("Digite qual doença deseja tratar:  ");
                    String doenca = sc.nextLine();
                    paciente.mostrarPac(nome4, cpf4, doenca);
                    break;
                case 5:
                    System.out.println("Digite seu nome: ");
                    String nome5 = sc.nextLine();
                    System.out.println("Digite seu CPF: ");
                    String cpf5 = sc.nextLine();
                    System.out.println("Digite qual o nível de parentesco com o paciente:  ");
                    String nivelParentesco = sc.nextLine();
                    visitante.horarioVisita(nome5);
                    break;
                case 6:
                    System.out.println("Obrigada pela visita ao nosso Hospital!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            if (opcao != 6) {
                logado = false; 
                System.out.println("Logout realizado com sucesso!!");
            }

        } while (opcao != 6);

        sc.close();

    }
}
