package com.view;

import com.model.Cliente;
import com.model.Moto;
import com.model.OrdemFechada;
import com.model.OrdemServico;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInterface {

    static Scanner input = new Scanner(System.in);

    public int menuPrincipal (){
        System.out.println("\n===============================");
        System.out.println("     🏍️  SISTEMA DE OFICINA  ");
        System.out.println("===============================");
        System.out.println("1️⃣  Cadastrar Cliente");
        System.out.println("2️⃣  Cadastrar Moto");
        System.out.println("3️⃣  Abrir Ordem de Serviço");
        System.out.println("4️⃣  Fechar Ordem de Serviço");
        System.out.println("5️⃣  Consultar OS por Cliente");
        System.out.println("-------------------------------");
        System.out.println("0️⃣  Sair");
        System.out.println("===============================");
        System.out.print("➡️  Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine();
        return opcao;
    }

    public Moto cadastrarMoto(){
        System.out.println("\n===============================");
        System.out.println("     🏍️  CADASTRAR MOTO         ");
        System.out.println("================================");
        System.out.println("Informe a Placa da Moto: ");
        String placa = input.nextLine();
        System.out.println("Informe o Modelo da Moto: ");
        String modelo = input.nextLine();
        System.out.println("Informe o Ano da Moto: ");
        int ano = input.nextInt();
        input.nextLine();
        Moto moto = new Moto(modelo, placa, ano);
        return moto;
    }

    public Cliente cadastrarCliente(){
        System.out.println("\n===============================");
        System.out.println("     🏍️  CADASTRAR CLIENTE      ");
        System.out.println("================================");
        System.out.println("Informe o Nome do CLiente: ");
        String nome = input.nextLine();
        System.out.println("Informe o Telefone do Cliente: ");
        String telefone = input.nextLine();
        System.out.println("Informe o CPF do CLiente: ");
        String cpf = input.nextLine();
        Cliente cliente = new Cliente(nome, telefone, cpf);
        return cliente;
    }

    public OrdemServico cadastrarOrdemServico(){
        System.out.println("\n===============================");
        System.out.println("     🏍️  CRIAR OS           ");
        System.out.println("================================");
        System.out.println("Informe a Placa da moto: ");
        String placa = input.nextLine();
        System.out.println("Informe a Descrição do Problema");
        String descricao = input.nextLine();
        return new OrdemServico(descricao, placa);
    }

    public OrdemFechada fecharOrdem() {
        System.out.println("\n===============================");
        System.out.println("     🏍️  FECHAR OS           ");
        System.out.println("================================");
        System.out.println("Informe o ID da Ordem: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Informe o Valor do Serviço: ");
        double valor = input.nextDouble();
        input.nextLine();
        OrdemFechada ordemFechada = new OrdemFechada(id, valor);
        return ordemFechada;
    }
}
