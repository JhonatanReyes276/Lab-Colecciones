public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        Material libro1 = new Libro("LB-2026-001", "Cien años de soledad", 1967, true, "Gabo", "978-958-5457-30-0");
        Material libro2 = new Libro("LB-2026-002", "Hush, hush", 2009, false, "Becca Fitzpatrick", "978-958-5457-30-5");
        Material revista1 = new Revista("RV-2026-003", "Caras", 2010, false, 24, "Entretenimiento");
        Material revista2 = new Revista("RV-2026-004", "Forbes", 2024, true, 17, "Negocios");

        sistema.registrarMaterial(libro1);
        sistema.registrarMaterial(libro2);
        sistema.registrarMaterial(revista1);
        sistema.registrarMaterial(revista2);

        String codigoBuscado = "LB-2026-002";
        Material materialEncontrado = sistema.buscarMaterial(codigoBuscado);

        if (materialEncontrado != null) {
            materialEncontrado.mostrarInfo();
        }

        String codigoInexistente = "RV-9999-999";
        Material materialInexistente = sistema.buscarMaterial(codigoInexistente);

        if (materialInexistente == null) {
            System.out.println("El código '" + codigoInexistente + "' no existe en el catálogo.");
        }

        String codigoLibro = "RV-2026-055";
        sistema.agregarEspera(codigoLibro, "Dayana González");
        sistema.agregarEspera(codigoLibro, "Cristian Avendaño");
        sistema.agregarEspera(codigoLibro, "Alba Nepomuceno");

        String primerAtendido = sistema.siguienteEnEspera(codigoLibro);
        System.out.println("Primer usuario atendido: " + primerAtendido);

        String segundoAtendido = sistema.siguienteEnEspera(codigoLibro);
        System.out.println("Segundo usuario atendido: " + segundoAtendido);

        System.out.println("El siguiente usuario que queda en la fila es: " + sistema.siguienteEnEspera(codigoLibro));

        boolean m1 = sistema.registrarMiembro("Dayana González");
        boolean m2 = sistema.registrarMiembro("Cristian Avendaño");
        boolean m3 = sistema.registrarMiembro("Alba Nepomuceno");

        System.out.println("Registro de Dayana González (Nuevo): " + m1);
        System.out.println("Registro de Cristian Avendaño (Nuevo): " + m2);
        System.out.println("Registro de Alba Nepomuceno (Nuevo): " + m3);

        boolean mDuplicado = sistema.registrarMiembro("Cristian Avendaño");
        System.out.println("El registro de Cristian Avendaño es nuevo: " + mDuplicado);

        String usuarioExistente = "Alba Nepomuceno";
        String usuarioInexistente = "Ernesto Barrero";

        System.out.println("¿Tiene membresía '" + usuarioExistente + "'? " + sistema.tieneMembresia(usuarioExistente));
        System.out.println("¿Tiene membresía '" + usuarioInexistente + "'? " + sistema.tieneMembresia(usuarioInexistente));

        sistema.mostrarCatalogo();
    }
}
