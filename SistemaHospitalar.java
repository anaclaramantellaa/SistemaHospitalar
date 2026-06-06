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

public class SistemaHospitalar{
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
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

        sc.close();

        Medico medico = new Medico();
        Residente residente = new Residente();
        Visitante visitante = new Visitante();
        Enfermeiro enfermeiro = new Enfermeiro();
        Paciente paciente = new Paciente();

        

        System.out.println("============Seattle Grace============");
        System.out.println("Seja bem vindo, deseja se cadastrar? ");
        System.out.println("1- SIM   || 2- NÃo");
        


    }
}