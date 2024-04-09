package com.ayudas.ong.repositories.enums;

public enum TiposCuenta {
    MINIMA(10),
    MEDIA(20),
    MAXIMA(30);

    private double cuota;

    private TiposCuenta(double cuota) {
        this.cuota = cuota;
    }

    public double getCuota() {
        return cuota;
    }
}
