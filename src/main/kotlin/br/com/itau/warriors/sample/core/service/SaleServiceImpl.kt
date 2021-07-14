package br.com.itau.warriors.sample.core.service

import br.com.itau.warriors.sample.core.mapper.Convert
import br.com.itau.warriors.sample.core.model.Sale
import br.com.itau.warriors.sample.core.port.SaleEntityServicePort
import br.com.itau.warriors.sample.core.port.SaleServicePort
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class SaleServiceImpl(private val saleEntityServicePort: SaleEntityServicePort):SaleServicePort {

    private val logger = LoggerFactory.getLogger(this::class.java)
    override fun saveSale(sale: Sale) {
        logger.info("\nEstou na service do core recebendo um Sale : ${sale}")
        saleEntityServicePort.saveSaleEntity(Convert.saleToSaleEntity(sale = sale))
    }

}