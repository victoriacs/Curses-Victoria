/**
 * @author Victoria Carreto Stankiewicz
 * @version 0.2
 * Classe on está tot el joc
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private final Scanner sc = new Scanner(System.in);

    private ConfigGame config;
    private Menu menu;
    private Vehicle[] participants;
    List<ResultatsCursa> resultatsCursa = new ArrayList<>();
    ResultatsCursa resul = new ResultatsCursa();
    //definició de les puntuacions als primers 3 classificats
    private int[] puntuacions = {10,8,5};

    class ResultatsCursa {
        double temps;
        Vehicle vehicle;
    }

    public Game() {
        config = new ConfigGame();
        menu = new Menu(this,config);
    }

    public void start() {
        menu.menuPrincipal();
    }

    /**
     * Comença el joc
     * @todo refactoritzar i modular el mètode play
     * @param tipus
     */
    public void play(int tipus)  {
        System.out.println(config);

        //crear participant usuari i resta de participants
        participants = new Vehicle[config.getNumRunners()];
        addParticipants(tipus);

        //comença la cursa
        System.out.println("Pilots a la graella de sortida...");
        for(int i=0; i<participants.length; i++) {
            System.out.printf("%s ",participants[i].getPilot().getNom());
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println();
        //Recorregut per tots els circuits
        for(int i=0; i<config.getNumTracks(); i++) {
            System.out.println("Prem un tecla per iniciar el circuit " + i);
            sc.nextLine();
            System.out.println(ANSI_YELLOW + "Circuit " + i + ANSI_RESET);
            //simulació del temps que ha fet cada vehicle
            for (int t = 0; t < config.getNumRunners(); t++) {
                resultatsCursa.get(t).temps = (Math.random() * 10000 + 3000);
            }

            //ordenar classificació
            resultatsCursa.sort((o1, o2) -> (int) (o1.temps - o2.temps));
            //donar punts
            for(int p=0; p < resultatsCursa.size() && p<3; p++) {
                resultatsCursa.get(p).vehicle.getPilot().addPunts(puntuacions[p]);
                double t = resultatsCursa.get(p).temps;
                String nom = resultatsCursa.get(p).vehicle.getPilot().getNom();
                if(resultatsCursa.get(p).vehicle.getPilot().getNom().equals(config.getUserName())) System.out.printf(ANSI_BLUE);
                System.out.printf("%s %.2f +%d\n",nom,t,puntuacions[p]);
                System.out.printf(ANSI_RESET);
            }
            System.out.println("----------------------");
        }

    }

    /**
     * Selecciona quin tipus de vehicle s'utilitzará
     * @todo refactoritzar el codi repetit
     * @param tipus Número del tipus vehicle
     */
    private void addParticipants(int tipus) {

        switch (tipus) {
            case 1:
                participants[0] = new Bicicleta(60);
                setParticipants();
                break;
            case 2:
                participants[0] = new Cotxe(300);
                setParticipants();
                break;
            case 3:
                System.out.println("Aquesta opció no està implementada");
                break;
            case 4:
                System.out.println("Aquesta opció no està implementada");
                break;
        }
    }

    /**
     * Es mostra el resultat final
     */
    public void finalResults() {
        //ordenar per punts
        resultatsCursa.sort((o1, o2) -> (int) (o2.vehicle.getPilot().getPunts() - o1.vehicle.getPilot().getPunts()));
        for(int i = 0; i < resultatsCursa.size(); i++) {
            ResultatsCursa r = resultatsCursa.get(i);
            if(r.vehicle.getPilot().getNom().equals(config.getUserName())) System.out.printf(ANSI_BLUE);
            System.out.printf("| %s\t| %d\t |\n",r.vehicle.getPilot().getNom(),r.vehicle.getPilot().getPunts());
            System.out.printf(ANSI_RESET);
        }
        System.out.println();
    }

    /**
     * Es borra el resultat
     */
    public void initResults() {
        resultatsCursa.clear();
    }

    /**
     * Es posen els participants
     */
    private void setParticipants() {
        participants[0].setPilot(new Pilot(config.getUserName()));
        resul.vehicle = participants[0];
        resultatsCursa.add(resul);
        for(int i=1; i<config.getNumRunners(); i++) {
            participants[i] = new Bicicleta(60);
            participants[i].setPilot(new Pilot("player-" + i));
            resul = new ResultatsCursa();
            resul.vehicle = participants[i];
            resultatsCursa.add(resul);
        }
    }

    /**
     * Elimina l'últim classificat
     * @todo pendent de fer
     */
    private void eliminarDarrerClassificat() {
    }


}
