import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormularioIngresoUsuarios extends JFrame {
    private JTextField nombreUsuarioField;
    private JPasswordField claveField;

    private List<Usuario> usuarios;
    private JPanel panel1;
    private JButton guardarButton;


    public FormularioIngresoUsuarios() {
        usuarios = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        setTitle("Ingreso de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel nombreUsuarioLabel = new JLabel("Nombre de Usuario:");
        nombreUsuarioField = new JTextField();
        JLabel claveLabel = new JLabel("Clave:");
        claveField = new JPasswordField();

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = nombreUsuarioField.getText();
                String clave = new String(claveField.getPassword());

                usuarios.add(new Usuario(nombreUsuario, clave));
                RegistroUsuarios.guardarUsuarios(usuarios);

                JOptionPane.showMessageDialog(FormularioIngresoUsuarios.this,
                        "Usuario guardado exitosamente.");
            }
        });

        panel.add(nombreUsuarioLabel);
        panel.add(nombreUsuarioField);
        panel.add(claveLabel);
        panel.add(claveField);
        panel.add(new JLabel());
        panel.add(guardarButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioIngresoUsuarios();
    }
}
