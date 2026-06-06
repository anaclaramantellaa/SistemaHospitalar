package trabalho;

import java.util.Scanner;

class Medico{

    private String nome;
    private int CRM;
    private String areaAtuacao;

    public void adcConsultas(){
        System.out.println("Consulta adicionada com sucesso!!");
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public int getCRM(){
        return CRM;
    }
    public void setCRM(int CRM){
        this.CRM = CRM;
    }

    public String getAreaAtuacao(){
        return areaAtuacao;
    }
    public void setAreaAtuacao(String areaAtuacao){
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
}

class Residente{

    private String nome;
    private String CPF;
    private String instituicaoEnsino;
    double tempo;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    public String getInstituicao(){
        return instituicaoEnsino;
    }
    public void setInstituicao(String instituicaoEnsino){
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public void TempoRestante(){
        System.out.println("O tempo que falta para garantir seu CRM é: " + tempo);
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

class Visitante{

    private String nome;
    private String CPF;
    private String nivelParentesco;
    int horario;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    public String getnivelParentesco(){
        return nivelParentesco;
    }
    public void setnivelParentesco(String nivelParentesco){
        this.nivelParentesco = nivelParentesco;
    }

    public void horarioVisita(){
        System.out.println("Seu horario de visita é: " + horario);
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

class Enfermeiro{

    private String nome;
    private String CPF;
    private String turno;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    public String getTurno(){
        return turno;
    }
    public void setTurno(String turno){
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
}

class Paciente{

    private String nome;
    private String CPF;
    private String doenca;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    public String getDoenca(){
        return doenca;
    }
    public void setDoenca(String doenca){
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
}

class Login{
    private static String [] ultimasSenhas = {"1234", "", ""};
    private static String senhaAtual = "1234";

    public static boolean fazerLogin(Scanner sc){
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
        }while (tentativas < 3);

                System.out.println("\nVocê errou 3 vezes! Cadastre uma nova senha");
                cadastrarNovaSenha(sc);
                return false; // não entrou no sistema - volta para o login depois
    }
    private static void cadastrarNovaSenha(Scanner sc){
        String novaSenha = "";
        boolean senhaValida = false; 

        while (!senhaValida) {
         System.out.print("Digite a nova senha: ");
         novaSenha = sc.nextLine();
         boolean jaUsada = false; //declarar dentro do loop para resetar a cada nova tentativa e n ficar true para sempre

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

public class SistemaHospitalar{
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

        System.out.println("============Seattle Grace============");
        System.out.println("Seja bem vindo, faça o login para acessar o sistema");
           
        boolean logado = false;

        while (!logado) {
            logado = Login.fazerLogin(sc);
        }   

    int opcao = 0;
    
        do { //Executa PRIMEIRO, DEPOIS verifica a condição - executa pelo menos uma vez
            System.out.println("\n============MENU============");
            System.out.println("1- Cadastrar paciente");
            System.out.println("2- Consultar paciente");
            System.out.println("3- Relatórios");
            System.out.println("4- Sair");
            System.out.print("Escolha uma opção: ");

             opcao = sc.nextInt();
              sc.nextLine();// Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        System.out.println("Cadastro...");
                        // Lógica para cadastrar paciente
                        break;
                    case 2:
                        System.out.println("Consulta...");
                        // Lógica para consultar paciente
                        break;
                    case 3:
                        System.out.println("Relatórios...");
                        // Lógica para gerar relatórios
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                
        } while (opcao != 4);

    
        Medico medico = new Medico();
        Residente residente = new Residente();
        Visitante visitante = new Visitante();
        Enfermeiro enfermeiro = new Enfermeiro();
        Paciente paciente = new Paciente();

        sc.close();
        
    }
}