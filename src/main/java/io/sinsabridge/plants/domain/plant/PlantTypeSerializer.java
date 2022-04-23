package io.sinsabridge.plants.domain.plant;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class PlantTypeSerializer extends StdSerializer {

    public PlantTypeSerializer() {
        super(PlantType.class);
    }

    public PlantTypeSerializer(Class cls) {
        super(cls);
    }

    @Override
    public void serialize(Object value,
                          JsonGenerator gen,
                          SerializerProvider provider) throws IOException {

        PlantType plantType = (PlantType) value;

        gen.writeStartObject();
        gen.writeFieldName("code");
        gen.writeString(plantType.name());

        gen.writeFieldName("name");
        gen.writeString(plantType.getName());

        gen.writeEndObject();
    }
}
