package nz.co.yellow.emerge.axle.regression.maps;

/**
 * Created by weixy on 1/07/14.
 */
public class Maps {
    private Maps() {
    }

    public static String getPath(String mapName) {
        return Maps.class.getResource(mapName).getPath();
    }
}
