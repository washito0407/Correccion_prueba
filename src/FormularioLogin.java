import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FormularioLogin extends JFrame {
    private JTextField nombreUsuarioField;
    private JPasswordField claveField;
    private JButton ingresarButton;
    private JPanel panel1;

    public FormularioLogin() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel nombreUsuarioLabel = new JLabel("Nombre de Usuario:");
        nombreUsuarioField = new JTextField();
        JLabel claveLabel = new JLabel("Clave:");
        claveField = new JPasswordField();

        ingresarButton = new JButton("Ingresar");
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = nombreUsuarioField.getText();
                String clave = new String(claveField.getPassword());

                if (validarUsuario(nombreUsuario, clave)) {
                    mostrarNombreUsuario(nombreUsuario);
                } else {
                    JOptionPane.showMessageDialog(FormularioLogin.this,
                            "Nombre de usuario o clave incorrecta.");
                }
            }
        });

        panel.add(nombreUsuarioLabel);
        panel.add(nombreUsuarioField);
        panel.add(claveLabel);
        panel.add(claveField);
        panel.add(new JLabel());
        panel.add(ingresarButton);

        add(panel);
        setVisible(true);
    }

    private boolean validarUsuario(String nombreUsuario, String clave) {
        List<Usuario> usuarios = RegistroUsuarios.cargarUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getClave().equals(clave)) {
                return true;
            }
        }
        return false;
    }

    private void mostrarNombreUsuario(String nombreUsuario) {
        JOptionPane.showMessageDialog(FormularioLogin.this,
                "Bienvenido, " + nombreUsuario + "!");
    }

    public static void main(String[] args) {
        new FormularioLogin();
    }
}
