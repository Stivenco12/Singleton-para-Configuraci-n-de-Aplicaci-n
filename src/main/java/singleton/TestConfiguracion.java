package singleton;

public class TestConfiguracion {
    public static void main(String[] args) {
        // Obtener la instancia del Singleton
        Localconfiguracion config = Localconfiguracion.getInstancia();

        // Obtener valores de configuración desde el archivo
        System.out.println("Nombre de la aplicación: " + config.get("appName"));
        System.out.println("Modo de ejecución: " + config.get("modo"));

        // Agregar una nueva configuración en tiempo de ejecución
        config.set("maxUsuarios", "500");
        System.out.println("Usuarios máximos permitidos: " + config.get("maxUsuarios"));

        // Mostrar todas las configuraciones
        config.mostrarConfiguraciones();
    }
}