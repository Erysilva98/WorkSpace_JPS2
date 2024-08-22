import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigSingleton {
    private static ConfigSingleton instancia;
    private Map<String, String> configuracoes;

    // Caminho do arquivo de configuração
    private static final String CONFIG_FILE_PATH = "configuracao.txt";

    // Construtor privado para evitar instanciamento externo
    private ConfigSingleton() {
        configuracoes = new LinkedHashMap<>(); // Usar LinkedHashMap para manter a ordem de inserção
        carregarConfiguracoes();
    }

    // Método para obter a instância única da classe
    public static ConfigSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConfigSingleton();
        }
        return instancia;
    }

    // Método para carregar as configurações do arquivo
    private void carregarConfiguracoes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("=", 2);
                if (partes.length == 2) {
                    configuracoes.put(partes[0], partes[1]);
                } else {
                    configuracoes.put(partes[0], ""); // Se não houver valor após o '=', salvar uma string vazia
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos para acessar os campos de configuração individualmente
    public String getAppId() {
        return configuracoes.get("AppId");
    }

    public String getUserName() {
        return configuracoes.get("UserName");
    }

    public String getLanguage() {
        return configuracoes.get("Language");
    }

    public String getOffline() {
        return configuracoes.get("Offline");
    }

    public String getAutoDLC() {
        return configuracoes.get("AutoDLC");
    }

    public String getBuildId() {
        return configuracoes.get("BuildId");
    }

    public String getDLCName() {
        return configuracoes.get("DLCName");
    }

    public String getUpdateDB() {
        return configuracoes.get("UpdateDB");
    }

    public String getSignature() {
        return configuracoes.get("Signature");
    }

    public String getWindowInfo() {
        return configuracoes.get("WindowInfo");
    }

    public String getLVWindowInfo() {
        return configuracoes.get("LVWindowInfo");
    }

    public String getApplicationPath() {
        return configuracoes.get("ApplicationPath");
    }

    public String getWorkingDirectory() {
        return configuracoes.get("WorkingDirectory");
    }

    public String getWaitForExit() {
        return configuracoes.get("WaitForExit");
    }

    public String getNoOperation() {
        return configuracoes.get("NoOperation");
    }

    // Método para imprimir todas as configurações na ordem especificada
    public void imprimirConfiguracoes() {
        configuracoes.forEach((chave, valor) -> System.out.println(chave + "=" + valor));
    }
}
