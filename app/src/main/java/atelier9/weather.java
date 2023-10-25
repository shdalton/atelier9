package atelier9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class weather {
    public String getWeather(String city)
    throws MalformedURLException, IOException
    {
        String rc;
        // le format n'a pas été complété mais l'information se trouve à:
        // https://github.com/chubin/wttr.in
        String apiUrl = "https://wttr.in/" + city + "?format="
        URL url = new URL(apiUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // obtenir le code de réponse
        int responseCode = connection.

        // si le code de réponse est OK...
        if (responseCode == HttpURLConnection.) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // le code de retour devrait être la réponse convertie en string
            = response
        } else {
            // en cas d'erreur on va retourner un meessage significatif
            rc = "" + responseCode;
        }

        // ne pas oublier de se deconnecter quand on a terminé
        connection.
        return rc;
    }
}
