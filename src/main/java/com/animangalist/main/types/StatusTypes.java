package com.animangalist.main.types;

public enum StatusTypes {
    CONCLUIDO,
    CANCELADO,
    EM_ANDAMENTO,
    HIATUS;

    public static StatusTypes getById(Integer id) {
        if(StatusTypes.values().length < id)
            return StatusTypes.values()[id];
        return null;
    }
}
