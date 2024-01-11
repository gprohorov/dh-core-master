package io.clinicway.dh.api.consumer.util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DecodedToken {
    public String iss;
    public String azp;
    public String preferred_username;

    public static DecodedToken getDecoded(String encodedToken) {
        String[] pieces = encodedToken.split("\\.");
        String b64payload = pieces[1];

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String jsonString = new String(decoder.decode(b64payload), StandardCharsets.UTF_8);

        return new Gson().fromJson(jsonString, DecodedToken.class);
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}