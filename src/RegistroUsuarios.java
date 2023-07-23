import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroUsuarios {
    private static final String NOMBRE_ARCHIVO = "usuarios.dat";

    public static void guardarUsuarios(List<Usuario> usuarios) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            out.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            usuarios = (List<Usuario>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
