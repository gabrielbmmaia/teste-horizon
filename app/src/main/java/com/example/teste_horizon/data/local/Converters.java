package com.example.teste_horizon.data.local;

import androidx.room.TypeConverter;

public class Converters {

    @TypeConverter
    public static int booleanToInt(boolean value) {
        return value ? 1 : 0;
    }

    @TypeConverter
    public static boolean intToBoolean(int value) {
        return value != 0;
    }
}
