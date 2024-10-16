package com.lacunasoftware.signer;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.JsonParseException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class EnumTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings("unchecked")
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();
        if (!rawType.isEnum()) {
            return null; // Not an enum type, let Gson handle it normally
        }

        return (TypeAdapter<T>) new EnumAdapter<>((Class<Enum>) rawType);
    }

    private static class EnumAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Class<T> enumType;

        public EnumAdapter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public void write(JsonWriter out, T value) throws IOException {
            if (value == null) {
                out.nullValue();  // Write null if the enum value is null
            } else {
                out.value(value.toString());  // Serialize using the enum's toString()
            }
        }

        @Override
        public T read(JsonReader in) throws IOException {
            if (in.peek() == com.google.gson.stream.JsonToken.NULL) {
                in.nextNull();  // Gracefully handle null during deserialization
                return null;
            }

            String jsonValue = in.nextString();
            for (T constant : enumType.getEnumConstants()) {
                if (constant.toString().equalsIgnoreCase(jsonValue.trim())) {
                    return constant;  // Case-insensitive matching
                }
            }

            // Handle unknown values by throwing an exception
            throw new JsonParseException("Unknown enum value: " + jsonValue);
        }
    }
}

