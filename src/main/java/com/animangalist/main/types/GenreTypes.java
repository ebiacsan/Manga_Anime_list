package com.animangalist.main.types;

public enum GenreTypes {
    ACAO,
    AVENTURA,
    TERROR,
    LUTA,
    ESPORTE;

    public static GenreTypes getById(Integer id) {
        if(GenreTypes.values().length < id)
            return GenreTypes.values()[id];
        return null;
    }
}
