package com.app;

import com.service.MainService;
import com.view.UserInterface;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserInterface userInterface = new UserInterface();
        MainService service = new MainService();
        boolean sair = false;

        while(!sair){
           int opcao = userInterface.menuPrincipal();
           service.mainService(opcao);
        }
    }
}
