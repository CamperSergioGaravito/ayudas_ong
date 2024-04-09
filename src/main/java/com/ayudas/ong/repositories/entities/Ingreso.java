package com.ayudas.ong.repositories.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.ayudas.ong.repositories.enums.TiposCuenta;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Ingresos")
public class Ingreso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
        name = "socio_id"
    )
    private Socio socio;

    @Enumerated(EnumType.STRING)
    private TiposCuenta tipoCuenta;

    private double cuota;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaPago;

    private void setCuota() {
        this.cuota = this.tipoCuenta.getCuota();
    }
}
