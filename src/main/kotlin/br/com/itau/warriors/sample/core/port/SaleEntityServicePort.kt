package br.com.itau.warriors.sample.core.port

import br.com.itau.warriors.sample.database.entity.SaleEntity
import javax.inject.Singleton

@Singleton
interface SaleEntityServicePort {

    fun saveSaleEntity(saleEntity: SaleEntity):SaleEntity

}