package br.com.itau.warriors.sample.database.repository

import br.com.itau.warriors.sample.database.entity.SaleEntity
import javax.inject.Singleton

@Singleton
interface SaleEntityRepository {

    fun saveSaleCql(saleEntity: SaleEntity):SaleEntity
}