package com.taxiservicespring.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that helps to calculate distance between two addresses.
 *
 * @author Maryna Lendiel
 */
public class OrderDistanceCalculator {
    private static final Logger LOGGER = LogManager.getLogger(OrderDistanceCalculator.class);

    public static double calculate(String startPoint, String finishPoint) {
        startPoint = startPoint.replaceAll(" ", "+");
        finishPoint = finishPoint.replaceAll(" ", "+");
        LOGGER.info(startPoint);
        LOGGER.info(finishPoint);
        double distance = 0;

        try {
            // Reference - https://developers.google.com/maps/documentation/distancematrix/
            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + startPoint + "&destinations=" + finishPoint + "&mode=driving");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            LOGGER.info(conn);
            String line, outputString = "";
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }
            LOGGER.info(outputString);

            String pattern = "\\\"value\\\" : [0-9]+";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(outputString);
            if (m.find()) {
                String s = m.group();
                distance = Double.parseDouble(s.substring(11)) / 1000;
            }
            LOGGER.info(distance);
            return distance;
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return distance;
    }
}
