package br.com.itau.warriors.sample.core.mapper

import br.com.itau.warriors.sample.core.model.Sale
import br.com.itau.warriors.sample.database.entity.SaleEntity
import br.com.itau.warriors.sample.infrastructure.model.SaleInformation

class Convert {
    companion object{
//        fun saleInfraToSaleInformation(saleEventInformation: SaleInformation) =
//            SaleInformation(eventEntity = saleEventInformation.eventEntity,saleEntity = saleEventInformation.saleEntity)

        fun saleToSaleEntity(sale:Sale)=
            SaleEntity(productid = sale.productid, qty = sale.qty)

        //recebo da infra os dados no Nats e converto para Sale do meu Core
        fun saleInformationToSale(saleInformation: SaleInformation)=
            Sale(
                productid = saleInformation.saleEntity.productid,
                qty = saleInformation.saleEntity.qty)


    }
}