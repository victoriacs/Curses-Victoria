/**
 * @author Victoria Carreto Stankiewicz
 * @version 0.2
 * Classe on está tota la configuració del joc
 */
public class ConfigGame {
    private String username;
    private int numRunners;
    private int numTracks;

    /**
     * Retorna el número de tracks
     * @return numTracks
     */
    public int getNumTracks() {
        return numTracks;
    }

    /**
     * Es posa el número de tracks
     * @param numTracks
     */
    public void setNumTracks(int numTracks) {
        this.numTracks = numTracks;
    }

    /**
     * Configuració principal si no s'edita
     */
    public ConfigGame() {
        numRunners = 5;
        numTracks = 3;
        username = "player";
    }

    /**
     * Es posa el num del jugador
     * @param username Nom del jugador
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retorna el nom del jugador
     * @return username
     */
    public String getUserName() {
        return username;
    }

    /**
     * Retorna el número de jugadors
     * @return numRunners
     */
    public int getNumRunners() {
        return numRunners;
    }

    /**
     * Es posa el número de jugadors
     * @param numRunners Número de jugadors
     */
    public void setNumRunners(int numRunners) {
        this.numRunners = numRunners;
    }

    //sobrecàrrega que hereta de la classe Object
    public String toString() {
        return "ConfigGame{" +
                "username='" + username + '\'' +
                ", numRunners=" + numRunners +
                ", numTracks=" + numTracks +
                '}';
    }
}
