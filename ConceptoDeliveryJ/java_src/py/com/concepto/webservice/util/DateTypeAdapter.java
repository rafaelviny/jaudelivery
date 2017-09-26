package py.com.concepto.webservice.util;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Custom Date adapter for use with GSON. This handles ISO 8601 and simple yyyy-MM-dd formats.
 * <p>
 * This was needed as, at the time of writing, the api returns "DateTime" objects in the typical
 * ISO 8601 format and "Date" objects in a "yyyy-MM-dd format. This helps cleanly marshall dates &
 * date time into Date objects.
 * <p>
 * See http://stackoverflow.com/questions/27512307/in-gson-retrofit-is-there-a-built-in-way-to-handle-dates-of-varying-formats
 */
public class DateTypeAdapter extends TypeAdapter<Date> {
    final private DateFormat SIMPLE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            String date = ISO8601Utils.format(value);
            out.value(date);
        }
    }

    @Override
    public Date read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }

        String dateAsString = reader.nextString();
        if (dateAsString.length() == 10) { // assumes yyyy-MM-dd format
            try {
                return SIMPLE_FORMAT.parse(dateAsString);
            } catch (ParseException e) {
                throw new DateTypeParseException(dateAsString);
            }
        } else {
            try {
                return ISO8601Utils.parse(dateAsString, new ParsePosition(0));
            } catch (ParseException e) {
                throw new DateTypeParseException(dateAsString);
            }
        }
    }

    private class DateTypeParseException extends RuntimeException  {
        public DateTypeParseException(String attempt) {
            super("Unparseable date: " + attempt + ". It must be in ISO 8601 or \"yyyy-MM-dd\" format");
        }
    }
}
