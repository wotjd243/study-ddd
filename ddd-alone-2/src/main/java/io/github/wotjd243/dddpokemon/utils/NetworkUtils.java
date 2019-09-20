package io.github.wotjd243.dddpokemon.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
    private final static Logger logger = LoggerFactory.getLogger(NetworkUtils.class);

    private NetworkUtils() {
    }

    public static URL parseUrl(final String spec) {
        URL url = null;
        try {
            url = new URL(spec);
        } catch (final MalformedURLException e) {
            logger.error("Parsing failed", e);
        }

        logger.debug("Parsed URL {}", url);

        return url;
    }
}
