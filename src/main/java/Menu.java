import java.util.Scanner;

public class Menu {
    private Scanner in = new Scanner(System.in);
    private int opcio;
    ConfigGame configGame;
    Game game;

    public Menu(Game game, ConfigGame config) {
        opcio = -1;
        this.game = game;
        configGame = config;
    }

    public void menuPrincipal() {
        do {
            System.out.println("1. Configuració : " + configGame);
            System.out.println("2. Jugar");
            System.out.println("3. Classificació General");
            System.out.println("0. Acabar");
            System.out.print("Entra una opció(0-3): ");
            opcio = in.nextInt();
            in.nextLine();
            switch (opcio) {
                case 1:
                    setConfig();
                    break;
                case 2:
                    play();
                    break;
                case 3:
                    System.out.println("Classificació...");
                    game.finalResults();
                    break;
                case 0:
                    System.out.println("Gràcies per jugar. Fins la propera!");
                    break;
                default:
                    System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 3");

            }
        }while(opcio != 0);
    }

    public void setConfig() {
        System.out.println("Entra el teu nom: ");
        String n = in.nextLine();
        configGame.setUsername(n);
        System.out.println("Quants participants hi haurà al campionat? ");
        configGame.setNumRunners(in.nextInt());
        in.nextLine(); //per esborrar el salt de línia
        System.out.println("Quants circuits tindrà el campionat?");
        configGame.setNumTracks(in.nextInt());
        in.nextLine();
    }

    public void play() {
        System.out.println("Amb quin vehicle vols fer el campionat?");
        System.out.println("1) Bicicletes");
        System.out.println("2) Cotxes");
        System.out.println("3) Camions");
        System.out.println("4) Motos");
        int op = in.nextInt();
        in.nextLine();
        game.initResults();
        game.play(op);
    }

}
