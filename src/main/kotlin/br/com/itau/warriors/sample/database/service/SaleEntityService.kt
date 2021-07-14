package br.com.itau.warriors.sample.database.service

import br.com.itau.warriors.sample.core.port.SaleEntityServicePort
import br.com.itau.warriors.sample.database.entity.SaleEntity
import br.com.itau.warriors.sample.database.repository.SaleEntityRepository
import javax.inject.Singleton

@Singleton
class SaleEntityService(private val repository: SaleEntityRepository): SaleEntityServicePort {

    override fun saveSaleEntity(saleEntity: SaleEntity):SaleEntity {
        return repository.saveSaleCql(saleEntity = saleEntity)
    }
}