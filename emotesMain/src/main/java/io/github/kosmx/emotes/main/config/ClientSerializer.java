package io.github.kosmx.emotes.main.config;


import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import io.github.kosmx.emotes.main.EmoteHolder;
import io.github.kosmx.emotes.common.SerializableConfig;
import io.github.kosmx.emotes.server.config.Serializer;

import java.util.List;

public class ClientSerializer extends Serializer {


    @Override
    public void registerTypeAdapters(GsonBuilder builder){

        JsonDeserializer<SerializableConfig> configSerializer = new ClientConfigSerializer();
        JsonSerializer<SerializableConfig> configDeserializer = new ClientConfigSerializer();
        JsonDeserializer<List<EmoteHolder>> emoteDeserializer = new EmoteSerializer();
        JsonSerializer<EmoteHolder> emoteSerializer = new EmoteSerializer();
        builder.registerTypeAdapter(ClientConfig.class, configDeserializer);
        builder.registerTypeAdapter(ClientConfig.class, configSerializer);
        builder.registerTypeAdapter(new TypeToken<List<EmoteHolder>>(){}.getType(), emoteDeserializer);
        builder.registerTypeAdapter(EmoteHolder.class, emoteSerializer);
    }


}
