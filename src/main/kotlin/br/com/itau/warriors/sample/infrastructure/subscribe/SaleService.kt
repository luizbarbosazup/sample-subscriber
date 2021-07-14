package br.com.itau.warriors.sample.infrastructure.subscribe

import br.com.itau.warriors.sample.core.mapper.Convert
import br.com.itau.warriors.sample.core.port.SaleServicePort
import br.com.itau.warriors.sample.infrastructure.model.Event
import br.com.itau.warriors.sample.infrastructure.model.SaleInformation
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory

@NatsListener
class SaleService(private val service:SaleServicePort) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Subject("chanel.product.sale")
    fun receive(saleInformation: SaleInformation){
        logger.info("\n[ infrastructure | Recebendo do Nats ] : ${saleInformation}")

            when(saleInformation.eventEntity){
                Event.SAVE_SALE ->{
                    logger.info("[ Event received - SAVE_SALE ]")
                    service.saveSale(sale = Convert.saleInformationToSale(saleInformation = saleInformation))
                }
                Event.DELETE_SALE -> {
                    logger.info("[ Event received - DELETE_SALE ]")
//                    service.saveSale(sale = Convert.saleInformationToSale(saleInformation = saleInformation))

                }


            }


    }



}