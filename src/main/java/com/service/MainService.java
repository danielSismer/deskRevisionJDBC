package com.service;

import com.dao.ClienteDAO;
import com.dao.MotoDAO;
import com.dao.OrdemFechadaDAO;
import com.dao.OrdemServicoDAO;
import com.model.Cliente;
import com.model.Moto;
import com.model.OrdemFechada;
import com.model.OrdemServico;
import com.view.UserInterface;

import java.sql.SQLException;
import java.util.List;

public class MainService {

    UserInterface userInterface = new UserInterface();
    MotoDAO motoDAO = new MotoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
    OrdemFechadaDAO ordemFechadaDAO = new OrdemFechadaDAO();

    public boolean mainService (int opcao) throws SQLException {

    switch (opcao){

        case 1 -> {
            Cliente cliente = userInterface.cadastrarCliente();

            if(!cliente.getNome().isEmpty()){
                if(!cliente.getTelefone().isEmpty()){
                    if(!cliente.getCpf().isEmpty()){
                        clienteDAO.cadastrarCliente(cliente);
                    }
                }
            }
        }

        case 2 -> {
           Moto moto = userInterface.cadastrarMoto();

           if(!moto.getModelo().isEmpty()){
               if(!moto.getPlaca().isEmpty()){
                   if(moto.getAno() > 2000){
                        motoDAO.CadastrarMoto(moto);
                       System.out.println("Moto Cadastrada com Sucesso!!");
                   }
               }
           }
        }

        case 3 -> {
            OrdemServico ordemServico = userInterface.cadastrarOrdemServico();
            List<Moto> motos = motoDAO.select();
            int cont = 0;

            for (Moto moto : motos ){
                if (moto.getPlaca().equalsIgnoreCase(ordemServico.getPlacaMoto())){
                    ordemServicoDAO.criarOrdemServico(ordemServico);
                    System.out.println("Ordem de Serviço criada com sucesso");
                    cont++;
                }
            }

            if(cont == 0 ){ System.out.println("Moto não encontrada"); }

        }

        case 4 -> {

            OrdemFechada ordemFechada = userInterface.fecharOrdem();
            List<OrdemServico> ordemServicos = ordemServicoDAO.select();
            int cont = 0;

            for (OrdemServico ordemServico : ordemServicos ){
                if (ordemServico.getId() == ordemFechada.getId()){
                    cont++;
                    ordemFechadaDAO.insert(ordemFechada);
                    ordemServicoDAO.updateStatus(ordemFechada.getId());
                    System.out.println("Ordem fechada com sucesso!!!");
                }
            }

            if (cont == 0 ){
                System.out.println("Ordem Não encontrada");
            }

        }
    }

        return false;
    }
}
