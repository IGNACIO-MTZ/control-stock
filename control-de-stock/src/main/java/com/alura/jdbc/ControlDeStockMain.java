package com.alura.jdbc;

import javax.swing.JFrame;

import com.alura.jdbc.view.ControlDeStockFrame;
import com.alura.jdbc.view.LoginFrame;
import com.alura.jdbc.view.LoginFrame.LoginListener;

public class ControlDeStockMain {

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();

        // Mueve la creación de ControlDeStockFrame aquí, después de verificar las credenciales
        loginFrame.setLoginListener(new LoginListener() {
            @Override
            public void onLoginSuccess() {
                ControlDeStockFrame controlDeStockFrame = new ControlDeStockFrame();
                controlDeStockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}


