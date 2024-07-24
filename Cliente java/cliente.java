import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class cliente {
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter saida;
    private BufferedReader teclado;

    public cliente(String endereco, int porta) {
        try {
            socket = new Socket(endereco, porta);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new PrintWriter(socket.getOutputStream(), true);
            teclado = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviarMensagem(String mensagem) {
        saida.println(mensagem);
        saida.flush();
    }

    public void receberMensagem() {
        try {
            String mensagemCliente;
            String mensagemServidor;
            while (true) {
                System.out.println("Cliente: ");
                mensagemCliente = teclado.readLine();
                saida.println(mensagemCliente);

                mensagemServidor = entrada.readLine();
                System.out.println("Servidor: " + mensagemServidor + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fecharConexao() {
        try {
            entrada.close();
            saida.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        cliente cliente = new cliente("localhost", 12345);
        cliente.receberMensagem();
    }
}
