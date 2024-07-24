import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader entrada;
    private PrintWriter saida;
    private BufferedReader teclado;

    public server(int porta) {
        try {
            serverSocket = new ServerSocket(porta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void esperarConexao() {
        try {
            System.out.println("Servidor aguadando conexão...");
            clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clientSocket);

            entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            saida = new PrintWriter(clientSocket.getOutputStream(), true);
            teclado = new BufferedReader(new InputStreamReader(System.in));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receberMensagem() {
        try {
            String mensagemCliente;
            String mensagemServidor;
            while ((mensagemCliente = entrada.readLine()) != null) {
                System.out.println("Cliente: " + mensagemCliente);
                System.out.println("Digite a mensagem para o cliente");
                mensagemServidor = teclado.readLine();
                this.enviarMensagem(mensagemServidor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviarMensagem(String mensagem) {
        saida.println(mensagem);
        saida.flush();
    }

    public void fecharConexao() {
        try {
            entrada.close();
            saida.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        server servidor = new server(12345);
        servidor.esperarConexao();
        servidor.receberMensagem();
        servidor.fecharConexao();
    }

}
