package com.alura.jdbc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private LoginListener loginListener;

    public interface LoginListener {
        void onLoginSuccess();
    }

    public void setLoginListener(LoginListener listener) {
        this.loginListener = listener;
    }

    public LoginFrame() {
        // Configurar la ventana
        setTitle("Inicio de Sesión");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel usernameLabel = new JLabel("Usuario:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(usernameLabel, constraints);

        usernameField = new JTextField(20);
        usernameField.setPreferredSize(new Dimension(300, 30)); // Ajuste de tamaño
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(usernameField, constraints);

        JLabel passwordLabel = new JLabel("Contraseña:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, constraints);

        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(300, 30)); // Ajuste de tamaño
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, constraints);

        JButton loginButton = new JButton("Iniciar Sesión");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, constraints);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Verificar las credenciales en tu base de datos
                // Si las credenciales son válidas, puedes continuar con la aplicación

                // Ejemplo simple: Si el nombre de usuario es "admin" y la contraseña es "admin123"
                if (username.equals("admin") && password.equals("admin123")) {
                    // Iniciar la aplicación principal (ControlDeStockFrame)
                    if (loginListener != null) {
                        loginListener.onLoginSuccess();
                    }
                    dispose(); // Cerrar la ventana de inicio de sesión
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Credenciales incorrectas", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame();
            }
        });
    }
}

