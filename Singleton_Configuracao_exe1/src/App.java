public class App {
    public static void main(String[] args) {
        // Obtendo a instância única do singleton
        ConfigSingleton configuracao = ConfigSingleton.getInstancia();

        // Imprimindo todas as configurações na ordem correta
        configuracao.imprimirConfiguracoes();

        // // Acessando configurações individuais, se necessário
        System.out.println("\nAcessando configuracoes individuais:");
        System.out.println("AppId: " + configuracao.getAppId());
        System.out.println("UserName: " + configuracao.getUserName());
        System.out.println("Language: " + configuracao.getLanguage());
    }
}
