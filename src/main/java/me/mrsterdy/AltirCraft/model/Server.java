package me.mrsterdy.AltirCraft.model;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.annotation.Nullable;

import java.util.List;
import java.util.Map;

public record Server(boolean isOnline, @Nullable String version, @Nullable String icon, @Nullable List<String> players) {

    private static final WebClient client = WebClient.create("https://api.mcsrvstat.us/2/bebra.bitor.in");

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    public static Server getServer() {
        Map<String, Object> data = client
                .get()
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        Map<String, Object> players = (Map<String, Object>) data.get("players");

        return new Server(
                (boolean) data.get("online"),
                (String) data.get("version"),
                (String) data.get("icon"),
                players == null ? null : (List<String>) players.get("list")
        );
    }

}
